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
import com.scinter.www.dao.IntegratedPackageMapper;
import com.scinter.www.dao.SysConfigMapper;
import com.scinter.www.dao.SysLogMapper;
import com.scinter.www.model.CaseShowImage;
import com.scinter.www.model.CaseShowImageExample;
import com.scinter.www.model.CaseShowImageExample.Criteria;
import com.scinter.www.model.Cases;
import com.scinter.www.model.CasesExample;
import com.scinter.www.model.Communitys;
import com.scinter.www.model.Designer;
import com.scinter.www.model.IntegratedPackage;
import com.scinter.www.model.IntegratedPackageExample;
import com.scinter.www.model.Role;
import com.scinter.www.model.SysLog;
import com.scinter.www.model.User;
import com.scinter.www.util.JsonPrintUtil;
import com.scinter.www.util.Page;
import com.scinter.www.util.SysLogUtil;
import com.scinter.www.util.TableName;

@Controller
@RequestMapping("admin")
public class packageOldController extends BaseController {

	private Logger logger = Logger.getLogger(packageOldController.class);

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
	@Autowired
	private IntegratedPackageMapper integratedPackageMapper;
	
	@RequestMapping("listPackageToJson")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void listPackageToJson(
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
		IntegratedPackageExample ie = new IntegratedPackageExample();
		com.scinter.www.model.IntegratedPackageExample.Criteria criteria = ie.createCriteria();
		criteria.andIntegratedPackageStatusEqualTo(true);
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
		int totalNums = integratedPackageMapper.countByExample(ie);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		ie.setPage(p);
		ie.setOrderByClause("create_time desc");//排序
		List<IntegratedPackage> packageList4Page = integratedPackageMapper.selectByExample(ie);
		
		session.setAttribute("myBranchCompany", branchCompany);
		JsonPrintUtil.printGridData(response, packageList4Page, totalNums,"rows","total");
	}
	
	@RequestMapping("searchListPackages")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void searchListPackages(@RequestParam("page") int page,@RequestParam("rows") int rows,String BCompany, String keyWord,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
		
		IntegratedPackageExample  ie= new IntegratedPackageExample();
		if (StringUtils.isNotBlank(keyWord) && !BCompany.equals("===请选择===")) {
			keyWord = "%" + keyWord + "%";
			//and or联合查询
			ie.or().andIntegratedPackageNameLike(keyWord).andIntegratedPackageStatusEqualTo(true).andBranchCompanyEqualTo(BCompany);
		}else if(StringUtils.isNotBlank(keyWord) && BCompany.equals("===请选择===")){
			keyWord = "%" + keyWord + "%";
			ie.or().andIntegratedPackageNameLike(keyWord).andIntegratedPackageStatusEqualTo(true).andBranchCompanyEqualTo(branchCompany);
		}else if(StringUtils.isBlank(keyWord) && !BCompany.equals("===请选择===")){
			
			ie.or().andIntegratedPackageStatusEqualTo(true).andBranchCompanyEqualTo(BCompany);
		}else{
			String roleName = currentRole.getRoleName();
			if(!"超级管理员".equals(roleName)){
				com.scinter.www.model.IntegratedPackageExample.Criteria criteria = ie.createCriteria();
				criteria.andIntegratedPackageStatusEqualTo(true);
				criteria.andBranchCompanyEqualTo(currentRole.getBranchCompany());//当前用户所属分公司
			}else{
				com.scinter.www.model.IntegratedPackageExample.Criteria criteria = ie.createCriteria();
				criteria.andIntegratedPackageStatusEqualTo(true);//非删除状态
			}
			
		}
		int totalNums = integratedPackageMapper.countByExample(ie);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		ie.setPage(p);
		ie.setOrderByClause("create_time desc");//排序
		List<IntegratedPackage> packageList4Page = integratedPackageMapper.selectByExample(ie);
		
		JsonPrintUtil.printGridData(response, packageList4Page, totalNums,"rows","total");
	}

	
	@RequestMapping("showPackage")
	public ModelAndView showPackage(
			@RequestParam(value= "company",required=false)String company,
			@RequestParam("integratedPackageId") int integratedPackageId, HttpSession session){
		
		
		ModelAndView model = new ModelAndView();
		IntegratedPackage integratedPackage = integratedPackageMapper.selectByPrimaryKey(integratedPackageId);
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
		
		model.addObject("packageInfo", integratedPackage);
		model.addObject("branchCompany", branchCompany);
		model.setViewName("/admin/lftcSave");
		return model;
	}
	
	
	/**
	 * 老房套餐
	 * 
	 * @author JhoneZhang
	 * @date   2016年11月2日下午3:20:55
	 * @param case1
	 * @param response
	 * @param request
	 * @param session
	 */
	@RequestMapping("savePackageOld")
	@ResponseBody
	public void savePackageOld(IntegratedPackage integratedPackage,HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		
	    /*保存案例列表页的SEO信息*/
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();  
		String branchStr = branchCompany.substring(branchCompany.length()-2,branchCompany.length());
	    logger.info("获取到的分公司的信息为："+branchStr);
		int num = 0;
		User currentLoginUser = (User)request.getSession().getAttribute("UserInfo");
		Integer currentId = integratedPackage.getIntegratedPackageId();
		if(null == integratedPackage.getIntegratedPackageId()){
			
			integratedPackage.setCreateTime(new Date());
			integratedPackage.setCreater(currentLoginUser.getUserName());
			integratedPackage.setUpdateTime(new Date());
			integratedPackage.setIntegratedPackageStatus(true);
			num = integratedPackageMapper.insert(integratedPackage);	
		
		}else{
			
			integratedPackage.setUpdateTime(new Date());
			integratedPackage.setUpdater(currentLoginUser.getUserName());
			num = integratedPackageMapper.updateByPrimaryKeySelective(integratedPackage);
		}
		if(num>0){	
			JsonPrintUtil.printObjData(response, "ok");
		}
	}
	
