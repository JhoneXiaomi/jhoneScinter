package com.scinter.www.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.scinter.www.dao.SysConfigMapper;
import com.scinter.www.dao.SysLogMapper;
import com.scinter.www.model.Role;
import com.scinter.www.model.SysConfig;
import com.scinter.www.model.SysConfigExample;
import com.scinter.www.model.SysConfigExample.Criteria;
import com.scinter.www.model.SysLog;
import com.scinter.www.model.User;
import com.scinter.www.util.DateUtil;
import com.scinter.www.util.JsonPrintUtil;
import com.scinter.www.util.MySQLDatabaseBackup;
import com.scinter.www.util.SysLogUtil;
import com.scinter.www.util.SystemConfig;
import com.scinter.www.util.TableName;

@Controller
@RequestMapping("admin")
public class SysConfigController extends BaseController{
	
	private Logger logger = Logger.getLogger(SysConfigController.class);
	@Autowired
	private SysConfigMapper sysConfigMapper;
	@Autowired
	private SysLogMapper sysLogMapper;
	
	private Object getValueByKeyName(String keyName) {
		SysConfigExample cx = new SysConfigExample();
		SysConfigExample.Criteria criteria = cx.createCriteria();
		criteria.andKeyNameEqualTo(keyName);
		Object oValue = null;
		List<SysConfig> sysList = sysConfigMapper.selectByExample(cx);
//	       防止获取的值为空从而报505 
		if(sysList.size()!= 0){
			oValue = sysConfigMapper.selectByExample(cx).get(0).getValue();
		}
		return oValue;
	}
	private Object getValueByKeyName(String keyName,String branchCompany) {
		SysConfigExample cx = new SysConfigExample();
		SysConfigExample.Criteria criteria = cx.createCriteria();
		criteria.andKeyNameEqualTo(keyName);
		criteria.andBranchCompanyEqualTo(branchCompany);
		Object oValue = null;
		List<SysConfig> sysList = sysConfigMapper.selectByExample(cx);
//	       防止获取的值为空从而报505 
		if(sysList.size()!= 0){
			oValue = sysConfigMapper.selectByExample(cx).get(0).getValue();
		}
	
		return oValue;
	}

	private void updateValueByKeyName(String keyName,String newVal,String note,String branchCompany) {
		SysConfigExample cx = new SysConfigExample();
		SysConfigExample.Criteria criteria = cx.createCriteria();
		criteria.andKeyNameEqualTo(keyName);
		criteria.andBranchCompanyEqualTo(branchCompany);
		SysConfig sc = (SysConfig)sysConfigMapper.selectByExample(cx).get(0);
		sc.setValue(newVal);
		sc.setNote(note);
		sysConfigMapper.updateByPrimaryKeySelective(sc);
	}
	private void updateValueByKeyName(String keyName,String newVal) {
		SysConfigExample cx = new SysConfigExample();
		SysConfigExample.Criteria criteria = cx.createCriteria();
		criteria.andKeyNameEqualTo(keyName);
		SysConfig sc = (SysConfig)sysConfigMapper.selectByExample(cx).get(0);
		sc.setValue(newVal);
		sysConfigMapper.updateByPrimaryKeySelective(sc);
	}
	private Integer insertImg(String keyName,String value,String note,String branchCompany){
		SysConfig sysConfig = new SysConfig();
		sysConfig.setKeyName(keyName);
		sysConfig.setValue(value);
		sysConfig.setNote(note);
		sysConfig.setBranchCompany(branchCompany);
		sysConfigMapper.insert(sysConfig);
		Integer imageId = sysConfig.getConfigId();
		return imageId;
	}
	private void insertOrUpdata(String kayName,String newVal,String note,String branchCompany){
		
		SysConfigExample sysConfigExample = new SysConfigExample();
		Criteria criter = sysConfigExample.createCriteria();
		criter.andBranchCompanyEqualTo(branchCompany);
		criter.andKeyNameEqualTo(kayName);
		if(sysConfigMapper.selectByExample(sysConfigExample).size()>0){
			
			updateValueByKeyName(kayName,newVal,note,branchCompany);
		}else{
			
			insertImg(kayName,newVal,note,branchCompany);
		}
	}
	@RequestMapping("showSysSafe")
	public ModelAndView showSysSafe(){
		ModelAndView model = new ModelAndView();
		
		String account_case = (String)getValueByKeyName("account_case"); //用户帐户区分大小写
		String default_password = (String)getValueByKeyName("default_password");//用户默认密码
		String default_password_validity_time = (String)getValueByKeyName("default_password_validity_time");//默认密码有效期
		String login_captcha = (String)getValueByKeyName("login_captcha");//登录随机验证码
		String password_min_length = (String)getValueByKeyName("password_min_length");//用户密码长度控制
		String new_password_repeat = (String)getValueByKeyName("new_password_repeat");//用户密码修改控制 新密码不能与当前密码相同
		String new_password_uppercase = (String)getValueByKeyName("new_password_uppercase");//用户密码复杂度控制 大写字符个数
		String new_password_lowercase = (String)getValueByKeyName("new_password_lowercase");//用户密码复杂度控制 小写字符个数
		String new_password_number = (String)getValueByKeyName("new_password_number");//用户密码复杂度控制 数字个数
		String new_password_email = (String)getValueByKeyName("new_password_email");//密码重置邮件通知
		String session_timeout = (String)getValueByKeyName("session_timeout");//会话失效时间
		String session_update_time = (String)getValueByKeyName("session_update_time");//用户在线状态更新间隔
		
		model.addObject("account_case", account_case);
		model.addObject("default_password", default_password);
		model.addObject("default_password_validity_time", default_password_validity_time);
		model.addObject("login_captcha", login_captcha);
		model.addObject("password_min_length", password_min_length);
		model.addObject("new_password_repeat", new_password_repeat);
		model.addObject("new_password_uppercase", new_password_uppercase);
		model.addObject("new_password_lowercase", new_password_lowercase);
		model.addObject("new_password_number", new_password_number);
		model.addObject("new_password_email", new_password_email);
		model.addObject("session_timeout", session_timeout);
		model.addObject("session_update_time", session_update_time);
		model.setViewName("/admin/sys_safe");
		return model;
	}
	
