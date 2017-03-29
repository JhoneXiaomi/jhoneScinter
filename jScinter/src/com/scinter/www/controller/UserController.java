package com.scinter.www.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.scinter.www.dao.RoleMapper;
import com.scinter.www.dao.SysConfigMapper;
import com.scinter.www.dao.SysLogMapper;
import com.scinter.www.dao.UserMapper;
import com.scinter.www.listener.ApplicationConstants;
import com.scinter.www.model.OnlineUserInfo;
import com.scinter.www.model.Role;
import com.scinter.www.model.SysConfigExample;
import com.scinter.www.model.SysLog;
import com.scinter.www.model.User;
import com.scinter.www.model.UserExample;
import com.scinter.www.model.UserExample.Criteria;
import com.scinter.www.util.DateUtil;
import com.scinter.www.util.JsonPrintUtil;
import com.scinter.www.util.Page;
import com.scinter.www.util.SendEmailUtil;
import com.scinter.www.util.SysLogUtil;
import com.scinter.www.util.TableName;

@Controller
@RequestMapping("admin")
public class UserController {

	private Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired  
    private Producer captchaProducer = null;
	@Autowired
	private SysConfigMapper sysConfigMapper;
	@Autowired
	private SysLogMapper sysLogMapper;
	
	private Object getValueByKeyName(String keyName) {
		SysConfigExample cx = new SysConfigExample();
		SysConfigExample.Criteria criteria = cx.createCriteria();
		criteria.andKeyNameEqualTo(keyName);
		Object oValue = sysConfigMapper.selectByExample(cx).get(0).getValue();
		return oValue;
	}
	
	@RequestMapping("onlineUserListToJson")
	@ResponseBody
	public void onlineUserListToJson(@RequestParam("page") int page,@RequestParam("rows") int rows,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		OnlineUserInfo cu = null;
		List<OnlineUserInfo> onlineUserList = new ArrayList<OnlineUserInfo>();
		for(String id : ApplicationConstants.SESSION_MAP.keySet()){ 
			HttpSession sess = ApplicationConstants.SESSION_MAP.get(id); 
			User user = (User)sess.getAttribute("UserInfo"); 
			if(null!=user){
				cu = new OnlineUserInfo();
				String username = user.getNickName();
				String createTime = sdf.format(sess.getCreationTime());
				String accessedTime = sdf.format(sess.getLastAccessedTime());
				String activeTimes = sess.getAttribute("activeTimes") + "";
				String ip = (String)sess.getAttribute("ip");
				cu.setSessionid(id);
				cu.setUserId(user.getUserName());
				cu.setUsername(username);
				cu.setAccessedTime(accessedTime);
				cu.setActiveTimes(activeTimes);
				cu.setCreateTime(createTime);
				cu.setIp(ip);
				if(StringUtils.isNotBlank(user.getUserName())){
					onlineUserList.add(cu);
				}
			}
		}
		int totalNums = onlineUserList.size();
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		
//		日志记录
		
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0, "", "在线用户列表信息");
		sysLogMapper.insert(sysLog);
		