	@RequestMapping("delPackage")
	@ResponseBody
	public void delPackage(String integratedPackageIds,HttpSession session,HttpServletResponse response) {
		
		User currentLoginUser = (User)session.getAttribute("UserInfo");
		if(!StringUtils.isBlank(integratedPackageIds)){
			String[] integratedPackageIdsArr = integratedPackageIds.split(",");
			for(int i=0;i<integratedPackageIdsArr.length;i++){
				
				int rId = Integer.parseInt(integratedPackageIdsArr[i]);
				IntegratedPackage integratedPackage =integratedPackageMapper.selectByPrimaryKey(rId);
				integratedPackage.setIntegratedPackageStatus(false);
				integratedPackage.setUpdateTime(new Date());
				integratedPackage.setUpdater(currentLoginUser.getUserName());
				integratedPackageMapper.updateByPrimaryKeySelective(integratedPackage);
			}
			JsonPrintUtil.printObjData(response, "ok");
		}else{
			JsonPrintUtil.printObjData(response, "fail");
		}
	}
	
	@RequestMapping("delPackageImage")
	@ResponseBody
	public void delPackageImage(String caseImageId,HttpSession session,HttpServletResponse response) {
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
	@RequestMapping("/packageThumbImgFileUpload")  
	@ResponseBody
	public void packageThumbImgFileUpload(HttpServletRequest request,HttpServletResponse response,MultipartFile file,HttpSession session) {  
		String integratedPackageIdStr = request.getParameter("integratedPackageId");
		int integratedPackageId = 0;
		if(StringUtils.isNotBlank(integratedPackageIdStr) && StringUtils.isNumeric(integratedPackageIdStr)){			
			integratedPackageId = Integer.parseInt(integratedPackageIdStr);
		}
		String url = "";
		try {
			IntegratedPackage integratedPackageObj = integratedPackageMapper.selectByPrimaryKey(integratedPackageId)	;	
			url = "/images/"+super.uploadToFileUrl(file , request,session);
			integratedPackageObj.setIntegratedPackageImage(url);
			integratedPackageMapper.updateByPrimaryKey(integratedPackageObj);
			
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		JsonPrintUtil.printObjData(response, url);
	}
	
}
