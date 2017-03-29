package com.scinter.www.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.scinter.www.dao.ModuleMapper;
import com.scinter.www.dao.RoleAuthMapper;
import com.scinter.www.dao.RoleMapper;
import com.scinter.www.dao.SysLogMapper;
import com.scinter.www.model.Module;
import com.scinter.www.model.ModuleExample;
import com.scinter.www.model.Role;
import com.scinter.www.model.RoleAuth;
import com.scinter.www.model.RoleAuthExample;
import com.scinter.www.model.RoleExample;
import com.scinter.www.model.RoleExample.Criteria;
import com.scinter.www.model.SysLog;
import com.scinter.www.model.User;
import com.scinter.www.util.JsonPrintUtil;
import com.scinter.www.util.Page;
import com.scinter.www.util.SysLogUtil;
import com.scinter.www.util.TableName;

@Controller
@RequestMapping("admin")
public class RoleController {

	private Logger logger = Logger.getLogger(RoleController.class);

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RoleAuthMapper authMapper;
	@Autowired
	private ModuleMapper moduleMapper;
	@Autowired
	private SysLogMapper sysLogMapper;
	
	@RequestMapping("listRoleToJson")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void listRoleToJson(@RequestParam("page") int page,@RequestParam("rows") int rows,HttpSession session,HttpServletResponse response) {
		
		//分页条件查询
		RoleExample rx = new RoleExample();
		Criteria criteria = rx.createCriteria();
		criteria.andStatusNotEqualTo(3);//非删除状态
		
		int totalNums = roleMapper.countByExample(rx);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		rx.setPage(p);
		rx.setOrderByClause("create_time desc");//排序
		List<Role> roleList4Page = roleMapper.selectByExample(rx);
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0, TableName.Role, "角色列表信息");
		sysLogMapper.insert(sysLog);
		