	@RequestMapping("saveSystemConfig")
	@ResponseBody
	public void saveSystemConfig(SystemConfig scf,HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		logger.debug("进入系统安全设置");
		//User currentLoginUser = (User)request.getSession().getAttribute("UserInfo");
//		获取分公司的信息
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
		/*系统安全选项配置*/
		int account_case = scf.getAccount_case(); //用户帐户区分大小写
		String default_password = scf.getDefault_password();//用户默认密码
		int default_password_validity_time = scf.getDefault_password_validity_time();//默认密码有效期
		int login_captcha = scf.getLogin_captcha();//登录随机验证码
		int password_min_length = scf.getPassword_min_length();//用户密码长度控制
		int new_password_repeat = scf.getNew_password_repeat();//用户密码修改控制 新密码不能与当前密码相同
		int new_password_uppercase = scf.getNew_password_uppercase();//用户密码复杂度控制 大写字符个数
		int new_password_lowercase = scf.getNew_password_lowercase();//用户密码复杂度控制 小写字符个数
		int new_password_number = scf.getNew_password_number();//用户密码复杂度控制 数字个数
		int new_password_email = scf.getNew_password_email();//密码重置邮件通知
		int session_timeout = scf.getSession_timeout();//会话失效时间
		int session_update_time = scf.getSession_update_time();//用户在线状态更新间隔
		
		updateValueByKeyName("account_case",account_case+"");
		updateValueByKeyName("default_password",default_password+"");
		updateValueByKeyName("default_password_validity_time",default_password_validity_time+"");
		updateValueByKeyName("login_captcha",login_captcha+"");
		updateValueByKeyName("password_min_length",password_min_length+"");
		updateValueByKeyName("new_password_repeat",new_password_repeat+"");
		updateValueByKeyName("new_password_uppercase",new_password_uppercase+"");
		updateValueByKeyName("new_password_lowercase",new_password_lowercase+"");
		updateValueByKeyName("new_password_number",new_password_number+"");
		updateValueByKeyName("new_password_email",new_password_email+"");
		updateValueByKeyName("session_timeout",session_timeout+"");
		updateValueByKeyName("session_update_time",session_update_time+"");
		
		//系统操作日志记录
		
		logger.debug("系统安全设置保存成功");
		JsonPrintUtil.printObjData(response, "ok");
	}
	
	@RequestMapping("showSysOther")
	public ModelAndView showSysOther(){
		ModelAndView model = new ModelAndView();
		
		String login_bg = (String)getValueByKeyName("login_bg");//登录背景图片
		String server_upload_file_path = (String)getValueByKeyName("server_upload_file_path");//图片上传保存路径
		String scinter_website_name = (String)getValueByKeyName("scinter_website_name");//三创网站名称
		String scinter_logo_url = (String)getValueByKeyName("scinter_logo_url");//三创后台logo
		String scinter_login_bg = (String)getValueByKeyName("scinter_login_bg");//三创后台登录背景图
		String smtp_server = (String)getValueByKeyName("smtp_server");//邮件SMTP服务器
		String email_address = (String)getValueByKeyName("email_address");//自动发送邮件的邮箱地址
		String email_password = (String)getValueByKeyName("email_password");//邮箱密码
		String database_password = (String)getValueByKeyName("database_password");//数据库密码
		String database_back_datetime = (String)getValueByKeyName("database_back_datetime");//数据库备份时间间隔 单位：天
		
		
		model.addObject("login_bg", login_bg);
		model.addObject("server_upload_file_path", server_upload_file_path);
		model.addObject("scinter_website_name", scinter_website_name);
		model.addObject("scinter_logo_url", scinter_logo_url);
		model.addObject("scinter_login_bg", scinter_login_bg);
		model.addObject("smtp_server", smtp_server);
		model.addObject("email_address", email_address);
		model.addObject("email_password", email_password);
		model.addObject("database_password", database_password);
		model.addObject("database_back_datetime", database_back_datetime);
		model.setViewName("/admin/sys_other");
		return model;
	}
	
