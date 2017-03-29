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

import com.scinter.www.dao.CaseShowImageMapper;
import com.scinter.www.dao.CasesMapper;
import com.scinter.www.dao.CommunitysMapper;
import com.scinter.www.dao.DesignerMapper;
import com.scinter.www.dao.HomeTurnImgMapper;
import com.scinter.www.dao.SysConfigMapper;
import com.scinter.www.dao.SysLogMapper;
import com.scinter.www.model.CaseShowImage;
import com.scinter.www.model.HomeTurnImg;
import com.scinter.www.model.HomeTurnImgExample;
import com.scinter.www.model.HomeTurnImgExample.Criteria;
import com.scinter.www.model.Role;
import com.scinter.www.model.SysLog;
import com.scinter.www.model.User;
import com.scinter.www.util.JsonPrintUtil;
import com.scinter.www.util.Page;
import com.scinter.www.util.SysLogUtil;
import com.scinter.www.util.TableName;

@Controller
@RequestMapping("admin")
public class SyhdlbController extends BaseController {

	private Logger logger = Logger.getLogger(CaseController.class);

	@Autowired
	private CasesMapper caseMapper;
	@Autowired
	private SysLogMapper sysLogMapper;
	@Autowired
	private CaseShowImageMapper caseImgMapper;//案例包含图片的dao操作对象
	@Autowired
	private DesignerMapper designerMapper;
	@Autowired
	private SysConfigMapper sysConfigMapper;
	@Autowired
	private CommunitysMapper communityMapper;
	@Autowired
	private HomeTurnImgMapper homeTurnImgMapper;
	
