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
import com.scinter.www.dao.DesignerMapper;
import com.scinter.www.dao.SysLogMapper;
import com.scinter.www.model.Cases;
import com.scinter.www.model.CasesExample;
import com.scinter.www.model.Designer;
import com.scinter.www.model.DesignerExample;
import com.scinter.www.model.Role;
import com.scinter.www.model.DesignerExample.Criteria;
import com.scinter.www.model.SysLog;
import com.scinter.www.model.User;
import com.scinter.www.util.JsonPrintUtil;
import com.scinter.www.util.Page;
import com.scinter.www.util.SysLogUtil;
import com.scinter.www.util.TableName;

@Controller
@RequestMapping("admin")
public class DesignerController extends BaseController {

	private Logger logger = Logger.getLogger(DesignerController.class);
	@Autowired
	private DesignerMapper designerMapper;
	@Autowired
	private CasesMapper caseMapper;
	@Autowired
	private SysLogMapper sysLogMapper;
	
	@RequestMapping("listDesignerToJson")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void listDesignerToJson(@RequestParam("page") int page,@RequestParam("rows") int rows,HttpSession session ,HttpServletResponse response) {
		
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
		DesignerExample rx = new DesignerExample();
		Criteria criteria = rx.createCriteria();
		criteria.andStatusNotEqualTo(3);//非删除状态
		
		Role currentRole= (Role)session.getAttribute("Role");
		String roleName = currentRole.getRoleName();
		if(!"超级管理员".equals(roleName)){
			String branchCompany = currentRole.getBranchCompany();
			criteria.andBranchCompanyEqualTo(branchCompany);//当前用户所属分公司
		}else{
			
			criteria.andBranchCompanyLike("%"+spilCompany+"%");
		}
		
		int totalNums = designerMapper.countByExample(rx);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		rx.setPage(p);
		rx.setOrderByClause("update_time desc");//排序
		List<Designer> designerList4Page = designerMapper.selectByExample(rx);
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0, TableName.designer, "设计师列表信息");
		sysLogMapper.insert(sysLog);
		