	@RequestMapping("saveOtherConfig")
	@ResponseBody
	public void saveOtherConfig(SystemConfig scf,HttpServletResponse response,HttpServletRequest request) {
		logger.debug("进入系统安全设置");
		//User currentLoginUser = (User)request.getSession().getAttribute("UserInfo");
		
		/*系统其他选项配置*/
		String login_bg = scf.getLogin_bg();//登录背景图片
		String server_upload_file_path = scf.getServer_upload_file_path();//图片上传保存路径
		String scinter_website_name = scf.getScinter_website_name();//三创网站名称
		String scinter_logo_url = scf.getScinter_logo_url();//三创后台logo
		String scinter_login_bg = scf.getScinter_login_bg();//三创后台登录背景图
		String smtp_server = scf.getSmtp_server();//邮件SMTP服务器
		String email_address = scf.getEmail_address();//自动发送邮件的邮箱地址
		String email_password = scf.getEmail_password();//邮箱密码
		//String database_password = scf.getDatabase_password();//数据库密码
		int database_back_datetime = scf.getDatabase_back_datetime();//数据库备份时间间隔 单位：天
		
		updateValueByKeyName("login_bg",login_bg+"");
		updateValueByKeyName("server_upload_file_path",server_upload_file_path+"");
		updateValueByKeyName("scinter_website_name",scinter_website_name+"");
		updateValueByKeyName("scinter_logo_url",scinter_logo_url+"");
		updateValueByKeyName("scinter_login_bg",scinter_login_bg+"");
		updateValueByKeyName("smtp_server",smtp_server+"");
		updateValueByKeyName("email_address",email_address+"");
		updateValueByKeyName("email_password",email_password+"");
		//updateValueByKeyName("database_password",database_password+"");
		updateValueByKeyName("database_back_datetime",database_back_datetime+"");
		//系统操作日志记录
		
		logger.debug("系统其他选项设置保存成功");
		JsonPrintUtil.printObjData(response, "ok");
	}
	
	
	// 展示图片上传
	@RequestMapping("/imgFileListUpload")
	@ResponseBody
	public void caseImgFileListUpload(
			@RequestParam(value="curBranchCompany",required=false,defaultValue="") String curBranchCompany,
			String imgType,HttpServletRequest request,
			HttpSession session, HttpServletResponse response,
			MultipartFile file) {
//		获取分公司的信息
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
		if(StringUtils.isNotBlank(curBranchCompany)){
			branchCompany = curBranchCompany;
		}
		User user = (User) request.getSession().getAttribute("UserInfo");
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			JSONObject json = new JSONObject();
			String path = "/images/" + super.uploadToFileUrl(file, request, session);
			Integer imageId=0;
			// 日志记录
			SysLog sysLog = new SysLog();
			// 图片信息入库
			if("1".equals(imgType)){
				logger.info("用户"+user.getNickName()+"上传系统左上方logo成功... 服务器保存路径为：" + path);
				updateValueByKeyName("scinter_logo_url",path);
				session.setAttribute("scinter_logo_url", path);
				sysLog = SysLogUtil.upload(session, 0 , TableName.sys_config, "系统左上方logo图片");
				sysLogMapper.insert(sysLog);
			}
			if("2".equals(imgType)){
				logger.info("用户"+user.getNickName()+"上传系统登录背景图成功... 服务器保存路径为：" + path);
				updateValueByKeyName("scinter_login_bg",path);
				session.setAttribute("scinter_login_bg", path);
				sysLog = SysLogUtil.upload(session, 0 , TableName.sys_config, "系统登录背景图片");
				sysLogMapper.insert(sysLog);
			}
			if("3".equals(imgType)){
				logger.info("用户"+user.getNickName()+"上传三创LOGO成功... 服务器保存路径为：" + path);
				insertOrUpdata("scinter_home_logo",path,"首页LOGO（PC）",branchCompany);		
				sysLog = SysLogUtil.upload(session, 0 , TableName.sys_config, "三创LOGO");
				sysLogMapper.insert(sysLog);
				
			}
			if("4".equals(imgType)){
				logger.info("用户"+user.getNickName()+"上传首页焦点轮转图片成功... 服务器保存路径为：" + path);
				imageId = insertImg("scinter_home_turnImgs",path,"首页焦点轮转图片",branchCompany);
				sysLog = SysLogUtil.add(session, 0 , TableName.sys_config, "首页焦点轮转图片");
				sysLogMapper.insert(sysLog);
			}
			if("5".equals(imgType)){
				logger.info("用户"+user.getNickName()+"上传首页装修风格图片(抽屉式效果)成功... 服务器保存路径为：" + path);
				imageId = insertImg("scinter_home_decorateImgs",path,"首页装修风格(抽屉式效果)图片",branchCompany);		
				sysLog = SysLogUtil.add(session, 0 , TableName.sys_config, "首页装修风格图片(抽屉式效果)");
				sysLogMapper.insert(sysLog);
			}
			if("6".equals(imgType)){
				logger.info("用户"+user.getNickName()+"上传首页底部二维码图片成功... 服务器保存路径为：" + path);
				insertOrUpdata("scinter_home_twoCodeImg",path,"首页底部二维码（PC站）",branchCompany);		
				sysLog = SysLogUtil.edit(session, 0 , TableName.sys_config, "首页底部二维码图片");
				sysLogMapper.insert(sysLog);
			}
			if("7".equals(imgType)){
				logger.info("用户"+user.getNickName()+"上传合作品牌成功... 服务器保存路径为：" + path);
				imageId = insertImg("scinter_home_coworkerImg",path,"合作品牌图片",branchCompany);	
				sysLog = SysLogUtil.add(session, 0 , TableName.sys_config, "首页合作品牌图片");
				sysLogMapper.insert(sysLog);
			}
			if("8".equals(imgType)){
				logger.info("用户"+user.getNickName()+"手机站焦点图上传成功... 服务器保存路径为：" + path);
				imageId = insertImg("Scinter_home_M_turnImgs",path,"手机站焦点图片",branchCompany);	
				sysLog = SysLogUtil.add(session, 0 , TableName.sys_config, "手机站焦点图片");
				sysLogMapper.insert(sysLog);
			}
			if("9".equals(imgType)){
				logger.info("用户"+user.getNickName()+"手机站底部二维码图上传成功... 服务器保存路径为：" + path);
				insertOrUpdata("scinter_home_M_twoCodeImg",path,"底部二维码（MP站）",branchCompany);	
				sysLog = SysLogUtil.add(session, 0 , TableName.sys_config, "手机站底部二维码图片");
				sysLogMapper.insert(sysLog);
			}
			if("10".equals(imgType)){
				logger.info("用户"+user.getNickName()+"手机站公司LOGO上传成功... 服务器保存路径为：" + path);
				insertOrUpdata("scinter_home_M_logoImg",path,"首页LOGO（MP站）",branchCompany);	
				sysLog = SysLogUtil.add(session, 0 , TableName.sys_config, "手机站LOGO图片");
				sysLogMapper.insert(sysLog);
			}
			json.put("url", path);
			json.put("imageId", imageId);
			out.print(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
	}
	
	//mysql数据库备份路径
		private static String path="D:/mysql_backup/";
		
		//数据库备份
		@RequestMapping("mysqlBackup")
		@ResponseBody
		public void mysqlBackup(String dbPWD,HttpServletResponse response,HttpServletRequest request) {		
			String fileName = DateUtil.getStr(new Date(),DateUtil.DATE_TIME_FORMAT_Str)+".sql";
			boolean flag = MySQLDatabaseBackup.exportDatabaseTool("127.0.0.1", "root", dbPWD, path, fileName, "nick");
			if(flag){
				SysLog sysLog = new SysLog();
				sysLog =SysLogUtil.backup(request.getSession(), 0, "", "数据库");
				sysLogMapper.insert(sysLog);
				JsonPrintUtil.printObjData(response, fileName);
			}else{
				JsonPrintUtil.printObjData(response, "fail");
			}
		}
		
		//sql文件下载
		@RequestMapping("download")    
	    public ResponseEntity<byte[]> download(String fileName) throws IOException {    
	        //sql文件存储路径
	        File file = new File(path+"/"+fileName);
	        if (!file.exists()) {// 如果目录不存在
	        	file.mkdirs();// 创建文件夹
	        }
	        HttpHeaders headers = new HttpHeaders();    
	        fileName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
	        headers.setContentDispositionFormData("attachment", fileName);   
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
	        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);    
	    }    
	
