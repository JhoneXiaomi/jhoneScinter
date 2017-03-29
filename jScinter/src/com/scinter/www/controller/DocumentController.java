package com.scinter.www.controller;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.scinter.www.dao.CasesMapper;
import com.scinter.www.dao.CommunitysMapper;
import com.scinter.www.dao.DesignerMapper;
import com.scinter.www.dao.SysConfigMapper;
import com.scinter.www.dao.SysLogMapper;
import com.scinter.www.model.Cases;
import com.scinter.www.model.CasesExample;
import com.scinter.www.model.CasesExample.Criteria;
import com.scinter.www.model.Communitys;
import com.scinter.www.model.CommunitysExample;
import com.scinter.www.model.Role;
import com.scinter.www.model.SysLog;
import com.scinter.www.model.User;
import com.scinter.www.util.JsonPrintUtil;
import com.scinter.www.util.Page;
import com.scinter.www.util.SysLogUtil;
import com.scinter.www.util.TableName;

@Controller
@RequestMapping("admin")
public class DocumentController extends BaseController {

	private Logger logger = Logger.getLogger(CaseController.class);

	@Autowired
	private CommunitysMapper communitysMapper;
	@Autowired
	private SysLogMapper sysLogMapper;
	@Autowired
	private DesignerMapper designerMapper;
	@Autowired
	private SysConfigMapper sysConfigMapper;
	@Autowired
	private CasesMapper casesMapper;
	