		JsonPrintUtil.printGridData(response, onlineUserList, totalNums,"rows","total");
	}
	
	//验证码是否显示
	@RequestMapping("showKaptchaImageOrNot")
	@ResponseBody
	public void showKaptchaImageOrNot(HttpServletResponse response,HttpSession session) {
		String login_captcha = (String)getValueByKeyName("login_captcha");
		String scinter_login_bg = (String)getValueByKeyName("scinter_login_bg");
		try {
			session.setAttribute("scinter_login_bg", scinter_login_bg);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		Map<String,String> map = new HashMap<String,String>();
		map.put("bg_url", scinter_login_bg);
		map.put("login_captcha", login_captcha);
		
		JsonPrintUtil.printObjData(response, map);
	}
	
	
	//验证码是否显示
	@RequestMapping("getKaptchaCode")
	@ResponseBody
	public void getKaptchaCode(HttpServletResponse response,HttpSession session) {
		
		String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);		
		JsonPrintUtil.printObjData(response, code);
	}
	
	
	@RequestMapping("getKaptchaImage")
    public ModelAndView getKaptchaImage(HttpServletRequest request, HttpServletResponse response) {  
		HttpSession session = request.getSession();
		response.setDateHeader("Expires", 0);
		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control","no-store, no-cache, must-revalidate");
		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");
		// return a jpeg
		response.setContentType("image/jpeg");
		// create the text for the image
		String capText = captchaProducer.createText();
		// store the text in the session
		session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
		// create the image with the text
		BufferedImage bi = captchaProducer.createImage(capText);
		try {
			ServletOutputStream out = response.getOutputStream();
			ImageIO.write(bi, "jpg", out);
			out.flush();
			out.close();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return null;
    }

	// 登录逻辑判断
	private void loginJudge(User user, String userName, String password,
			ModelAndView model, HttpSession session) {

		// 账号相关安全设置
		String account_case = (String) getValueByKeyName("account_case");// 用户帐户区分大小写
		String default_password = (String) getValueByKeyName("default_password");// 用户默认密码
		String session_timeout = (String) getValueByKeyName("session_timeout");// 会话失效时间
		String default_password_validity_time = (String) getValueByKeyName("default_password_validity_time");// 默认密码有效期
		//左上方logo URL
		String scinter_logo_url = (String) getValueByKeyName("scinter_logo_url");// 左上方logo URL
		
		int default_password_validity_time_int = Integer
				.parseInt(default_password_validity_time);

		if ("0".equals(account_case)) {
			// 账号不区分大小写
			userName = userName.toLowerCase();
			User loginUser = new User();
			loginUser.setUserName(userName);
			loginUser.setPassword(password);
			user = userMapper.selectForloginLowerCase(loginUser);
		} else if ("1".equals(account_case)) {
			// 账号区分大小写
			User loginUser = new User();
			loginUser.setUserName(userName);
			loginUser.setPassword(password);
			user = userMapper.selectForlogin(loginUser);
		}
		if (null != user) {
			if (user.getStatus() == 1) {
				logger.info("用户: " + user.getNickName() + " 已登录成功.");
				Role role = roleMapper.selectByPrimaryKey(user.getRoleId());
				// 把用户和角色信息放入session
				session.setAttribute("UserInfo", user);
				session.setAttribute("Role", role);
				session.setAttribute("scinter_logo_url", scinter_logo_url);
				
				// 登录后从系统配置表查询并设置session失效时间
				int maxInactiveInterval = Integer.parseInt(session_timeout);// 单位分钟
				session.setMaxInactiveInterval(maxInactiveInterval * 60);

				model.addObject("userInfo", user);
				if (password.equals(default_password)) {
					// 第一次登陆 请首先修改密码
					session.setAttribute("firstLogin", 1);
					// 默认密码超过有效期default_password_validity_time
					long days = (DateUtil.getTimeInHours(user.getCreateTime(),
							new Date())) / 24;
					int overdue_days = Math.round(days);
					if (overdue_days > default_password_validity_time_int) {
						model.addObject("errorInfo", "默认密码已经过期，请联系管理员！");
						model.setViewName("/admin/index");
					} else {
						model.setViewName("/admin/scinter_index");
					}
				} else {
					// 正常登陆
					session.setAttribute("firstLogin", 0);
					model.setViewName("/admin/scinter_index");
				}
				// 记录用户的登录日志
				SysLog sysLog = new SysLog();
				sysLog = SysLogUtil.login(session, user.getUserId(),
						TableName.user, "系统");
				sysLogMapper.insert(sysLog);
			} else {
				model.addObject("errorInfo", "账号已停用或不存在，请重新登录!");
				model.setViewName("/admin/index");
			}
		} else {
			model.addObject("errorInfo", "账号密码错误，请重新登录!");
			model.setViewName("/admin/index");
		}
	}
	
	// 登录方法 login method
	@RequestMapping("index")
	public ModelAndView systemLogin(String userName, String password,
			String kaptcha, String showKaptchaImageOrNot,
			HttpServletRequest request, HttpSession session) {

		userName = StringUtils.isBlank(userName) ? "" : userName;
		password = StringUtils.isBlank(password) ? "" : password;
		kaptcha = StringUtils.isBlank(kaptcha) ? "" : kaptcha;
		showKaptchaImageOrNot = StringUtils.isBlank(showKaptchaImageOrNot) ? ""	: showKaptchaImageOrNot;

		ModelAndView model = new ModelAndView();
		String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if (showKaptchaImageOrNot.equals("1")) {
			// logger.info("******************验证码是: " + code+
			// "******************");
			if (null == code || null == kaptcha) {
				model.addObject("errorInfo", "验证码已经过期，请重新登录!");
				model.setViewName("/admin/index");
				return model;
			}
			if (kaptcha.equals(code)) {
				// String passwordMd5 =
				// DigestUtils.md5DigestAsHex(password.getBytes());
				User user = null;
				loginJudge(user, userName, password, model, session);
			} else {
				model.addObject("errorInfo", "验证码错误,请重新输入!");
				model.setViewName("/admin/index");
			}
		} else if (showKaptchaImageOrNot.equals("0")) {
			// 登陆不包含验证码
			User user = null;
			loginJudge(user, userName, password, model, session);
		}
		return model;
	}

	@RequestMapping("loginout")
	public String loginout(HttpSession session){
		User user = (User)session.getAttribute("UserInfo");
		if(null!=user){
			logger.info("用户: "+user.getNickName()+" 已注销登录.");
//		用户注销记录日志
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.loginOut(session, user.getUserId(), TableName.user, "登录");
			sysLogMapper.insert(sysLog);
		}
		
		
		
		session.removeAttribute("UserInfo");
		session.invalidate();
		return "/admin/index";
	}
	
	// 强制下线
	@RequestMapping("offLine")
	@ResponseBody
	public void offLine(@RequestParam("sessionIds") String sessionIds,HttpServletResponse response,HttpSession session) {
		User user = (User)session.getAttribute("UserInfo");
		if (!StringUtils.isBlank(sessionIds)) {
			String[] sessionIdArr = sessionIds.split(",");
			for (int i = 0; i < sessionIdArr.length; i++) {
				logger.info("用户:"+user.getUserName()+"于"+DateUtil.getStr(new Date(), DateUtil.DATE_TIME_FORMAT)+"被管理员强制下线!");
				
//				被管理员强制下线
				SysLog sysLog =new SysLog();		
				sysLog =SysLogUtil.loginOut(session, user.getUserId(), TableName.user,"被管理员强制下线");
				sysLogMapper.insert(sysLog);
				
		
				ApplicationConstants.SESSION_MAP.get(sessionIdArr[i]).invalidate();
				ApplicationConstants.SESSION_MAP.remove(sessionIdArr[i]);
			}
		}
		JsonPrintUtil.printObjData(response, "ok");
	}
	
	@RequestMapping("listUserToJson")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void listUserToJson(@RequestParam("page") int page,@RequestParam("rows") int rows,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		
		//分页条件查询
		UserExample ux = new UserExample();		
		Criteria criteria = ux.createCriteria();
		criteria.andStatusNotEqualTo(3);//非删除状态
		int totalNums = userMapper.countByExample(ux);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		ux.setPage(p);
		ux.setOrderByClause("create_time desc");//排序
		List<User> userList4Page = userMapper.selectByExample(ux);
		for(User u : userList4Page){
			int roleId = u.getRoleId();
			Role role = roleMapper.selectByPrimaryKey(roleId);
			u.setRoleName(role.getRoleName());
		}
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0, TableName.user, "用户列表信息");
		sysLogMapper.insert(sysLog);
		
		JsonPrintUtil.printGridData(response, userList4Page, totalNums,"rows","total");
	}
	
	@RequestMapping("searchListUser")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void searchListUser(@RequestParam("page") int page,@RequestParam("rows") int rows,String keyWord,HttpSession session ,HttpServletRequest request,HttpServletResponse response) {
		UserExample ux = new UserExample();
		if (StringUtils.isNotBlank(keyWord)) {
			keyWord = "%" + keyWord + "%";
			//分页条件查询
			//and or联合查询
			ux.or().andUserNameLike(keyWord).andStatusNotEqualTo(3);
			ux.or().andNickNameLike(keyWord).andStatusNotEqualTo(3);
			ux.or().andPhoneLike(keyWord).andStatusNotEqualTo(3);
		}else{
			UserExample.Criteria criteria = ux.createCriteria();
			criteria.andStatusNotEqualTo(3);//非删除状态
		}
		int totalNums = userMapper.countByExample(ux);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		ux.setPage(p);
		ux.setOrderByClause("create_time desc");//排序
		List<User> userList4Page = userMapper.selectByExample(ux);
		for(User u : userList4Page){
			int roleId = u.getRoleId();
			Role role = roleMapper.selectByPrimaryKey(roleId);
			u.setRoleName(role.getRoleName());
		}
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0, TableName.user, "用户列表信息");
		sysLogMapper.insert(sysLog);
		
		JsonPrintUtil.printGridData(response, userList4Page, totalNums,"rows","total");
	}
	
	@RequestMapping("showUser")
	public ModelAndView showUser(int userId,HttpSession session){
		ModelAndView model = new ModelAndView();
		User user = userMapper.selectByPrimaryKey(userId);
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, user.getUserId(), TableName.user, user.getNickName()+"信息");
		sysLogMapper.insert(sysLog);
		model.addObject("userInfo", user);
		model.setViewName("/admin/userSave");
		return model;
	}
	
	@RequestMapping("checkUserId")
	@ResponseBody
	public void checkUserId(@RequestParam("userId") String userId,HttpServletResponse response) {
		UserExample ux = new UserExample();
		UserExample.Criteria criteria = ux.createCriteria();
		criteria.andStatusNotEqualTo(3);//非删除状态
		criteria.andUserNameEqualTo(userId);
		List<User> u = userMapper.selectByExample(ux);
		if(null!=u && u.size()>0){
			JsonPrintUtil.printObjData(response, "ok");			
		}else{
			JsonPrintUtil.printObjData(response, "fail");						
		}
	}
	
	@RequestMapping("checkSystemPasswordSafe")
	@ResponseBody
	public void checkSystemPasswordSafe(HttpServletResponse response) {
		//密码安全选项
		String password_min_length = (String)getValueByKeyName("password_min_length");//用户密码长度控制
		String new_password_repeat = (String)getValueByKeyName("new_password_repeat");//用户密码修改控制 新密码不能与当前密码相同
		String new_password_uppercase = (String)getValueByKeyName("new_password_uppercase");//用户密码复杂度控制 大写字符个数
		String new_password_lowercase = (String)getValueByKeyName("new_password_lowercase");//用户密码复杂度控制 小写字符个数
		String new_password_number = (String)getValueByKeyName("new_password_number");//用户密码复杂度控制 数字个数
		
		Map<String,String> configMap = new HashMap<String,String>();
		configMap.put("password_min_length", password_min_length);
		configMap.put("new_password_repeat", new_password_repeat);
		configMap.put("new_password_uppercase", new_password_uppercase);
		configMap.put("new_password_lowercase", new_password_lowercase);
		configMap.put("new_password_number", new_password_number);
		JsonPrintUtil.printObjData(response, configMap);
	}
	
	@RequestMapping("resetUsersPassword")
	@ResponseBody
	public void resetUsersPassword(String userIds,String newPWD,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		User currentLoginUser = (User)request.getSession().getAttribute("UserInfo");
		//邮件发送配置
		String email_send_flag = (String)getValueByKeyName("new_password_email");//密码重置邮件通知
		String smtp_server = (String)getValueByKeyName("smtp_server");//邮件SMTP服务器
		String email_address = (String)getValueByKeyName("email_address");//自动发送邮件的邮箱地址
		String email_password = (String)getValueByKeyName("email_password");//邮箱密码
		//String session_update_time = (String)getValueByKeyName("session_update_time");//用户在线状态更新间隔
		
		if(!StringUtils.isBlank(userIds) && !StringUtils.isBlank(newPWD)){
			String[] userId = userIds.split(",");
			for(int i=0;i<userId.length;i++){
				int uId = Integer.parseInt(userId[i]);
				User u = userMapper.selectByPrimaryKey(uId);
				String passwordMd5 = DigestUtils.md5DigestAsHex(newPWD.getBytes());
				u.setPassword(passwordMd5);
				u.setUpdateTime(new Date());
				u.setUpdater(currentLoginUser.getUserName());
				userMapper.updateByPrimaryKeySelective(u);
				JsonPrintUtil.printObjData(response, "ok");
				//用户邮箱不为空则发送邮件重置密码通知
				if(email_send_flag.equals("1") && StringUtils.isNotBlank(u.getEmail())){
					String dateTimeStr = DateUtil.getStr(new Date(), DateUtil.DATE_TIME_FORMAT_CN);
					String content = "您好！管理员于"+dateTimeStr+"成功重置了您的密码,您的新密码为： "+newPWD+" ，请牢记此新密码！";
					try {
						SendEmailUtil.sendEmail( smtp_server, 25, email_address, email_password, email_address, u.getEmail(), "用户密码重置邮件通知", content);
					} catch (EmailException e) {
						logger.info(e.getMessage());
						SysLog sysLog = new SysLog();
						sysLog =SysLogUtil.edit(session, u.getUserId(), "", "重置密码提醒邮件发送异常");
						sysLogMapper.insert(sysLog);
					}
				}
				//日志记录
				SysLog sysLog = new SysLog();
				sysLog =SysLogUtil.edit(session, u.getUserId(), TableName.user, "用户密码");
				sysLogMapper.insert(sysLog);
			}
		}else{
			JsonPrintUtil.printObjData(response, "fail");
		}
	}
	
	@RequestMapping("saveUser")
	@ResponseBody
	public void saveUser(User user,HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		int num = 0;
		User currentLoginUser = (User)request.getSession().getAttribute("UserInfo");
		if(null==user.getUserId()){
			user.setCreateTime(new Date());
			user.setCreater(currentLoginUser.getUserName());
			user.setUpdateTime(new Date());
			user.setStatus(1);//正常 1 禁止 2 删除 3
			String default_Password = (String)getValueByKeyName("default_password");
			String passwordMd5 = DigestUtils.md5DigestAsHex(default_Password.getBytes());
			user.setPassword(passwordMd5);
			if(null!=user.getRoleId()){//角色不能为空才添加	
				num = userMapper.insert(user);
				
//				日志记录添加用户
				SysLog sysLog = new SysLog();
				sysLog =SysLogUtil.add(session, user.getUserId(), TableName.user, "用户"+user.getUserName());
				
				sysLogMapper.insert(sysLog);
			}
		}else{
			user.setUpdateTime(new Date());
			user.setUpdater(currentLoginUser.getUserName());
			num = userMapper.updateByPrimaryKeySelective(user);//只更新传值的字段
//			日志记录添加用户
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.edit(session, user.getUserId(), TableName.user, "用户信息");
			sysLogMapper.insert(sysLog);
			
			
		}
		if(num>0){	
			JsonPrintUtil.printObjData(response, "ok");
		}
	}
	
	@RequestMapping("updateUserStatus")
	@ResponseBody
	public void delUser(String userIds,int status,HttpSession session,HttpServletResponse response) {
		User currentLoginUser = (User)session.getAttribute("UserInfo");
		if(!StringUtils.isBlank(userIds)){
			String[] userId = userIds.split(",");
			for(int i=0;i<userId.length;i++){
				int uId = Integer.parseInt(userId[i]);
				//userMapper.deleteByPrimaryKey(uId);//物理删除
				User u = userMapper.selectByPrimaryKey(uId);
				
//				日志记录
				SysLog sysLog = new SysLog();
				sysLog =SysLogUtil.edit(session, u.getUserId(), TableName.user, "用户状态");
				sysLogMapper.insert(sysLog);
				
				u.setStatus(status);//1正常 2停用 3已删除 
				u.setUpdateTime(new Date());
				u.setUpdater(currentLoginUser.getUserName());
				userMapper.updateByPrimaryKeySelective(u);
				
				
			}
			JsonPrintUtil.printObjData(response, "ok");
		}else{
			JsonPrintUtil.printObjData(response, "fail");
		}
	}
	
	//=============================================================
	/*
	
	@RequestMapping("get")
	@ResponseBody
	public Object get(int userId) {
		return userMapper.selectByPrimaryKey(userId);
	}
	
	@RequestMapping("getUserJson")
	@ResponseBody
	public void get(int userId,HttpServletResponse response) {
		JsonPrintUtil.printJsonObj(response,userMapper.selectByPrimaryKey(userId));
	}

	@RequestMapping("add")
	@ResponseBody
	public int add() {
		User u = new User();
		u.setUserName("xun.liu"+Math.random());
		u.setNickName("测试帐号"+Math.random()*1000%3);
		u.setEmail("liuxun@prnasia.com");
		u.setCreater("liuxun");
		u.setCreateTime(new Date());
		u.setUpdateTime(new Date());
		u.setUpdater("liuxun");
		u.setPassword("123456");
		u.setStatus(1);
		return userMapper.insert(u);
	}

	//@NumberFormat 
	//@DateTimeFormat
	
	// @PathVariable 从路径里面去获取变量，也就是把路径当做变量，
	// @RequestParam 从url请求里面获取参数

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam("userId") String userId) {

		logger.info("loginId: " + userId);

		// 1、收集参数、验证参数
		// 2、绑定参数到命令对象
		// 3、将命令对象传入业务对象进行业务处理
		// 4、选择下一个页面
		ModelAndView mv = new ModelAndView();
		// 添加模型数据 可以是任意的POJO对象
		mv.addObject("message", "login success！");
		// 设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "update/{userId}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("userId") String userId) {

		logger.info("update: " + userId);
		ModelAndView mv = new ModelAndView();
		// 添加模型数据 可以是任意的POJO对象
		mv.addObject("message", "update success！");
		// 设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
		mv.setViewName("index");
		return mv;

	}
	
	@RequestMapping("listUserTest")
	public ModelAndView userList() {
		ModelAndView model = new ModelAndView();

		//条件查询
		UserExample ux = new UserExample();
		Criteria criteria = ux.createCriteria();
		criteria.andStatusEqualTo(1);
		
		List<User> userList = userMapper.selectByExample(ux);
		// 添加模型数据 可以是任意的POJO对象
		model.addObject("userList", userList);

		// 设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
		model.setViewName("/www/userListTest");
		return model;
	}
*/
	
}