	@RequestMapping("listSyhdlbToJson")
	@ResponseBody
	public void listSyhdlbToJson(@RequestParam("page") int page,@RequestParam("rows") int rows,HttpServletRequest request,HttpSession session ,HttpServletResponse response) {
		
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
		HomeTurnImgExample he = new HomeTurnImgExample();
		com.scinter.www.model.HomeTurnImgExample.Criteria criteria =  he.createCriteria();
		criteria.andStateEqualTo(0); 
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
		int totalNums = homeTurnImgMapper.countByExample(he);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		he.setPage(p);
		he.setOrderByClause("create_time desc");//排序
		List<HomeTurnImg> homeImgList4Page = homeTurnImgMapper.selectByExample(he);
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0, TableName.cases, "首页轮播图列表信息");
		sysLogMapper.insert(sysLog);
		session.setAttribute("myBranchCompany", branchCompany);
		JsonPrintUtil.printGridData(response, homeImgList4Page, totalNums,"rows","total");
	}
	
	/**
	 * 首页轮播图信息展示
	 * @author JhoneZhang
	 * @date   2016年10月16日上午9:34:36
	 * @param company
	 * @param caseId
	 * @param session
	 * @return
	 */
	@RequestMapping("showSyhdlb")
	public ModelAndView showSyhdlb(
			@RequestParam(value= "company",required=false)String company,
			@RequestParam("homeImgId") int homeImgId, HttpSession session){
		
		
		ModelAndView model = new ModelAndView();
		HomeTurnImg homeTurnImg = homeTurnImgMapper.selectByPrimaryKey(homeImgId);
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, homeTurnImg.getHomeimgId(), TableName.homeTurnImg, "首页轮播图信息");
		sysLogMapper.insert(sysLog);		
		model.addObject("homeTurnInfo", homeTurnImg);
		model.addObject("branchCompany", branchCompany);
		model.setViewName("/admin/syhdlbSave");
		return model;
	}
	
	
	@RequestMapping("searchListSyhdlb")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void searchListCases(@RequestParam("page") int page,@RequestParam("rows") int rows,String BCompany, String keyWord,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
		HomeTurnImgExample cx = new HomeTurnImgExample();
		if (StringUtils.isNotBlank(keyWord) && !BCompany.equals("===请选择===")) {
			keyWord = "%" + keyWord + "%";
			//and or联合查询
			cx.or().andHomeimgNameLike(keyWord).andStateEqualTo(0).andBranchCompanyEqualTo(BCompany);
		}else if(StringUtils.isNotBlank(keyWord) && BCompany.equals("===请选择===")){
			keyWord = "%" + keyWord + "%";
			cx.or().andHomeimgNameLike(keyWord).andStateEqualTo(0).andBranchCompanyEqualTo(branchCompany);
		}else if(StringUtils.isBlank(keyWord) && !BCompany.equals("===请选择===")){
			cx.or().andStateEqualTo(0).andBranchCompanyEqualTo(BCompany);
		}else{
			String roleName = currentRole.getRoleName();
			if(!"超级管理员".equals(roleName)){
				Criteria criteria = cx.createCriteria();
				criteria.andStateNotEqualTo(0);
				criteria.andBranchCompanyEqualTo(currentRole.getBranchCompany());
			}else{
				Criteria criteria = cx.createCriteria();
				criteria.andStateEqualTo(0);
			}
		}
		int totalNums = homeTurnImgMapper.countByExample(cx);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		cx.setPage(p);
		cx.setOrderByClause("update_time desc");//排序
		List<HomeTurnImg> homeTurnListPage = homeTurnImgMapper.selectByExample(cx);
		// 日志记录
		SysLog sysLog = new SysLog();
		SysLogUtil.search(session, 0,TableName.homeTurnImg,"装修案例列表信息");
		sysLogMapper.insert(sysLog);
		JsonPrintUtil.printGridData(response, homeTurnListPage, totalNums,"rows","total");
	}


	/**
	 * 手机活动轮播列表展示页
	 */
	@RequestMapping("listSyhdlbToJsonm")
	@ResponseBody
	public void mlistSyhdlbToJson(@RequestParam("page") int page,@RequestParam("rows") int rows,HttpServletRequest request,HttpSession session ,HttpServletResponse response) {
		
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
		HomeTurnImgExample he = new HomeTurnImgExample();
		com.scinter.www.model.HomeTurnImgExample.Criteria criteria =  he.createCriteria();
		criteria.andStateEqualTo(2); 
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
		int totalNums = homeTurnImgMapper.countByExample(he);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		he.setPage(p);
		he.setOrderByClause("create_time desc");//排序
		List<HomeTurnImg> homeImgList4Page = homeTurnImgMapper.selectByExample(he);
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0, TableName.cases, "首页轮播图列表信息");
		sysLogMapper.insert(sysLog);
		session.setAttribute("myBranchCompany", branchCompany);
		JsonPrintUtil.printGridData(response, homeImgList4Page, totalNums,"rows","total");
	}
	
	/**
	 * 首页轮播图信息展示
	 * @author JhoneZhang
	 * @date   2016年10月16日上午9:34:36
	 * @param company
	 * @param caseId
	 * @param session
	 * @return
	 */
	@RequestMapping("showSyhdlbm")
	public ModelAndView mshowSyhdlb(
			@RequestParam(value= "company",required=false)String company,
			@RequestParam("homeImgId") int homeImgId, HttpSession session){
		
		
		ModelAndView model = new ModelAndView();
		HomeTurnImg homeTurnImg = homeTurnImgMapper.selectByPrimaryKey(homeImgId);
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, homeTurnImg.getHomeimgId(), TableName.homeTurnImg, "首页轮播图信息");
		sysLogMapper.insert(sysLog);		
		model.addObject("homeTurnInfo", homeTurnImg);
		model.addObject("branchCompany", branchCompany);
		model.setViewName("/admin/syhdlbmSave");
		return model;
	}
	
	
	@RequestMapping("searchListSyhdlbm")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void msearchListCases(@RequestParam("page") int page,@RequestParam("rows") int rows,String BCompany, String keyWord,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
		HomeTurnImgExample cx = new HomeTurnImgExample();
		if (StringUtils.isNotBlank(keyWord) && !BCompany.equals("===请选择===")) {
			keyWord = "%" + keyWord + "%";
			//and or联合查询
			cx.or().andHomeimgNameLike(keyWord).andStateEqualTo(2).andBranchCompanyEqualTo(BCompany);
		}else if(StringUtils.isNotBlank(keyWord) && BCompany.equals("===请选择===")){
			keyWord = "%" + keyWord + "%";
			cx.or().andHomeimgNameLike(keyWord).andStateEqualTo(2).andBranchCompanyEqualTo(branchCompany);
		}else if(StringUtils.isBlank(keyWord) && !BCompany.equals("===请选择===")){
			cx.or().andStateEqualTo(2).andBranchCompanyEqualTo(BCompany);
		}else{
			String roleName = currentRole.getRoleName();
			if(!"超级管理员".equals(roleName)){
				Criteria criteria = cx.createCriteria();
				criteria.andStateNotEqualTo(2);
				criteria.andBranchCompanyEqualTo(currentRole.getBranchCompany());
			}else{
				Criteria criteria = cx.createCriteria();
				criteria.andStateEqualTo(2);
			}
		}
		int totalNums = homeTurnImgMapper.countByExample(cx);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		cx.setPage(p);
		cx.setOrderByClause("update_time desc");//排序
		List<HomeTurnImg> homeTurnListPage = homeTurnImgMapper.selectByExample(cx);
		// 日志记录
		SysLog sysLog = new SysLog();
		SysLogUtil.search(session, 0,TableName.homeTurnImg,"装修案例列表信息");
		sysLogMapper.insert(sysLog);
		JsonPrintUtil.printGridData(response, homeTurnListPage, totalNums,"rows","total");
	}

	/**
	 * 手机轮播图保存
	 * 
	 * @author Jhone
	 */
	@RequestMapping("saveSyhdlbm")
	@ResponseBody
	public void msaveCase(
			HomeTurnImg homeTurnImg,HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		
		int num = 0;
		User currentLoginUser = (User)request.getSession().getAttribute("UserInfo");
		if(null == homeTurnImg.getHomeimgId()){
			
			homeTurnImg.setCreateTime(new Date());
			homeTurnImg.setCreater(currentLoginUser.getUserName());
			homeTurnImg.setUpdateTime(new Date());
			homeTurnImg.setState(2);
			num = homeTurnImgMapper.insert(homeTurnImg);	
			
//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.add(session, homeTurnImg.getHomeimgId(), TableName.homeTurnImg, "首页轮播图信息");
			sysLogMapper.insert(sysLog);
		
		}else{
			homeTurnImg.setUpdateTime(new Date());
			homeTurnImg.setUpdater(currentLoginUser.getUserName());
			num = homeTurnImgMapper.updateByPrimaryKeySelective(homeTurnImg);//只更新传值的字段
//			日志记录编辑案例的日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.edit(session, homeTurnImg.getHomeimgId(), TableName.repair, "首页轮播图信息");
			sysLogMapper.insert(sysLog);		
		}
		if(num>0){	
			JsonPrintUtil.printObjData(response, "ok");
		}
	}
	/**
	 * 
	 * 手机首页活动轮播删除
	 */
	@RequestMapping("delSyhdlbm")
	@ResponseBody
	public void mdelCase(String homeImgIds,HttpSession session,HttpServletResponse response) {
		User currentLoginUser = (User)session.getAttribute("UserInfo");
		if(!StringUtils.isBlank(homeImgIds)){
			String[] homeImgIdsArr = homeImgIds.split(",");
			for(int i=0;i<homeImgIdsArr.length;i++){
				int rId = Integer.parseInt(homeImgIdsArr[i]);
				HomeTurnImg homeTurnImg = homeTurnImgMapper.selectByPrimaryKey(rId);
				homeTurnImg.setState(1);
				homeTurnImg.setUpdateTime(new Date());
				homeTurnImg.setUpdater(currentLoginUser.getUserName());
				homeTurnImgMapper.updateByPrimaryKeySelective(homeTurnImg);
				
				// 日志记录
				SysLog sysLog = new SysLog();
				sysLog =SysLogUtil.delete(session, homeTurnImg.getHomeimgId(), TableName.homeTurnImg, "首页轮播图信息");
				sysLogMapper.insert(sysLog);
				
			}
			JsonPrintUtil.printObjData(response, "ok");
		}else{
			JsonPrintUtil.printObjData(response, "fail");
		}
	}
	
	@RequestMapping("saveSyhdlb")
	@ResponseBody
	public void saveCase(
			HomeTurnImg homeTurnImg,HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		
		int num = 0;
		User currentLoginUser = (User)request.getSession().getAttribute("UserInfo");
		if(null == homeTurnImg.getHomeimgId()){
			
			homeTurnImg.setCreateTime(new Date());
			homeTurnImg.setCreater(currentLoginUser.getUserName());
			homeTurnImg.setUpdateTime(new Date());
			homeTurnImg.setState(0);
			num = homeTurnImgMapper.insert(homeTurnImg);	
			
//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.add(session, homeTurnImg.getHomeimgId(), TableName.homeTurnImg, "首页轮播图信息");
			sysLogMapper.insert(sysLog);
		
		}else{
			homeTurnImg.setUpdateTime(new Date());
			homeTurnImg.setUpdater(currentLoginUser.getUserName());
			num = homeTurnImgMapper.updateByPrimaryKeySelective(homeTurnImg);//只更新传值的字段
//			日志记录编辑案例的日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.edit(session, homeTurnImg.getHomeimgId(), TableName.repair, "首页轮播图信息");
			sysLogMapper.insert(sysLog);		
		}
		if(num>0){	
			JsonPrintUtil.printObjData(response, "ok");
		}
	}
	
	@RequestMapping("delSyhdlb")
	@ResponseBody
	public void delCase(String homeImgIds,HttpSession session,HttpServletResponse response) {
		User currentLoginUser = (User)session.getAttribute("UserInfo");
		if(!StringUtils.isBlank(homeImgIds)){
			String[] homeImgIdsArr = homeImgIds.split(",");
			for(int i=0;i<homeImgIdsArr.length;i++){
				int rId = Integer.parseInt(homeImgIdsArr[i]);
				HomeTurnImg homeTurnImg = homeTurnImgMapper.selectByPrimaryKey(rId);
				homeTurnImg.setState(1);
				homeTurnImg.setUpdateTime(new Date());
				homeTurnImg.setUpdater(currentLoginUser.getUserName());
				homeTurnImgMapper.updateByPrimaryKeySelective(homeTurnImg);
				
				// 日志记录
				SysLog sysLog = new SysLog();
				sysLog =SysLogUtil.delete(session, homeTurnImg.getHomeimgId(), TableName.homeTurnImg, "首页轮播图信息");
				sysLogMapper.insert(sysLog);
				
			}
			JsonPrintUtil.printObjData(response, "ok");
		}else{
			JsonPrintUtil.printObjData(response, "fail");
		}
	}
	@RequestMapping("delSyhdlbImage")
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
	@RequestMapping("/SyhdlbFileUpload")  
	@ResponseBody
	public void caseThumbImgFileUpload(
			HttpServletRequest request,HttpServletResponse response,MultipartFile file,HttpSession session) {  
		String homeImgIdStr = request.getParameter("homeImgId");
		int homeImgId = 0;
		if(StringUtils.isNotBlank(homeImgIdStr) && StringUtils.isNumeric(homeImgIdStr)){			
			homeImgId = Integer.parseInt(homeImgIdStr);
		}
		String url = "";
		try {
			HomeTurnImg homeTurnObj = homeTurnImgMapper.selectByPrimaryKey(homeImgId);		
			url = "/images/"+super.uploadToFileUrl(file , request,session);
			homeTurnObj.setHomeimgSrc(url);
			// logger.info("文件上传成功... 服务器保存路径为："+url);
			homeTurnImgMapper.updateByPrimaryKey(homeTurnObj);
//			日志记录图片上传的日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.upload(session, homeTurnObj.getHomeimgId(), TableName.homeTurnImg, "首页轮播图");
			sysLogMapper.insert(sysLog);
			
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		logger.info("文件上传成功... 服务器保存路径为："+url);
		JsonPrintUtil.printObjData(response, url);
	}
	
}