	@RequestMapping("listDocumentToJson")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void listDocumentToJson(@RequestParam("page") int page,@RequestParam("rows") int rows,HttpServletRequest request,HttpSession session ,HttpServletResponse response) {
		
		
		// 获取二级分公司的信息
		String controlledCompany = (String) session.getAttribute("controlledCompany");
		logger.info("the value of controlledCompany is:" + controlledCompany);
	    String spilCompany = "";
		int length = controlledCompany.length();
		// xxzs sczs rbwzs1 rbwzs2 rrlzs
		if(length==4){
			
			spilCompany = controlledCompany.substring(0, 2);
			logger.info("the current company is:" + spilCompany);
		}else if(controlledCompany.equals("rbwzs1")){
			
			spilCompany = "rbw1";
			logger.info("the current company is:" + spilCompany);
		}else if(controlledCompany.equals("rbwzs2")){
			
			spilCompany = "rbw2";
			logger.info("the current company is:" + spilCompany);
		}else if(controlledCompany.equals("rrlzs")){
			
			spilCompany = "rrl";
			logger.info("the current company is:" + spilCompany);
		}
		//分页条件查询
		CommunitysExample rx = new CommunitysExample();
		com.scinter.www.model.CommunitysExample.Criteria criteria = rx.createCriteria();
		criteria.andStatusEqualTo("是");
		Role currentRole= (Role)session.getAttribute("Role");
		String roleName = currentRole.getRoleName();
		String branchCompany = "";
		if(!"超级管理员".equals(roleName)){
			branchCompany = currentRole.getBranchCompany();
			request.setAttribute("BCompany", branchCompany);
			criteria.andBranchCompanyEqualTo(branchCompany);//当前用户所属分公司
		}else{
			
			criteria.andBranchCompanyLike("%"+spilCompany+"%");
		}
		int totalNums = communitysMapper.countByExample(rx);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		rx.setPage(p);
		rx.setOrderByClause("create_time desc");//排序
		List<Communitys> communitysListPage = communitysMapper.selectByExample(rx);
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0, TableName.community, "热门小区信息");
		sysLogMapper.insert(sysLog);
		session.setAttribute("myBranchCompany", branchCompany);
		JsonPrintUtil.printGridData(response, communitysListPage, totalNums,"rows","total");
	}

	@RequestMapping("showDocument")
	public ModelAndView showDocument(@RequestParam("communityId") int communityId, HttpSession session){
		
		
		ModelAndView model = new ModelAndView();
		Communitys Community = communitysMapper.selectByPrimaryKey(communityId);
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
		
		// 获取小区的相关的案例信息
		CasesExample ce = new CasesExample();
		Criteria cc = ce.createCriteria();
		cc.andCommunityIdEqualTo(communityId);
		// 非删除状态
		cc.andCaseStatusEqualTo(1);
		List<Cases> caseList = casesMapper.selectByExample(ce);
		
		// 日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, Community.getCommunityId(), TableName.community, "热门小区");
		sysLogMapper.insert(sysLog);	
		
		model.addObject("caseList", caseList);
		model.addObject("communityInfo", Community);
		model.addObject("branchCompany", branchCompany);
		model.setViewName("/admin/documentSave");
		return model;
	}
	
	@RequestMapping("saveDocument")
	@ResponseBody
	public void saveDocument(Communitys community,HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		
		int num = 0;
		User currentLoginUser = (User)request.getSession().getAttribute("UserInfo");
		if(null==community.getCommunityId()){
			community.setCreateTime(new Date());
			community.setCreater(currentLoginUser.getUserName());
			community.setUpdateTime(new Date());
			community.setStatus("是");
			num = communitysMapper.insert(community);	
			
			// 日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.add(session, community.getCommunityId(), TableName.community, "热门小区信息");
			sysLogMapper.insert(sysLog);
		
		}else{
			community.setUpdateTime(new Date());
			community.setUpdater(currentLoginUser.getUserName());
			num = communitysMapper.updateByPrimaryKeySelective(community);//只更新传值的字段
			// 日志记录编辑案例的日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.edit(session, community.getCommunityId(), TableName.community, "热门小区信息");
			sysLogMapper.insert(sysLog);		
		}
		if(num>0){	
			
			JsonPrintUtil.printObjData(response, "ok");
		}
	}
	
	@RequestMapping("delDocument")
	@ResponseBody
	public void delDocument(String communityIds,HttpSession session,HttpServletResponse response) {
		User currentLoginUser = (User)session.getAttribute("UserInfo");
		if(!StringUtils.isBlank(communityIds)){
			String[] communityIdsArr = communityIds.split(",");
			for(int i=0;i<communityIdsArr.length;i++){
				int rId = Integer.parseInt(communityIdsArr[i]);
				Communitys community = communitysMapper.selectByPrimaryKey(rId);
				community.setStatus("否");
				community.setUpdateTime(new Date());
				community.setUpdater(currentLoginUser.getUserName());
				communitysMapper.updateByPrimaryKeySelective(community);
				
//				日志记录
				SysLog sysLog = new SysLog();
				sysLog =SysLogUtil.delete(session, community.getCommunityId(), TableName.community, "热门小区信息");
				sysLogMapper.insert(sysLog);
				
			}
			JsonPrintUtil.printObjData(response, "ok");
		}else{
			JsonPrintUtil.printObjData(response, "fail");
		}
	}
	

	//缩略图文件上传
	@RequestMapping("/communityImgFileUpload")  
	@ResponseBody
	public void communityImgFileUpload(
			HttpServletRequest request,HttpServletResponse response,MultipartFile file,HttpSession session) {  
		String communityIdStr = request.getParameter("communityId");
		int communityId = 0;
		if(StringUtils.isNotBlank(communityIdStr) && StringUtils.isNumeric(communityIdStr)){			
			communityId = Integer.parseInt(communityIdStr);
		}
		String url = "";
		try {
			Communitys community = communitysMapper.selectByPrimaryKey(communityId);		
			url = "/images/"+super.uploadToFileUrl(file , request,session);
			community.setCommunityImage(url);
			communitysMapper.updateByPrimaryKey(community);
			logger.info("文件上传成功... 服务器保存路径为："+url);
			
			// 日志记录图片上传的日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.upload(session, community.getCommunityId(), TableName.cases, "热门活动缩略图");
			sysLogMapper.insert(sysLog);
			
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		JsonPrintUtil.printObjData(response, url);
	}
	
	/**
	 * 热门小区的模糊查询
	 * @author JhoneZhang
	 * @date   2016年10月13日上午8:06:22
	 * @param page
	 * @param rows
	 * @param bCompany
	 * @param keyWord
	 * @param request
	 * @param response
	 * @param session
	 */
	@RequestMapping("searchListDocument")
	@ResponseBody
	public void searchListDocument(@RequestParam("page") int page,@RequestParam("rows") int rows,String bCompany, String keyWord,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		
		CommunitysExample cx = new CommunitysExample();
		/**
		 * 组合查询，依照小区的名称和隶属分公司查询
		 * 超级管理员可以查看看所有，但是地区只能查看本地区的信息
		 * 
		 * 当bCompany 为“请选择”的时候说明，此时为超级管理员
		 */
		if (StringUtils.isNotBlank(keyWord) && !bCompany.equals("===请选择===")) {
			
			keyWord = "%" + keyWord + "%";
			cx.or().andCommunityNameLike(keyWord).andStatusNotEqualTo("否").andBranchCompanyEqualTo(bCompany);
		}else if(StringUtils.isNotBlank(keyWord) && bCompany.equals("===请选择===")){
			
			keyWord = "%" + keyWord + "%";
			cx.or().andCommunityNameLike(keyWord).andStatusNotEqualTo("否");
		}else if(StringUtils.isBlank(keyWord) && !bCompany.equals("===请选择===")){
			
			cx.or().andStatusNotEqualTo("否").andBranchCompanyEqualTo(bCompany);
		}else{
			
			CommunitysExample.Criteria criteria = cx.createCriteria();
			criteria.andStatusNotEqualTo("否");//非删除状态
		}
		int totalNums = communitysMapper.countByExample(cx);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		cx.setPage(p);
		cx.setOrderByClause("update_time desc");//排序
		List<Communitys> communityList4Page = communitysMapper.selectByExample(cx);
		
//		日志记录
		SysLog sysLog = new SysLog();
		SysLogUtil.search(session, 0,TableName.community,"热门小区信息");
		sysLogMapper.insert(sysLog);
			
		JsonPrintUtil.printGridData(response, communityList4Page, totalNums,"rows","total");
	}
	
	/**
	 * 获取所有的热门小区的名字
	 */
	@RequestMapping("getAllCommunitys")
	@ResponseBody
	public void getAllCommunitys(HttpSession session,HttpServletResponse response){
		
		
		Role currentRole= (Role)session.getAttribute("Role");
		CommunitysExample ce = new CommunitysExample();
		com.scinter.www.model.CommunitysExample.Criteria cc =  ce.createCriteria();
		cc.andStatusEqualTo("是");
		if(currentRole.getRoleName().equals("超级管理员"))
			 cc.andBranchCompanyEqualTo("hsrbw2");
		else	
		    cc.andBranchCompanyEqualTo(currentRole.getBranchCompany());
		ce.setOrderByClause("update_time desc");
		List<Communitys> communityList =  communitysMapper.selectByExample(ce);
		JsonPrintUtil.printObjDataWithNoRoot(response, communityList);
	}
}