	/**
	 * 实现首页编辑设置的展示
	 * @return			返回ModelAndView 对象，实现页面的跳转和首页设置信息的转发
	 */
	@RequestMapping("showHomeConfig")
	public ModelAndView showHomeConfig(
			@RequestParam(value="homeCompany",required=false,defaultValue="") String homeCompany,
			HttpSession session){
		
		ModelAndView model = new ModelAndView();
		// 获取分公司的信息 
		Role currentRole= (Role)session.getAttribute("Role");
		String currentPer = currentRole.getRoleName();
		String branchCompany ="";
		if(currentPer.equals("超级管理员")){
			branchCompany = (String)session.getAttribute("controlledCompany");
			if(branchCompany.equals("xzzs"))
				branchCompany = "bjxz";
			else if(branchCompany.equals("sczs"))
				branchCompany = "bjsc";
			else if(branchCompany.equals("rbwzs1"))
				branchCompany = "sjzrbw1";
			else if(branchCompany.equals("rbwzs2"))
				branchCompany = "hsrbw2";
			else if(branchCompany.equals("rrlzs"))
				branchCompany = "sjzrrl";
		}
		else
			branchCompany = currentRole.getBranchCompany();

		if(StringUtils.isNotBlank(homeCompany))
			branchCompany = homeCompany;
		
		/*全局的SEO信息的获取*/
		String scinter_home_seo_title =(String)getValueByKeyName("scinter_home_seo_title", branchCompany);// SEO 标题
		String scinter_home_seo_keyword =(String)getValueByKeyName("scinter_home_seo_keyword", branchCompany);// SEO 关键字
		String scinter_home_seo_desc =(String)getValueByKeyName("scinter_home_seo_desc", branchCompany);// SEO 描述
		
		/*局部的SEO信息获取*/
		String scinter_package_seo_title = (String)getValueByKeyName("scinter_package_seo_title", branchCompany);//SEO标题 装修套餐
		String scinter_package_seo_keyword = (String)getValueByKeyName("scinter_package_seo_keyword", branchCompany);//SEO关键字装修套餐
		String scinter_package_seo_desc = (String)getValueByKeyName("scinter_package_seo_desc", branchCompany);//SEO描述装修套餐
		String scinter_cases_seoTitle_str = (String)getValueByKeyName("scinter_cases_seoTitle_str", branchCompany);//SEO标题装修案例
		String scinter_cases_seoKeyword_str = (String)getValueByKeyName("scinter_cases_seoKeyword_str", branchCompany);//SEO关键字装修案例
		String scinter_cases_seoDesc_str= (String)getValueByKeyName("scinter_cases_seoDesc_str", branchCompany);//SEO描述装修案例
		String scinter_news_seoTitle_str = (String)getValueByKeyName("scinter_news_seoTitle_str", branchCompany);//SEO标题热门活动
		String scinter_news_seoKeyword_str = (String)getValueByKeyName("scinter_news_seoKeyword_str", branchCompany);//SEO关键字热门活动
		String scinter_news_seoDesc_str =  (String)getValueByKeyName("scinter_news_seoDesc_str", branchCompany);//SEO描述热门活动
		String scinter_designer_seoTitle_str = (String)getValueByKeyName("scinter_designer_seoTitle_str", branchCompany);//SEO标题设计团队
		String scinter_designer_seoKeyword_str = (String)getValueByKeyName("scinter_designer_seoKeyword_str", branchCompany);//SEO关键字设计团队
		String scinter_designer_seoDesc_str = (String)getValueByKeyName("scinter_designer_seoDesc_str", branchCompany);//SEO描述设计团队
		String scinter_spe_seoTitle_str = (String)getValueByKeyName("scinter_spe_seoTitle_str", branchCompany);//SEO标题说装修
		String scinter_spe_seoKeyword_str = (String)getValueByKeyName("scinter_spe_seoKeyword_str", branchCompany);//SEO关键字说装修
		String scinter_spe_seoDesc_str = (String)getValueByKeyName("scinter_spe_seoDesc_str", branchCompany);//SEO描述说装修
		String scinter_diamond_seoTitle_str = (String)getValueByKeyName("scinter_diamond_seoTitle_str", branchCompany);//SEO标题蓝钻工艺
		String scinter_diamond_seoKeyword_str = (String)getValueByKeyName("scinter_diamond_seoKeyword_str", branchCompany);//SEO关键字蓝钻工艺
		String scinter_diamond_seoDesc_str = (String)getValueByKeyName("scinter_diamond_seoDesc_str", branchCompany);//SEO描述蓝钻工艺
		String scinter_about_seoTitle_str = (String)getValueByKeyName("scinter_about_seoTitle_str", branchCompany);//SEO标题关于三创
		String scinter_about_seoKeyword_str = (String)getValueByKeyName("scinter_about_seoKeyword_str", branchCompany);//SEO关键字关于三创
		String scinter_about_seoDesc_str = (String)getValueByKeyName("scinter_about_seoDesc_str", branchCompany);//SEO描述关于三创
		String scinter_house_seo_title = (String)getValueByKeyName("scinter_house_seo_title", branchCompany);//SEO标题楼盘信息
		String scinter_house_seo_keyword = (String)getValueByKeyName("scinter_house_seo_keyword", branchCompany);//SEO关键字楼盘信息
		String scinter_house_seo_desc = (String)getValueByKeyName("scinter_house_seo_desc", branchCompany);//SEO描述楼盘信息
		String scinter_home_childCompany = (String)getValueByKeyName("scinter_home_childCompany", branchCompany);//分公司名称
		String service_seoTitle_str = (String)getValueByKeyName("service_seoTitle_str", branchCompany);// 服务信息
		String service_seoKeyword_str = (String)getValueByKeyName("service_seoKeyword_str", branchCompany);// 服务信息
		String service_seoDesc_str = (String)getValueByKeyName("service_seoDesc_str", branchCompany);// 服务信息

		/*网站首页的配置（PC站点）*/
		String scinter_home_logo = (String)getValueByKeyName("scinter_home_logo",branchCompany);// 首页公司的LOGO	
		String server_upload_file_path = (String)getValueByKeyName("server_upload_file_path",branchCompany);// 图片上传保存路径
		String scinter_home_telePhone = (String)getValueByKeyName("scinter_home_telePhone",branchCompany);// 公司电话
		String scinter_home_portraiture = (String)getValueByKeyName("scinter_home_portraiture",branchCompany);// 公司传真
		String scinter_home_postBox = (String)getValueByKeyName("scinter_home_postBox",branchCompany);// 公司邮箱
		String scinter_home_address = (String)getValueByKeyName("scinter_home_address",branchCompany);// 公司地址
//		String scinter_home_coworker = (String)getValueByKeyName("scinter_home_coworker");// 合作品牌
		SysConfigExample syc = new SysConfigExample();
		com.scinter.www.model.SysConfigExample.Criteria criteriaC = syc.createCriteria();
		criteriaC.andKeyNameLike("scinter_home_coworkerImg");
		criteriaC.andBranchCompanyEqualTo(branchCompany);
		criteriaC.andValueNotEqualTo("");
		syc.setOrderByClause("config_id asc");//排序
		List<SysConfig> scinter_home_coworkerList = sysConfigMapper.selectByExample(syc);
		
		String scinter_home_friendlyLink = (String)getValueByKeyName("scinter_home_friendlyLink",branchCompany);// 友情链接
//		String scinter_home_turnImgs = (String)getValueByKeyName("scinter_home_turnImgs");// 首页焦点轮播图片
		SysConfigExample syc1 = new SysConfigExample();
		com.scinter.www.model.SysConfigExample.Criteria criteria = syc1.createCriteria();
		criteria.andKeyNameLike("scinter_home_turnImgs");
		criteria.andBranchCompanyEqualTo(branchCompany);
		criteria.andValueNotEqualTo("");
		syc1.setOrderByClause("config_id asc");//排序
		List<SysConfig> scinter_home_turnImgsList = sysConfigMapper.selectByExample(syc1);
		
//		String scinter_home_decorateImgs = (String)getValueByKeyName("scinter_home_decorateImgs");// 首页装修风格图片（抽屉式的效果）
		SysConfigExample syc2 = new SysConfigExample();
		com.scinter.www.model.SysConfigExample.Criteria criteria2 = syc2.createCriteria();
		criteria2.andKeyNameLike("scinter_home_decorateImgs");
		criteria2.andBranchCompanyEqualTo(branchCompany);
		criteria2.andValueNotEqualTo("");
		criteria2.andBranchCompanyEqualTo(branchCompany);
		syc2.setOrderByClause("config_id asc");//排序
		List<SysConfig> scinter_home_decorateImgsList = sysConfigMapper.selectByExample(syc2);
		
		String scinter_home_twoCodeImg = (String)getValueByKeyName("scinter_home_twoCodeImg",branchCompany);// 首页底部二维码上传
		
		String scinter_home_shangQiao = (String)getValueByKeyName("scinter_home_shangQiao",branchCompany);//首页百度商桥配置
		String scinter_home_statistics = (String)getValueByKeyName("scinter_home_statistics",branchCompany);// 百度统计（PC站）
		
	    /*网站首页的配置（手机站点）*/
		String scinter_home_M_telePhone = (String)getValueByKeyName("scinter_home_M_telePhone",branchCompany);// 联系电话(手机站)
		String scinter_home_M_person = (String)getValueByKeyName("scinter_home_M_person",branchCompany);// 联系人(手机站)
		String scinter_home_M_postBox = (String)getValueByKeyName("scinter_home_M_postBox",branchCompany);// 邮箱地址(手机站)
		String scinter_home_M_address = (String)getValueByKeyName("scinter_home_M_address",branchCompany);// 公司地址(手机站)
		String scinter_home_M_twoCodeImg = (String)getValueByKeyName("scinter_home_M_twoCodeImg",branchCompany);// 手机站底部二维码
		String scinter_home_M_logoImg =(String)getValueByKeyName("scinter_home_M_logoImg",branchCompany);//手机站LOGO
//		String Scinter_home_M_turnImgs = (String)getValueByKeyName("Scinter_home_M_turnImgs");// 手机站焦点图
		SysConfigExample syc3 = new SysConfigExample();
		com.scinter.www.model.SysConfigExample.Criteria criteria3 = syc3.createCriteria();
		criteria3.andKeyNameLike("Scinter_home_M_turnImgs");
		criteria3.andBranchCompanyEqualTo(branchCompany);
		criteria3.andValueNotEqualTo("");
		syc3.setOrderByClause("config_id asc");//排序
		List<SysConfig> Scinter_home_M_turnImgsList = sysConfigMapper.selectByExample(syc3);
		String scinter_home_M_shangQiao = (String)getValueByKeyName("scinter_home_M_shangQiao",branchCompany);
		String scinter_home_M_statistics = (String)getValueByKeyName("scinter_home_M_statistics",branchCompany);// 百度统计（MP站）

		/*将获取的信息和要跳转的页面装载  ModelAndView */
		session.setAttribute("scinter_home_statistics", scinter_home_statistics);
		session.setAttribute("scinter_home_shangQiao", scinter_home_shangQiao);
		session.setAttribute("scinter_home_M_statistics", scinter_home_M_statistics);
		session.setAttribute("scinter_home_M_shangQiao", scinter_home_M_shangQiao);
		model.addObject("service_seoTitle_str", service_seoTitle_str);
		model.addObject("service_seoKeyword_str", service_seoKeyword_str);
		model.addObject("service_seoDesc_str", service_seoDesc_str);
		model.addObject("scinter_house_seo_title", scinter_house_seo_title);
		model.addObject("scinter_house_seo_keyword", scinter_house_seo_keyword);
		model.addObject("scinter_house_seo_desc", scinter_house_seo_desc);
		model.addObject("scinter_home_childCompany", scinter_home_childCompany);
		model.addObject("scinter_about_seoDesc_str", scinter_about_seoDesc_str);
		model.addObject("scinter_about_seoKeyword_str", scinter_about_seoKeyword_str);
		model.addObject("scinter_about_seoTitle_str", scinter_about_seoTitle_str);
		model.addObject("scinter_diamond_seoDesc_str", scinter_diamond_seoDesc_str);
		model.addObject("scinter_diamond_seoKeyword_str", scinter_diamond_seoKeyword_str);
		model.addObject("scinter_diamond_seoTitle_str", scinter_diamond_seoTitle_str);
		model.addObject("scinter_spe_seoDesc_str", scinter_spe_seoDesc_str);
		model.addObject("scinter_spe_seoKeyword_str", scinter_spe_seoKeyword_str);
		model.addObject("scinter_spe_seoTitle_str", scinter_spe_seoTitle_str);
		model.addObject("scinter_designer_seoDesc_str", scinter_designer_seoDesc_str);
		model.addObject("scinter_designer_seoKeyword_str", scinter_designer_seoKeyword_str);
		model.addObject("scinter_designer_seoTitle_str", scinter_designer_seoTitle_str);
		model.addObject("scinter_news_seoDesc_str", scinter_news_seoDesc_str);
		model.addObject("scinter_news_seoKeyword_str", scinter_news_seoKeyword_str);
		model.addObject("scinter_news_seoTitle_str", scinter_news_seoTitle_str);
		model.addObject("scinter_cases_seoDesc_str", scinter_cases_seoDesc_str);
		model.addObject("scinter_cases_seoKeyword_str", scinter_cases_seoKeyword_str);
		model.addObject("scinter_cases_seoTitle_str", scinter_cases_seoTitle_str);
		model.addObject("scinter_package_seo_desc", scinter_package_seo_desc);
		model.addObject("scinter_package_seo_keyword", scinter_package_seo_keyword);
		model.addObject("scinter_package_seo_title", scinter_package_seo_title);
		model.addObject("scinter_home_seo_title", scinter_home_seo_title);
		model.addObject("scinter_home_seo_keyword", scinter_home_seo_keyword);
		model.addObject("scinter_home_seo_desc", scinter_home_seo_desc);
		model.addObject("scinter_home_statistics", scinter_home_statistics);
		model.addObject("scinter_home_M_statistics", scinter_home_M_statistics);
		model.addObject("scinter_home_statistics", scinter_home_statistics);
		model.addObject("scinter_home_M_statistics",scinter_home_M_statistics);
		model.addObject("curBranchCompany", branchCompany);
		model.addObject("scinter_home_M_shangQiao", scinter_home_M_shangQiao);
		model.addObject("scinter_home_shangQiao", scinter_home_shangQiao);
		model.addObject("scinter_home_M_logoImg", scinter_home_M_logoImg);
		model.addObject("scinter_home_logo", scinter_home_logo);
		model.addObject("server_upload_file_path", server_upload_file_path);
		model.addObject("scinter_home_telePhone", scinter_home_telePhone);
		model.addObject("scinter_home_portraiture", scinter_home_portraiture);
		model.addObject("scinter_home_postBox", scinter_home_postBox);
		model.addObject("scinter_home_address", scinter_home_address);
		model.addObject("scinter_home_coworkerList", scinter_home_coworkerList);
		model.addObject("scinter_home_friendlyLink", scinter_home_friendlyLink);
		model.addObject("scinter_home_turnImgsList", scinter_home_turnImgsList);
		model.addObject("scinter_home_decorateImgsList", scinter_home_decorateImgsList);
		model.addObject("scinter_home_twoCodeImg", scinter_home_twoCodeImg);
		model.addObject("scinter_home_M_telePhone", scinter_home_M_telePhone);
		model.addObject("scinter_home_M_person", scinter_home_M_person);
		model.addObject("scinter_home_M_postBox", scinter_home_M_postBox);
		model.addObject("scinter_home_M_twoCodeImg", scinter_home_M_twoCodeImg);
		model.addObject("scinter_home_M_address", scinter_home_M_address);
		model.addObject("Scinter_home_M_turnImgsList", Scinter_home_M_turnImgsList);
		model.addObject("currentPer", currentPer);
		
		model.setViewName("/admin/home_config");
		
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0, TableName.sys_config, "三创首页信息");
		sysLogMapper.insert(sysLog);
		return model;
	}
	/**
	 * 编辑三创首页的信息
	 * @param scf				SystemConfig 类对象，用于存储三创首页的基本信息的
	 * @param response
	 * @param request
	 * @param session
	 */
	/**
	 * @author JhoneZhang
	 * @date   2016年9月5日下午12:08:10
	 * @param curBranchCompany
	 * @param scf
	 * @param response
	 * @param request
	 * @param session
	 */
	@RequestMapping("saveHomeConfig")
	@ResponseBody
	public void saveHomeConfig(
			@RequestParam(value="curBranchCompany",required=false,defaultValue="") String curBranchCompany,
			SystemConfig scf,HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		
		logger.info("当前分公司为："+curBranchCompany);
//		获取分公司的信息
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
		if(StringUtils.isNotBlank(curBranchCompany)){
			branchCompany = curBranchCompany;
		}
		logger.debug("************保存三创首页信息************");
		/*SEO全局信息配置*/
		String scinter_home_seo_title =scf.getScinter_home_seo_title();
		String scinter_home_seo_keyword = scf.getScinter_home_seo_keyword();
		String scinter_home_seo_desc =scf.getScinter_home_seo_desc();
		/* 三创首页选项配置 */
		String scinter_home_logo = scf.getScinter_home_logo();//登录背景图片
//		String server_upload_file_path = scf.getServer_upload_file_path();//图片上传保存路径
		String scinter_home_telePhone = scf.getScinter_home_telePhone();// 公司电话
		String scinter_home_portraiture = scf.getScinter_home_portraiture();// 公司传真
		String scinter_home_postBox = scf.getScinter_home_postBox();// 公司邮箱
		String scinter_home_address = scf.getScinter_home_address();// 公司地址
		String scinter_home_coworker = scf.getScinter_home_coworker();// 合作品牌
		String scinter_home_friendlyLink = scf.getScinter_home_friendlyLink();// 友情链接
		String scinter_home_turnImgs = scf.getScinter_home_turnImgs();// 首页轮转图片
		String scinter_home_decorateImgs = scf.getScinter_home_decorateImgs();// 首页装修风格图片（抽屉式的效果）
		String scinter_home_shangQiao = scf.getScinter_home_shangQiao();// 首页商桥
		String scinter_home_twoCodeImg = scf.getScinter_home_twoCodeImg();// 底部二维码
		String scinter_home_M_telePhone = scf.getScinter_home_M_telePhone();// 手机站公司电话
		String scinter_home_M_person = scf.getScinter_home_M_person();// 手机站联系人
		String scinter_home_M_postBox = scf.getScinter_home_M_postBox();// 手机站邮箱地址
		String scinter_home_M_address = scf.getScinter_home_M_address();// 手机站公司地址
		String scinter_home_M_logoImg = scf.getScinter_home_M_logoImg();// 手机站公司LOGO
		String scinter_home_M_shangQiao = scf.getScinter_home_M_shangQiao();// 手机站百度商桥
		String scinter_home_statistics = scf.getScinter_home_statistics();// 百度统计（PC站）
		String scinter_home_M_statistics = scf.getScinter_home_M_statistics();// 百度统计（MP站）
		String scinter_package_seo_title = scf.getScinter_package_seo_title();//SEO标题 装修套餐
		String scinter_package_seo_keyword = scf.getScinter_package_seo_keyword();//SEO关键字装修套餐
		String scinter_package_seo_desc = scf.getScinter_package_seo_desc();//SEO描述装修套餐
		String scinter_cases_seoTitle_str = scf.getScinter_cases_seoTitle_str();//SEO标题装修案例
		String scinter_cases_seoKeyword_str = scf.getScinter_cases_seoKeyword_str();//SEO关键字装修案例
		String scinter_cases_seoDesc_str= scf.getScinter_cases_seoDesc_str();//SEO描述装修案例
		String scinter_news_seoTitle_str = scf.getScinter_news_seoTitle_str();//SEO标题热门活动
		String scinter_news_seoKeyword_str = scf.getScinter_news_seoKeyword_str();//SEO关键字热门活动
		String scinter_news_seoDesc_str =  scf.getScinter_news_seoDesc_str();//SEO描述热门活动
		String scinter_designer_seoTitle_str = scf.getScinter_designer_seoTitle_str();//SEO标题设计团队
		String scinter_designer_seoKeyword_str = scf.getScinter_designer_seoKeyword_str();//SEO关键字设计团队
		String scinter_designer_seoDesc_str = scf.getScinter_designer_seoDesc_str();//SEO描述设计团队
		String scinter_spe_seoTitle_str = scf.getScinter_spe_seoTitle_str();//SEO标题说装修
		String scinter_spe_seoKeyword_str = scf.getScinter_spe_seoKeyword_str();//SEO关键字说装修
		String scinter_spe_seoDesc_str = scf.getScinter_spe_seoDesc_str();//SEO描述说装修
		String scinter_diamond_seoTitle_str = scf.getScinter_diamond_seoTitle_str();//SEO标题蓝钻工艺
		String scinter_diamond_seoKeyword_str = scf.getScinter_diamond_seoKeyword_str();//SEO关键字蓝钻工艺
		String scinter_diamond_seoDesc_str = scf.getScinter_diamond_seoDesc_str();//SEO描述蓝钻工艺
		String scinter_about_seoTitle_str = scf.getScinter_about_seoTitle_str();//SEO标题关于三创
		String scinter_about_seoKeyword_str = scf.getScinter_about_seoKeyword_str();//SEO关键字关于三创
		String scinter_about_seoDesc_str = scf.getScinter_about_seoDesc_str();//SEO描述关于三创
		String scinter_house_seo_title = scf.getScinter_house_seo_title();//SEO标题楼盘信息
		String scinter_house_seo_keyword = scf.getScinter_house_seo_keyword();//SEO关键字楼盘信息
		String scinter_house_seo_desc = scf.getScinter_house_seo_desc();//SEO描述楼盘信息
		String scinter_home_childCompany = scf.getScinter_home_childCompany();//分公司民称
		String service_seoTitle_str = scf.getService_seoTitle_str();// SEO 标题 服务信息 
		String service_seoKeyword_str = scf.getService_seoKeyword_str();// SEO 关键字 服务信息 
		String service_seoDesc_str = scf.getService_seoDesc_str();// SEO 描述服务信息 
		
		insertOrUpdata("service_seoTitle_str", service_seoTitle_str, "SEO标题服务信息", branchCompany);
		insertOrUpdata("service_seoKeyword_str", service_seoKeyword_str, "SEO关键字服务信息", branchCompany);
		insertOrUpdata("service_seoDesc_str", service_seoDesc_str, "SEO描述服务信息", branchCompany);
		insertOrUpdata("scinter_home_childCompany", scinter_home_childCompany, "分公司名称", branchCompany);
		/*SEO信息配置*/
		insertOrUpdata("scinter_house_seo_desc", scinter_house_seo_desc, "SEO描述楼盘信息", branchCompany);
		insertOrUpdata("scinter_house_seo_keyword", scinter_house_seo_keyword, "SEO关键字楼盘信息", branchCompany);
		insertOrUpdata("scinter_house_seo_title", scinter_house_seo_title, "SEO标题楼盘信息", branchCompany);
		insertOrUpdata("scinter_about_seoDesc_str", scinter_about_seoDesc_str, "SEO描述关于三创", branchCompany);
		insertOrUpdata("scinter_about_seoKeyword_str", scinter_about_seoKeyword_str, "SEO关键字关于三创", branchCompany);
		insertOrUpdata("scinter_about_seoTitle_str", scinter_about_seoTitle_str, "SEO标题关于三创", branchCompany);
		insertOrUpdata("scinter_diamond_seoDesc_str", scinter_diamond_seoDesc_str, "SEO描述蓝钻工艺", branchCompany);
		insertOrUpdata("scinter_diamond_seoKeyword_str", scinter_diamond_seoKeyword_str, "SEO关键字蓝钻工艺", branchCompany);
		insertOrUpdata("scinter_diamond_seoTitle_str", scinter_diamond_seoTitle_str, "SEO标题蓝钻工艺", branchCompany);
		insertOrUpdata("scinter_spe_seoDesc_str", scinter_spe_seoDesc_str, "SEO描述说装修", branchCompany);
		insertOrUpdata("scinter_spe_seoKeyword_str", scinter_spe_seoKeyword_str, "SEO关键字说装修", branchCompany);
		insertOrUpdata("scinter_spe_seoTitle_str", scinter_spe_seoTitle_str, "SEO标题说装修", branchCompany);
		insertOrUpdata("scinter_designer_seoDesc_str", scinter_designer_seoDesc_str, "SEO描述设计团队", branchCompany);
		insertOrUpdata("scinter_designer_seoKeyword_str", scinter_designer_seoKeyword_str, "SEO关键字设计团队", branchCompany);
		insertOrUpdata("scinter_designer_seoTitle_str", scinter_designer_seoTitle_str, "SEO标题设计图团队", branchCompany);
		insertOrUpdata("scinter_news_seoDesc_str", scinter_news_seoDesc_str, "SEO描述热门活动", branchCompany);
		insertOrUpdata("scinter_news_seoKeyword_str", scinter_news_seoKeyword_str, "SEO关键字热门活动", branchCompany);
		insertOrUpdata("scinter_news_seoTitle_str", scinter_news_seoTitle_str, "SEO标题热门活动", branchCompany);
		insertOrUpdata("scinter_cases_seoDesc_str", scinter_cases_seoDesc_str, "SEO描述装修案例", branchCompany);
		insertOrUpdata("scinter_cases_seoKeyword_str", scinter_cases_seoKeyword_str, "SEO关键字装修案例", branchCompany);
		insertOrUpdata("scinter_cases_seoTitle_str", scinter_cases_seoTitle_str, "SEO标题装修案例", branchCompany);
		insertOrUpdata("scinter_package_seo_desc", scinter_package_seo_desc, "SEO描述装修套餐", branchCompany);
		insertOrUpdata("scinter_package_seo_keyword", scinter_package_seo_keyword, "SEO关键字装修套餐", branchCompany);
		insertOrUpdata("scinter_package_seo_title", scinter_package_seo_title, "SEO标题装修案例", branchCompany);
		/* 更新三创首页的基本信息，在更新之前判断是都含有数据，否则执行的插入 */
		insertOrUpdata("scinter_home_seo_title", scinter_home_seo_title, "SEO标题", branchCompany);
		insertOrUpdata("scinter_home_seo_keyword", scinter_home_seo_keyword, "SEO关键字", branchCompany);
		insertOrUpdata("scinter_home_seo_desc", scinter_home_seo_desc, "SEO描述", branchCompany);
		insertOrUpdata("scinter_home_statistics",scinter_home_statistics,"百度统计(PC站)",branchCompany);
		insertOrUpdata("scinter_home_M_statistics",scinter_home_M_statistics,"百度统计(MP站)",branchCompany);
		insertOrUpdata("scinter_home_M_shangQiao",scinter_home_M_shangQiao,"手机站百度商桥",branchCompany);
		insertOrUpdata("scinter_home_logo",scinter_home_logo,"登录背景图片",branchCompany);
//		insertOrUpdata("server_upload_file_path",server_upload_file_path,"图片上传保存路径",branchCompany);
		insertOrUpdata("scinter_home_telePhone",scinter_home_telePhone,"公司电话",branchCompany);
		insertOrUpdata("scinter_home_portraiture",scinter_home_portraiture,"公司传真",branchCompany);
		insertOrUpdata("scinter_home_postBox",scinter_home_postBox,"公司邮箱",branchCompany);
		insertOrUpdata("scinter_home_address",scinter_home_address,"公司地址",branchCompany);
		insertOrUpdata("scinter_home_coworker",scinter_home_coworker,"合作品牌",branchCompany);
		insertOrUpdata("scinter_home_friendlyLink",scinter_home_friendlyLink,"友情链接",branchCompany);
		insertOrUpdata("scinter_home_turnImgs",scinter_home_turnImgs,"首页轮转图片",branchCompany);
		insertOrUpdata("scinter_home_decorateImgs",scinter_home_decorateImgs,"首页装修风格图片（抽屉式的效果）",branchCompany);
		insertOrUpdata("scinter_home_twoCodeImg",scinter_home_twoCodeImg,"底部二维码",branchCompany);
		insertOrUpdata("scinter_home_shangQiao", scinter_home_shangQiao, "PC首页百度商桥",branchCompany);
		insertOrUpdata("scinter_home_M_telePhone",scinter_home_M_telePhone,"手机站联系电话",branchCompany);
		insertOrUpdata("scinter_home_M_person",scinter_home_M_person,"手机站联系人",branchCompany);
		insertOrUpdata("scinter_home_M_postBox",scinter_home_M_postBox,"手机站邮箱地址",branchCompany);
		insertOrUpdata("scinter_home_M_address",scinter_home_M_address,"手机站公司地址",branchCompany);
		insertOrUpdata("scinter_home_M_logoImg",scinter_home_M_logoImg,"手机站公司LOGO",branchCompany);
	
//		系统操作日志记录
		SysLog sysLog = new SysLog();
		SysLogUtil.edit(session, 0, TableName.sys_config, "三创首页信息");
		sysLogMapper.insert(sysLog);
		
		JsonPrintUtil.printObjData(response, "ok");
	}
	
	@RequestMapping("delHomeConfig")
	@ResponseBody
	public void delCaseImage(String homeConfigId,HttpSession session,HttpServletResponse response) {
		if(!StringUtils.isBlank(homeConfigId)){
			int hId = Integer.parseInt(homeConfigId);
			sysConfigMapper.deleteByPrimaryKey(hId);
			JsonPrintUtil.printObjData(response, "ok");
			
//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.delete(session, hId, TableName.sys_config, "首页轮转图片");
			sysLogMapper.insert(sysLog);

		}else{
			JsonPrintUtil.printObjData(response, "fail");
		}
	}
}