		JsonPrintUtil.printGridData(response, designerList4Page, totalNums,"rows","total");
	}
	
	@RequestMapping("searchListDesigner")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void searchListDesigner(@RequestParam("page") int page,@RequestParam("rows") int rows,String BCompany,String keyWord,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
		DesignerExample dx = new DesignerExample();
		if (StringUtils.isNotBlank(keyWord) && !BCompany.equals("===请选择===")) {
			keyWord = "%" + keyWord + "%";
			//and or联合查询
			dx.or().andDesignerNameLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
			dx.or().andDesignerSchoolLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
			dx.or().andDesignerBirthPlaceLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
		}else if(StringUtils.isNotBlank(keyWord) && BCompany.equals("===请选择===")) {
			keyWord = "%" + keyWord + "%";
			//and or联合查询
			dx.or().andDesignerNameLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(branchCompany);
			dx.or().andDesignerSchoolLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(branchCompany);
			dx.or().andDesignerBirthPlaceLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(branchCompany);
		}else if(StringUtils.isBlank(keyWord) && !BCompany.equals("===请选择===")) {
			keyWord = "%" + keyWord + "%";
			//and or联合查询
			Criteria criteria = dx.createCriteria();
			criteria.andStatusNotEqualTo(3);//非删除状态
			criteria.andBranchCompanyEqualTo(BCompany);
		}else{
			String roleName = currentRole.getRoleName();
			if(!"超级管理员".equals(roleName)){
				Criteria criteria = dx.createCriteria();
				criteria.andStatusNotEqualTo(3);//非删除状态
				criteria.andBranchCompanyEqualTo(branchCompany);//当前用户所属分公司
			}else{
				Criteria criteria = dx.createCriteria();
				criteria.andStatusNotEqualTo(3);//非删除状态
			}
			
		}
		int totalNums = designerMapper.countByExample(dx);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		dx.setPage(p);
		dx.setOrderByClause("create_time desc");//排序
		List<Designer> designersList4Page = designerMapper.selectByExample(dx);
		
//		循环遍历打印查询的记录
		for(Designer designer:designersList4Page){
			
//		日志记录设计师的查询
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, designer.getDesignerId(), TableName.designer, "设计师信息");
		sysLogMapper.insert(sysLog);
			
		}
		JsonPrintUtil.printGridData(response, designersList4Page, totalNums,"rows","total");
	}
	

	// 下拉列表
	@RequestMapping("listAllDesigner")
	@ResponseBody
	public void listAllDesigner(
			@RequestParam(value="company",required=false)String company,
			HttpServletResponse response,HttpSession session) {
		
	    logger.info("the value of company is:"+company);
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
		DesignerExample dx = new DesignerExample();
		Criteria criteria = dx.createCriteria();
		criteria.andStatusNotEqualTo(3);//非删除状态
		if(StringUtils.isNotBlank(company)){
			criteria.andBranchCompanyEqualTo(company);
		}else{
			criteria.andBranchCompanyEqualTo(branchCompany);
		}
		dx.setOrderByClause("designer_id desc");
		List<Designer> dList = designerMapper.selectByExample(dx);
		JsonPrintUtil.printObjDataWithNoRoot(response, dList);
	}
	
	@RequestMapping("showDesigner")
	public ModelAndView showDesigner(int designerId,HttpSession session){
		ModelAndView model = new ModelAndView();
		Designer designer = designerMapper.selectByPrimaryKey(designerId);
		
		String designerName = designer.getDesignerName();
		
		CasesExample rx = new CasesExample();
		CasesExample.Criteria criteria = rx.createCriteria();
		criteria.andCaseStatusNotEqualTo(3);//非删除状态
		criteria.andCaseDesignerEqualTo(designerName);
		List<Cases> caseList = caseMapper.selectByExample(rx);
		model.addObject("caseList", caseList);
		model.addObject("designer", designer);
		model.setViewName("/admin/designerSave");
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, designer.getDesignerId(), TableName.designer, "设计师信息");
		sysLogMapper.insert(sysLog);
		
		return model;
	}
	
	@RequestMapping("saveDesigner")
	@ResponseBody
	public void saveDesigner(Designer designer,HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		int num = 0;
		User currentLoginUser = (User)request.getSession().getAttribute("UserInfo");
		if(null==designer.getDesignerId()){
			designer.setStatus(1);
			designer.setCreateTime(new Date());
			designer.setCreater(currentLoginUser.getUserName());
			designer.setUpdateTime(new Date());
			num = designerMapper.insert(designer);
//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.add(session, designer.getDesignerId(), TableName.designer, "设计师信息");
			sysLogMapper.insert(sysLog);
			
		}else{
			designer.setUpdateTime(new Date());
			designer.setUpdater(currentLoginUser.getUserName());
			num = designerMapper.updateByPrimaryKeySelective(designer);//只更新传值的字段
			
//			日志记录设计师的更新
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.edit(session, designer.getDesignerId(), TableName.designer, "设计师信息");
			sysLogMapper.insert(sysLog);
		}
		if(num>0){	
			JsonPrintUtil.printObjData(response, "ok");
		}
	}
	
	@RequestMapping("delDesigner")
	@ResponseBody
	public void delDesigner(String designerIds,HttpSession session,HttpServletResponse response) {
		User currentLoginUser = (User)session.getAttribute("UserInfo");
		if(!StringUtils.isBlank(designerIds)){
			String[] designerIdsArr = designerIds.split(",");
			for(int i=0;i<designerIdsArr.length;i++){
				int rId = Integer.parseInt(designerIdsArr[i]);
				Designer designer = designerMapper.selectByPrimaryKey(rId);
				designer.setStatus(3);//1正常  3删除
				designer.setUpdateTime(new Date());
				designer.setUpdater(currentLoginUser.getUserName());
				designerMapper.updateByPrimaryKeySelective(designer);
				
//				日志记录
			
				SysLog sysLog = new SysLog();
				sysLog =SysLogUtil.delete(session, designer.getDesignerId(), TableName.designer, "设计师信息");
				sysLogMapper.insert(sysLog);
			}
			JsonPrintUtil.printObjData(response, "ok");
		}else{
			JsonPrintUtil.printObjData(response, "fail");
		}
	}
	
	@RequestMapping("/designerImgFileUpload")  
	@ResponseBody
	public void designerImgFileUpload(int t,HttpSession session,HttpServletRequest request,HttpServletResponse response,MultipartFile file) {  
	    
		String designerIdStr = request.getParameter("designerId");
		int designerId = 0;
		if(StringUtils.isNotBlank(designerIdStr) && StringUtils.isNumeric(designerIdStr)){			
			designerId = Integer.parseInt(designerIdStr);
		}
		
		String url = "";
	    Designer designer = designerMapper.selectByPrimaryKey(designerId);
		try {
			url = "/images/"+super.uploadToFileUrl(file , request, session);
			if(t==1){
				//个人照片
				designer.setDesignerPhotoImg(url);
				designerMapper.updateByPrimaryKeySelective(designer);
				
//				日志记录
				SysLog sysLog = new SysLog();
				sysLog =SysLogUtil.upload(session, designer.getDesignerId(), TableName.designer, "个人照片");
				sysLogMapper.insert(sysLog);
				
			}else if(t==2){
				//证书
				designer.setDesignerCertificateImg(url);
				designerMapper.updateByPrimaryKeySelective(designer);
				
//				日志记录
				SysLog sysLog = new SysLog();
				sysLog =SysLogUtil.upload(session, designer.getDesignerId(), TableName.designer, "证书照片");
				sysLogMapper.insert(sysLog);
				
			}
			logger.info("文件上传成功... 服务器保存路径为："+url);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		JsonPrintUtil.printObjData(response, url);
	}
	
}
