package com.scinter.www.controller;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.scinter.www.dao.CaseShowImageMapper;
import com.scinter.www.dao.CasesMapper;
import com.scinter.www.dao.CommunitysMapper;
import com.scinter.www.dao.DesignerMapper;
import com.scinter.www.dao.SysConfigMapper;
import com.scinter.www.dao.SysLogMapper;
import com.scinter.www.model.CaseShowImage;
import com.scinter.www.model.CaseShowImageExample;
import com.scinter.www.model.CaseShowImageExample.Criteria;
import com.scinter.www.model.Cases;
import com.scinter.www.model.CasesExample;
import com.scinter.www.model.Designer;
import com.scinter.www.model.Role;
import com.scinter.www.model.SysLog;
import com.scinter.www.model.User;
import com.scinter.www.util.JsonPrintUtil;
import com.scinter.www.util.Page;
import com.scinter.www.util.SysLogUtil;
import com.scinter.www.util.TableName;

@Controller
@RequestMapping("admin")
public class CaseController extends BaseController {

	private Logger logger = Logger.getLogger(CaseController.class);

	@Autowired
	private CasesMapper caseMapper;
	@Autowired
	private SysLogMapper sysLogMapper;
	@Autowired
	private CaseShowImageMapper caseImgMapper;
	@Autowired
	private DesignerMapper designerMapper;
	@Autowired
	private SysConfigMapper sysConfigMapper;
	@Autowired
	private CommunitysMapper communityMapper;
	