		JsonPrintUtil.printGridData(response, roleList4Page, totalNums,"rows","total");
	}
	
	
	@RequestMapping("searchListRole")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void searchListRole(@RequestParam("page") int page,@RequestParam("rows") int rows,String keyWord,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		
		//分页条件查询
		RoleExample rx = new RoleExample();
		Criteria criteria = rx.createCriteria();
		if (StringUtils.isNotBlank(keyWord)) {
			keyWord = "%" + keyWord + "%";
			//and or联合查询
			criteria.andRoleNameLike(keyWord).andStatusNotEqualTo(3);			
		}else{
			criteria.andStatusNotEqualTo(3);//非删除状态
		}
		
		int totalNums = roleMapper.countByExample(rx);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		rx.setPage(p);
		rx.setOrderByClause("create_time desc");//排序
		List<Role> roleList4Page = roleMapper.selectByExample(rx);
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0 , TableName.Role, "角色信息");
		sysLogMapper.insert(sysLog);
		JsonPrintUtil.printGridData(response, roleList4Page, totalNums,"rows","total");
	}
	
	//下拉列表
	@RequestMapping("listAllRole")
	@ResponseBody
	public void listUserToJson(HttpServletResponse response) {
		RoleExample rx = new RoleExample();
		Criteria criteria = rx.createCriteria();
		criteria.andStatusNotEqualTo(3);//非删除状态
		
		rx.setOrderByClause("role_id desc");
		List<Role> roleList = roleMapper.selectByExample(rx);
		JsonPrintUtil.printObjDataWithNoRoot(response, roleList);
	}
	
	/**
	 * 后台配置三创初始化导航树加载
	 * @author JhoneZhang
	 * @date   2016年9月22日下午2:48:16
	 * @param homeBranchCompany
	 * @param authId
	 * @param response
	 * @param session
	 */
	@RequestMapping("scGetRoleAuthJson")
	@ResponseBody
	public void scGetRoleAuthJson(
			@RequestParam(value="homeBranchCompany",required=false ) String homeBranchCompany,
			int authId,HttpServletResponse response,HttpSession session) {
		
		logger.info("当前分公司为:"+homeBranchCompany);
		RoleAuth auth = authMapper.selectByPrimaryKey(authId);
		
		ModuleExample mx = new ModuleExample();
		mx.setOrderByClause("id ");
		List<Module> moduleList= moduleMapper.selectByExample(mx);
		List<Module> moduleListNew = new ArrayList<Module>();
		
		for(Module m : moduleList){
			
			if(auth.getSypz()==1 && m.getName().equals("sypz")){
				moduleListNew.add(m);
			}
			if(auth.getZxal()==1 && m.getName().equals("zxal")){
				moduleListNew.add(m);
			}
			if(auth.getSjtd()==1 && m.getName().equals("sjtd")){
				moduleListNew.add(m);
			}
			if(auth.getLpxx()==1 && m.getName().equals("lpxx")){
				moduleListNew.add(m);
			}
			if(auth.getZjgd()==1 && m.getName().equals("zjgd")){
				moduleListNew.add(m);
			}
			if(auth.getHxdp()==1 && m.getName().equals("hxdp")){
				moduleListNew.add(m);
			}
			if(auth.getZxzx()==1 && m.getName().equals("zxzx")){
				moduleListNew.add(m);
			}
			if(auth.getZxdd()==1 && m.getName().equals("zxdd")){
				moduleListNew.add(m);
			}
			if(auth.getZxbx()==1 && m.getName().equals("zxbx")){
				moduleListNew.add(m);
			}
			if(auth.getZxwd()==1 && m.getName().equals("zxwd")){
				moduleListNew.add(m);
			}
			if(auth.getLypl()==1 && m.getName().equals("lypl")){
				moduleListNew.add(m);
			}
			if(auth.getSchd()==1 && m.getName().equals("schd")){
				moduleListNew.add(m);
			}
			if(auth.getRmxq()==1 && m.getName().equals("rmxq")){
				moduleListNew.add(m);
			}
			if(auth.getSyhdlb()==1 && m.getName().equals("syhdlb"))
				moduleListNew.add(m);
			if(auth.getSyhdlbm()==1 && m.getName().equals("syhdlbm"))
				moduleListNew.add(m);
		}
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0, TableName.Role, "角色列表信息");
		sysLogMapper.insert(sysLog);
		session.setAttribute("homeBranchCompany", homeBranchCompany);
		JsonPrintUtil.printObjDataWithNoRoot(response, moduleListNew);
	}
	
	/**
	 * 后台配置新洲初始化导航树加载
	 * @author JhoneZhang
	 * @date   2016年9月22日下午2:48:16
	 * @param homeBranchCompany
	 * @param authId
	 * @param response
	 * @param session
	 */
	@RequestMapping("xzGetRoleAuthJson")
	@ResponseBody
	public void xzGetRoleAuthJson(
			@RequestParam(value="homeBranchCompany",required=false ) String homeBranchCompany,
			int authId,HttpServletResponse response,HttpSession session) {
		
		logger.info("当前分公司为:"+homeBranchCompany);
		RoleAuth auth = authMapper.selectByPrimaryKey(authId);
		
		ModuleExample mx = new ModuleExample();
		mx.setOrderByClause("id ");
		List<Module> moduleList= moduleMapper.selectByExample(mx);
		List<Module> moduleListNew = new ArrayList<Module>();
		
		for(Module m : moduleList){
			
			if(auth.getSypz()==1 && m.getName().equals("sypz")){
				moduleListNew.add(m);
			}
			if(auth.getZxal()==1 && m.getName().equals("zxal")){
				moduleListNew.add(m);
			}
			if(auth.getSjtd()==1 && m.getName().equals("sjtd")){
				moduleListNew.add(m);
			}
			if(auth.getLpxx()==1 && m.getName().equals("lpxx")){
				moduleListNew.add(m);
			}
			if(auth.getZjgd()==1 && m.getName().equals("zjgd")){
				moduleListNew.add(m);
			}
			if(auth.getHxdp()==1 && m.getName().equals("hxdp")){
				moduleListNew.add(m);
			}
			if(auth.getXzxw()==1 && m.getName().equals("xzxw")){
				moduleListNew.add(m);
			}
			if(auth.getZxdd()==1 && m.getName().equals("zxdd")){
				moduleListNew.add(m);
			}
			if(auth.getZxbx()==1 && m.getName().equals("zxbx")){
				moduleListNew.add(m);
			}
			if(auth.getZxwd()==1 && m.getName().equals("zxwd")){
				moduleListNew.add(m);
			}
			if(auth.getXzhd()==1 && m.getName().equals("xzhd")){
				moduleListNew.add(m);
			}
			if(auth.getLypl()==1 && m.getName().equals("lypl")){
				moduleListNew.add(m);
			}
			if(auth.getRmxq()==1 && m.getName().equals("rmxq")){
				moduleListNew.add(m);
			}
			if(auth.getSyhdlb()==1 && m.getName().equals("syhdlb"))
				moduleListNew.add(m);
			if(auth.getLftc()==1 && m.getName().equals("lftc"))
				moduleListNew.add(m);
			if(auth.getSyhdlbm()==1 && m.getName().equals("syhdlbm"))
				moduleListNew.add(m);
		}
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0, TableName.Role, "角色列表信息");
		sysLogMapper.insert(sysLog);
		session.setAttribute("homeBranchCompany", homeBranchCompany);
		JsonPrintUtil.printObjDataWithNoRoot(response, moduleListNew);
	}
	
   /**
    * 瑞博文一装饰导航树 
    * @author JhoneZhang
    * @date   2016年9月19日下午2:23:15
    * @param authId
    * @param response
    * @param session
    */
	@RequestMapping("rbwGetRoleAuthJson")
	@ResponseBody
	public void rbwGetRoleAuthJson(
			@RequestParam(value="homeBranchCompany", required=false) String homeBranchCompany,
			int authId,HttpServletResponse response,HttpSession session) {
		
		logger.info("当前分公司为:"+homeBranchCompany);
		RoleAuth auth = authMapper.selectByPrimaryKey(authId);
		
		ModuleExample mx = new ModuleExample();
		mx.setOrderByClause("id ");
		List<Module> moduleList= moduleMapper.selectByExample(mx);
		List<Module> moduleListNew = new ArrayList<Module>();
		
		for(Module m : moduleList){
			
			if(auth.getSypz()==1 && m.getName().equals("sypz")){
				moduleListNew.add(m);
			}
			if(auth.getZxal()==1 && m.getName().equals("zxal")){
				moduleListNew.add(m);
			}
			if(auth.getSjtd()==1 && m.getName().equals("sjtd")){
				moduleListNew.add(m);
			}
			if(auth.getLpxx()==1 && m.getName().equals("lpxx")){
				moduleListNew.add(m);
			}
			if(auth.getZjgd()==1 && m.getName().equals("zjgd")){
				moduleListNew.add(m);
			}
			if(auth.getHxdp()==1 && m.getName().equals("hxdp")){
				moduleListNew.add(m);
			}
			if(auth.getRbwzx()==1 && m.getName().equals("rbwzx")){
				moduleListNew.add(m);
			}
			if(auth.getZxdd()==1 && m.getName().equals("zxdd")){
				moduleListNew.add(m);
			}
			if(auth.getZxbx()==1 && m.getName().equals("zxbx")){
				moduleListNew.add(m);
			}
			if(auth.getZxwd()==1 && m.getName().equals("zxwd")){
				moduleListNew.add(m);
			}
			if(auth.getLypl()==1 && m.getName().equals("lypl")){
				moduleListNew.add(m);
			}
			if(auth.getZxxgt()==1 && m.getName().equals("zxxgt")){
				moduleListNew.add(m);
			}
			if(auth.getRbwhd()==1 && m.getName().equals("rbwhd")){
				moduleListNew.add(m);
			}
			if(auth.getZxfg()==1 && m.getName().equals("zxfg")){
				moduleListNew.add(m);
			}
			if(auth.getRmxq()==1 && m.getName().equals("rmxq")){
				moduleListNew.add(m);
			}
			if(auth.getSyhdlb()==1 && m.getName().equals("syhdlb"))
				moduleListNew.add(m);
			if(auth.getSyhdlbm()==1 && m.getName().equals("syhdlbm"))
				moduleListNew.add(m);
		}
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0, TableName.Role, "角色列表信息");
		sysLogMapper.insert(sysLog);
		
		JsonPrintUtil.printObjDataWithNoRoot(response, moduleListNew);
	}
	
	 /**
	    * 瑞博二装饰导航树 
	    * @author JhoneZhang
	    * @date   2016年9月19日下午2:23:15
	    * @param authId
	    * @param response
	    * @param session
	    */
		@RequestMapping("rbw2GetRoleAuthJson")
		@ResponseBody
		public void rbw2GetRoleAuthJson(
				@RequestParam(value="homeBranchCompany", required=false) String homeBranchCompany,
				int authId,HttpServletResponse response,HttpSession session) {
			
			logger.info("当前分公司为:"+homeBranchCompany);
			RoleAuth auth = authMapper.selectByPrimaryKey(authId);
			
			ModuleExample mx = new ModuleExample();
			mx.setOrderByClause("id ");
			List<Module> moduleList= moduleMapper.selectByExample(mx);
			List<Module> moduleListNew = new ArrayList<Module>();
			
			for(Module m : moduleList){
				
				if(auth.getSypz()==1 && m.getName().equals("sypz")){
					moduleListNew.add(m);
				}
				if(auth.getZxal()==1 && m.getName().equals("zxal")){
					moduleListNew.add(m);
				}
				if(auth.getSjtd()==1 && m.getName().equals("sjtd")){
					moduleListNew.add(m);
				}
				if(auth.getLpxx()==1 && m.getName().equals("lpxx")){
					moduleListNew.add(m);
				}
				if(auth.getZjgd()==1 && m.getName().equals("zjgd")){
					moduleListNew.add(m);
				}
				if(auth.getHxdp()==1 && m.getName().equals("hxdp")){
					moduleListNew.add(m);
				}
				if(auth.getRbwzx()==1 && m.getName().equals("rbwzx")){
					moduleListNew.add(m);
				}
				if(auth.getZxdd()==1 && m.getName().equals("zxdd")){
					moduleListNew.add(m);
				}
				if(auth.getZxbx()==1 && m.getName().equals("zxbx")){
					moduleListNew.add(m);
				}
				if(auth.getZxwd()==1 && m.getName().equals("zxwd")){
					moduleListNew.add(m);
				}
				if(auth.getLypl()==1 && m.getName().equals("lypl")){
					moduleListNew.add(m);
				}
				if(auth.getZxxgt()==1 && m.getName().equals("zxxgt")){
					moduleListNew.add(m);
				}
				if(auth.getRbwhd()==1 && m.getName().equals("rbwhd")){
					moduleListNew.add(m);
				}
				if(auth.getZxfg()==1 && m.getName().equals("zxfg")){
					moduleListNew.add(m);
				}
				if(auth.getRmxq()==1 && m.getName().equals("rmxq")){
					moduleListNew.add(m);
				}
				if(auth.getSyhdlb()==1 && m.getName().equals("syhdlb"))
					moduleListNew.add(m);
				if(auth.getSyhdlbm()==1 && m.getName().equals("syhdlbm"))
					moduleListNew.add(m);
			}
			
//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.search(session, 0, TableName.Role, "角色列表信息");
			sysLogMapper.insert(sysLog);
			
			JsonPrintUtil.printObjDataWithNoRoot(response, moduleListNew);
		}
	
	/**
	 * 人人乐装饰
	 * @author JhoneZhang
	 * @date   2016年10月7日上午9:52:48
	 * @param homeBranchCompany
	 * @param authId
	 * @param response
	 * @param session
	 */
	@RequestMapping("rrlGetRoleAuthJson")
	@ResponseBody
	public void rrlGetRoleAuthJson(
			@RequestParam(value="homeBranchCompany", required=false) String homeBranchCompany,
			int authId,HttpServletResponse response,HttpSession session) {
		
//		logger.info("当前分公司为:"+homeBranchCompany);
		RoleAuth auth = authMapper.selectByPrimaryKey(authId);
		
		ModuleExample mx = new ModuleExample();
		mx.setOrderByClause("id ");
		List<Module> moduleList= moduleMapper.selectByExample(mx);
		List<Module> moduleListNew = new ArrayList<Module>();
		
		for(Module m : moduleList){
			
			if(auth.getRrlzxal()==1 && m.getName().equals("rrlzxal")){
				moduleListNew.add(m);
			}
			if(auth.getSypz()==1 && m.getName().equals("sypz")){
				moduleListNew.add(m);
			}
			/*if(auth.getZxal()==1 && m.getName().equals("zxal")){
				moduleListNew.add(m);
			}*/
			if(auth.getSjtd()==1 && m.getName().equals("sjtd")){
				moduleListNew.add(m);
			}
			if(auth.getLpxx()==1 && m.getName().equals("lpxx")){
				moduleListNew.add(m);
			}
			if(auth.getZjgd()==1 && m.getName().equals("zjgd")){
				moduleListNew.add(m);
			}
			if(auth.getHxdp()==1 && m.getName().equals("hxdp")){
				moduleListNew.add(m);
			}
		/*	if(auth.getRbwzx()==1 && m.getName().equals("rbwzx")){
				moduleListNew.add(m);
			}*/
			if(auth.getZxdd()==1 && m.getName().equals("zxdd")){
				moduleListNew.add(m);
			}
			if(auth.getZxbx()==1 && m.getName().equals("zxbx")){
				moduleListNew.add(m);
			}
			if(auth.getZxwd()==1 && m.getName().equals("zxwd")){
				moduleListNew.add(m);
			}
			if(auth.getLypl()==1 && m.getName().equals("lypl")){
				moduleListNew.add(m);
			}
			if(auth.getZxxgt()==1 && m.getName().equals("zxxgt")){
				moduleListNew.add(m);
			}
/*			if(auth.getRbwhd()==1 && m.getName().equals("rbwhd")){
				moduleListNew.add(m);
			}
*/			if(auth.getZxfg()==1 && m.getName().equals("zxfg")){
				moduleListNew.add(m);
			}
			if(auth.getRmxq()==1 && m.getName().equals("rmxq")){
				moduleListNew.add(m);
			}
			if(auth.getSyhdlb()==1 && m.getName().equals("syhdlb"))
				moduleListNew.add(m);
			if(auth.getSyhdlbm()==1 && m.getName().equals("syhdlbm"))
				moduleListNew.add(m);
			
		}
		
//			日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0, TableName.Role, "角色列表信息");
		sysLogMapper.insert(sysLog);
		
		JsonPrintUtil.printObjDataWithNoRoot(response, moduleListNew);
	}
	
	@RequestMapping("showRole")
	public ModelAndView showRole(int roleId,HttpSession session){
		ModelAndView model = new ModelAndView();
		Role role = roleMapper.selectByPrimaryKey(roleId);
		
		RoleAuthExample ax = new RoleAuthExample();
		RoleAuthExample.Criteria criteria = ax.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		List<RoleAuth> list = authMapper.selectByExample(ax);
		if(null != list && list.size()>0){			
			model.addObject("authInfo", list.get(0));
		}else{
			model.addObject("authInfo",new RoleAuth());
		}
		model.addObject("roleInfo", role);
		model.setViewName("/admin/roleSave");
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, role.getRoleId(), TableName.Role, "角色信息");
		sysLogMapper.insert(sysLog);
		
		return model;
	}
	
	@RequestMapping("checkRoleName")
	@ResponseBody
	public void checkRoleName(HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException{
		String roleName = request.getParameter("roleName");
		roleName = URLDecoder.decode(roleName, "UTF-8");
		RoleExample rx = new RoleExample();
		Criteria criteria = rx.createCriteria();
		criteria.andRoleNameEqualTo(roleName);
		criteria.andStatusNotEqualTo(3);//非删除状态
		rx.setOrderByClause("role_id desc");
		List<Role> roleList = roleMapper.selectByExample(rx);
		if(null!=roleList && roleList.size()>0){
			Role r = roleList.get(0);
			if(null != r){
				JsonPrintUtil.printObjData(response, "ok");//存在相同的角色名称
			}else{
				JsonPrintUtil.printObjData(response, 0);
			}
		}else{
			JsonPrintUtil.printObjData(response, 0);
		}
	}
	
	@RequestMapping("saveRole")
	@ResponseBody
	public void saveRole(Role role,RoleAuth auth,HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		int num = 0;
		User currentLoginUser = (User)request.getSession().getAttribute("UserInfo");
		
		if(null==role.getRoleId()){
			role.setCreateTime(new Date());
			role.setCreater(currentLoginUser.getUserName());
			role.setUpdateTime(new Date());
			role.setStatus(1);
			num = roleMapper.insert(role);
			auth.setRoleId(role.getRoleId());
			authMapper.insert(auth);
			role.setAuthId(auth.getAuthId());
			roleMapper.updateByPrimaryKeySelective(role);//只更新传值的字段
			
//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.add(session, role.getRoleId(), TableName.Role, "角色信息");
			sysLogMapper.insert(sysLog);
			
			logger.info("add role seccess!");
		}else{
			role.setUpdateTime(new Date());
			role.setUpdater(currentLoginUser.getUserName());
			num = roleMapper.updateByPrimaryKeySelective(role);//只更新传值的字段
			authMapper.updateByPrimaryKeySelective(auth);
//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.edit(session, role.getRoleId(), TableName.Role, "角色信息");
			sysLogMapper.insert(sysLog);
			logger.info("update role seccess!");
		}
		if(num>0){
			JsonPrintUtil.printObjData(response, "ok");
		}
	}
	
	@RequestMapping("delRole")
	@ResponseBody
	public void delRole(String roleIds,HttpSession session,HttpServletResponse response) {
		User currentLoginUser = (User)session.getAttribute("UserInfo");
		if(!StringUtils.isBlank(roleIds)){
			String[] roleIdArr = roleIds.split(",");
			for(int i=0;i<roleIdArr.length;i++){
				int rId = Integer.parseInt(roleIdArr[i]);
				Role role = roleMapper.selectByPrimaryKey(rId);
				role.setStatus(3);//1正常 3删除
				role.setUpdateTime(new Date());
				role.setUpdater(currentLoginUser.getUserName());
				roleMapper.updateByPrimaryKeySelective(role);
				
//				日志记录
				SysLog sysLog = new SysLog();
				sysLog =SysLogUtil.delete(session, role.getRoleId(), TableName.Role, "角色信息");
				sysLogMapper.insert(sysLog);
			}
			JsonPrintUtil.printObjData(response, "ok");
		}else{
			JsonPrintUtil.printObjData(response, "fail");
		}
	}
	
}