	@RequestMapping("listCaseToJson")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void listCasesToJson(
			@RequestParam("page") int page,@RequestParam("rows") int rows,
			HttpServletRequest request,HttpSession session ,HttpServletResponse response) {
		
		
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
		CasesExample rx = new CasesExample();
		com.scinter.www.model.CasesExample.Criteria criteria = rx.createCriteria();
		criteria.andCaseStatusEqualTo(1); // 案例的正常的显示
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
		int totalNums = caseMapper.countByExample(rx);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		rx.setPage(p);
		rx.setOrderByClause("create_time desc");//排序
		List<Cases> caseList4Page = caseMapper.selectByExample(rx);
		
		List<Cases> caseListNew = new ArrayList<Cases>();
		for(Cases cs : caseList4Page){
			Designer ds = designerMapper.selectByPrimaryKey(cs.getDesignerId());
			if(null!=ds){
				cs.setCaseDesigner(ds.getDesignerName());
				caseListNew.add(cs);
			}
		}
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0, TableName.cases, "装修案例列表信息");
		sysLogMapper.insert(sysLog);
		session.setAttribute("myBranchCompany", branchCompany);
		JsonPrintUtil.printGridData(response, caseListNew, totalNums,"rows","total");
	}
	
	@RequestMapping("searchListCases")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void searchListCases(@RequestParam("page") int page,@RequestParam("rows") int rows,String BCompany, String keyWord,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
		
		CasesExample cx = new CasesExample();
		if (StringUtils.isNotBlank(keyWord) && !BCompany.equals("===请选择===")) {
			keyWord = "%" + keyWord + "%";
			//and or联合查询
			cx.or().andCaseTitleLike(keyWord).andCaseStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
			cx.or().andCaseCommunityLike(keyWord).andCaseStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
			cx.or().andCaseDesignerLike(keyWord).andCaseStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
			cx.or().andCaseDescLike(keyWord).andCaseStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
		}else if(StringUtils.isNotBlank(keyWord) && BCompany.equals("===请选择===")){
			keyWord = "%" + keyWord + "%";
			cx.or().andCaseTitleLike(keyWord).andCaseStatusNotEqualTo(3).andBranchCompanyEqualTo(branchCompany);
			cx.or().andCaseCommunityLike(keyWord).andCaseStatusNotEqualTo(3).andBranchCompanyEqualTo(branchCompany);
			cx.or().andCaseDesignerLike(keyWord).andCaseStatusNotEqualTo(3).andBranchCompanyEqualTo(branchCompany);
			cx.or().andCaseDescLike(keyWord).andCaseStatusNotEqualTo(3).andBranchCompanyEqualTo(branchCompany);
		}else if(StringUtils.isBlank(keyWord) && !BCompany.equals("===请选择===")){
			
			cx.or().andCaseStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
			cx.or().andCaseStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
			cx.or().andCaseStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
			cx.or().andCaseStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
		}else{
			String roleName = currentRole.getRoleName();
			if(!"超级管理员".equals(roleName)){
				CasesExample.Criteria criteria = cx.createCriteria();
				criteria.andCaseStatusNotEqualTo(3);//非删除状态
				criteria.andBranchCompanyEqualTo(currentRole.getBranchCompany());//当前用户所属分公司
			}else{
				CasesExample.Criteria criteria = cx.createCriteria();
				criteria.andCaseStatusNotEqualTo(3);//非删除状态
			}
			
		}
		int totalNums = caseMapper.countByExample(cx);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		cx.setPage(p);
		cx.setOrderByClause("create_time desc");//排序
		List<Cases> casesList4Page = caseMapper.selectByExample(cx);
		
//		日志记录
		
		SysLog sysLog = new SysLog();
		SysLogUtil.search(session, 0,TableName.cases,"装修案例列表信息");
		sysLogMapper.insert(sysLog);
			
		JsonPrintUtil.printGridData(response, casesList4Page, totalNums,"rows","total");
	}

	
	@RequestMapping("showCase")
	public ModelAndView showCase(
			@RequestParam(value= "company",required=false)String company,
			@RequestParam("caseId") int caseId, HttpSession session){
		
		
		ModelAndView model = new ModelAndView();
		Cases case1 = caseMapper.selectByPrimaryKey(caseId);
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
		// 日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, case1.getCaseId(), TableName.cases, "装修案例信息");
		sysLogMapper.insert(sysLog);		
		
		model.addObject("caseInfo", case1);
		
		CaseShowImageExample ex = new CaseShowImageExample();
		Criteria criteria = ex.createCriteria();
		criteria.andCaseIdEqualTo(caseId);
		criteria.andStatusEqualTo("1");//状态1是 未删除的图片
		ex.setOrderByClause("create_time asc");//排序
	
		
		List<CaseShowImage> listCaseImage = caseImgMapper.selectByExample(ex);
		model.addObject("caseImgShowList", listCaseImage);
		model.addObject("branchCompany", branchCompany);
		if(StringUtils.isNotBlank(company)){
			if(company.equals("rrlCompany")){
				model.setViewName("/admin/rrlCaseSave");
			}
		}else{
			model.setViewName("/admin/caseSave");
		}
		return model;
	}
	
	
	/**
	 * 
	 * 案例和小区
	 * 
	 * @author JhoneZhang
	 * @date   2016年11月1日上午8:35:32
	 * @param case1
	 * @param response
	 * @param request
	 * @param session
	 */
	@RequestMapping("saveCase")
	@ResponseBody
	public void saveCase(Cases case1,HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		
	    /*保存案例列表页的SEO信息*/
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();  
		String branchStr = branchCompany.substring(branchCompany.length()-2,branchCompany.length());
	    logger.info("获取到的分公司的信息为："+branchStr);
		int num = 0;
		User currentLoginUser = (User)request.getSession().getAttribute("UserInfo");
		if(null == case1.getCaseId()){
			
			case1.setCreateTime(new Date());
			case1.setCreater(currentLoginUser.getUserName());
			case1.setUpdateTime(new Date());
			case1.setCaseStatus(1);
			num = caseMapper.insert(case1);	
			
			int caseId = case1.getCaseId();
			//更新关联的案例图片信息
			String caseImageIdArr = request.getParameter("caseImageIdArr");
			CaseShowImage img = null;
			if(StringUtils.isNotBlank(caseImageIdArr)){
				String[] imgIdArr = caseImageIdArr.split(",");
				for(String imageIdStr : imgIdArr){
					if(StringUtils.isNotBlank(imageIdStr) && StringUtils.isNumeric(imageIdStr)){
						img = new CaseShowImage();
						int imageId = Integer.parseInt(imageIdStr);
						img.setImageId(imageId);
						img.setCaseId(caseId);
						img.setUpdateTime(new Date());
						img.setUpdater(currentLoginUser.getUserName());
						caseImgMapper.updateByPrimaryKeySelective(img);
					}
				}
			}
			
//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.add(session, case1.getCaseId(), TableName.cases, "装修案例信息");
			sysLogMapper.insert(sysLog);
		
		}else{
			
			/**
			 * 实现热装小区数量的更新
			 * 条件：小区的id是否为一直，如果不一致则执行更改，如果一直则不会执行更新
			 * 
			 * 存在null 的情况，
			 */
			case1.setUpdateTime(new Date());
			case1.setUpdater(currentLoginUser.getUserName());
			num = caseMapper.updateByPrimaryKeySelective(case1);//只更新传值的字段
			
//			日志记录编辑案例的日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.edit(session, case1.getCaseId(), TableName.repair, "装修案例信息");
			sysLogMapper.insert(sysLog);		
		}
		if(num>0){	
			
			JsonPrintUtil.printObjData(response, "ok");
		}
	}
	
	@RequestMapping("delCase")
	@ResponseBody
	public void delCase(String caseIds,HttpSession session,HttpServletResponse response) {
		User currentLoginUser = (User)session.getAttribute("UserInfo");
		if(!StringUtils.isBlank(caseIds)){
			String[] caseIdsArr = caseIds.split(",");
			for(int i=0;i<caseIdsArr.length;i++){
				int rId = Integer.parseInt(caseIdsArr[i]);
				Cases case1 = caseMapper.selectByPrimaryKey(rId);
				case1.setCaseStatus(3);
				case1.setUpdateTime(new Date());
				case1.setUpdater(currentLoginUser.getUserName());
				caseMapper.updateByPrimaryKeySelective(case1);
				
//				日志记录
				SysLog sysLog = new SysLog();
				sysLog =SysLogUtil.delete(session, case1.getCaseId(), TableName.cases, "装修案例信息");
				sysLogMapper.insert(sysLog);
				
			}
			JsonPrintUtil.printObjData(response, "ok");
		}else{
			JsonPrintUtil.printObjData(response, "fail");
		}
	}
	
	@RequestMapping("delCaseImage")
	@ResponseBody
	public void delCaseImage(String caseImageId,HttpSession session,HttpServletResponse response) {
		User currentLoginUser = (User)session.getAttribute("UserInfo");
		if(!StringUtils.isBlank(caseImageId)){
			int cId = Integer.parseInt(caseImageId);
			CaseShowImage csi = caseImgMapper.selectByPrimaryKey(cId);
			csi.setStatus("3");
			csi.setUpdateTime(new Date());
			csi.setUpdater(currentLoginUser.getUserName());
			caseImgMapper.updateByPrimaryKeySelective(csi);
			JsonPrintUtil.printObjData(response, "ok");
			
//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.delete(session, csi.getCaseId(), TableName.cases_show_image, "装修案例展示图");
			sysLogMapper.insert(sysLog);

		}else{
			JsonPrintUtil.printObjData(response, "fail");
		}
	}
	
	//缩略图文件上传
	@RequestMapping("/caseThumbImgFileUpload")  
	@ResponseBody
	public void caseThumbImgFileUpload(HttpServletRequest request,HttpServletResponse response,MultipartFile file,HttpSession session) {  
		String caseIdStr = request.getParameter("caseId");
		int caseId = 0;
		if(StringUtils.isNotBlank(caseIdStr) && StringUtils.isNumeric(caseIdStr)){			
			caseId = Integer.parseInt(caseIdStr);
		}
		String url = "";
		try {
			Cases caseObj = caseMapper.selectByPrimaryKey(caseId);		
			url = "/images/"+super.uploadToFileUrl(file , request,session);
			caseObj.setCaseThumbImg(url);
			caseMapper.updateByPrimaryKey(caseObj);
			logger.info("文件上传成功... 服务器保存路径为："+url);
			
//			日志记录图片上传的日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.upload(session, caseObj.getCaseId(), TableName.cases, "装修案例缩略图");
			sysLogMapper.insert(sysLog);
			
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		JsonPrintUtil.printObjData(response, url);
	}
	
	//展示图片上传
	@RequestMapping("/caseImgFileListUpload") 
	@ResponseBody
	public void caseImgFileListUpload(HttpServletRequest request,HttpSession session,HttpServletResponse response,MultipartFile file) {  
		User user = (User)request.getSession().getAttribute("UserInfo");
		String caseIdStr = request.getParameter("caseId");
		int caseId = 0;
		if(StringUtils.isNotBlank(caseIdStr) && StringUtils.isNumeric(caseIdStr)){			
			caseId = Integer.parseInt(caseIdStr);
		}
		
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			JSONObject json = new JSONObject();
			String path = "/images/"+super.uploadToFileUrl(file , request,session);
			logger.info("文件上传成功... 服务器保存路径为："+path);
			//图片信息入库
			CaseShowImage img = new CaseShowImage();
			//关联案例
			img.setCreateTime(new Date());
			img.setCreater(user.getUserName());
			img.setImageUrl(path);
			img.setCaseId(caseId);
			img.setStatus("1");
			caseImgMapper.insert(img);
			int imgId = img.getImageId();
			json.put("imageId", imgId);
			json.put("url", path);
			
//				日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.upload(session, img.getImageId(), TableName.cases_show_image, "装修案例展示图片");
			sysLogMapper.insert(sysLog);				
			
			out.print(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}		
	}
	
	@RequestMapping("selectCaseaByCompany")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void selectCaseaByCompany(@RequestParam("page") int page,@RequestParam("rows") int rows,String keyWord,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		
		
		
		CasesExample cx = new CasesExample();
		
		com.scinter.www.model.CasesExample.Criteria criteria = cx.createCriteria();
		criteria.andCaseStatusNotEqualTo(3);
	   if(keyWord!="all"){
			
		   criteria.andBranchCompanyEqualTo(keyWord);
		}
		int totalNums = caseMapper.countByExample(cx);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		
		cx.setPage(p);
		cx.setOrderByClause("create_time desc");//排序
		List<Cases> casesList4Page = caseMapper.selectByExample(cx);
		
//		日志记录
		
		SysLog sysLog = new SysLog();
		SysLogUtil.search(session, 0,TableName.cases,"装修案例列表信息");
		sysLogMapper.insert(sysLog);
			
		JsonPrintUtil.printGridData(response, casesList4Page, totalNums,"rows","total");
	}
}
