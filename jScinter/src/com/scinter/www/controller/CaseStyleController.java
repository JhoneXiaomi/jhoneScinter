package com.scinter.www.controller;
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

import com.scinter.www.dao.CaseShowImageMapper;
import com.scinter.www.dao.CasesMapper;
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
public class CaseStyleController extends BaseController {

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
	
	@RequestMapping("listCaseStyleToJson")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void listCaseStyleToJson(@RequestParam("page") int page,@RequestParam("rows") int rows,HttpServletRequest request,HttpSession session ,HttpServletResponse response) {
		
		
		//分页条件查询
		CasesExample rx = new CasesExample();
		com.scinter.www.model.CasesExample.Criteria criteria = rx.createCriteria();
		criteria.andCaseStatusEqualTo(5);
		Role currentRole= (Role)session.getAttribute("Role");
		String roleName = currentRole.getRoleName();
		String branchCompany = "";
		if(!"超级管理员".equals(roleName)){
			branchCompany = currentRole.getBranchCompany();
			request.setAttribute("BCompany", branchCompany);
			criteria.andBranchCompanyEqualTo(branchCompany);//当前用户所属分公司
		}else{
			branchCompany = "bjsc";
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
	
	@RequestMapping("searchListCasesStyle")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void searchListCasesStyle(@RequestParam("page") int page,@RequestParam("rows") int rows,String BCompany, String keyWord,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
		
		CasesExample cx = new CasesExample();
		if (StringUtils.isNotBlank(keyWord) && !BCompany.equals("===请选择===")) {
			keyWord = "%" + keyWord + "%";
			//and or联合查询
			cx.or().andCaseTitleLike(keyWord).andCaseStatusEqualTo(5).andBranchCompanyEqualTo(BCompany);
			cx.or().andCaseCommunityLike(keyWord).andCaseStatusEqualTo(5).andBranchCompanyEqualTo(BCompany);
			cx.or().andCaseDesignerLike(keyWord).andCaseStatusEqualTo(5).andBranchCompanyEqualTo(BCompany);
			cx.or().andCaseDescLike(keyWord).andCaseStatusEqualTo(5).andBranchCompanyEqualTo(BCompany);
		}else if(StringUtils.isNotBlank(keyWord) && BCompany.equals("===请选择===")){
			keyWord = "%" + keyWord + "%";
			cx.or().andCaseTitleLike(keyWord).andCaseStatusEqualTo(5).andBranchCompanyEqualTo(branchCompany);
			cx.or().andCaseCommunityLike(keyWord).andCaseStatusEqualTo(5).andBranchCompanyEqualTo(branchCompany);
			cx.or().andCaseDesignerLike(keyWord).andCaseStatusNotEqualTo(5).andBranchCompanyEqualTo(branchCompany);
			cx.or().andCaseDescLike(keyWord).andCaseStatusEqualTo(5).andBranchCompanyEqualTo(branchCompany);
		}else if(StringUtils.isBlank(keyWord) && !BCompany.equals("===请选择===")){
			
			cx.or().andCaseStatusEqualTo(5).andBranchCompanyEqualTo(BCompany);
			cx.or().andCaseStatusEqualTo(5).andBranchCompanyEqualTo(BCompany);
			cx.or().andCaseStatusEqualTo(5).andBranchCompanyEqualTo(BCompany);
			cx.or().andCaseStatusEqualTo(5).andBranchCompanyEqualTo(BCompany);
		}else{
			String roleName = currentRole.getRoleName();
			if(!"超级管理员".equals(roleName)){
				CasesExample.Criteria criteria = cx.createCriteria();
				criteria.andCaseStatusEqualTo(5);
				criteria.andBranchCompanyEqualTo(currentRole.getBranchCompany());//当前用户所属分公司
			}else{
				CasesExample.Criteria criteria = cx.createCriteria();
				criteria.andCaseStatusEqualTo(5);
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

	
	@RequestMapping("showCaseStyle")
	public ModelAndView showCaseStyle(@RequestParam("caseId") int caseId, HttpSession session){
		
		
		ModelAndView model = new ModelAndView();
		Cases case1 = caseMapper.selectByPrimaryKey(caseId);
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
//		日志记录
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
		model.setViewName("/admin/caseStyleSave");
		return model;
	}
	
	@RequestMapping("saveCaseStyle")
	@ResponseBody
	public void saveCaseStyle(Cases case1,HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		
	   /*保存案例列表页的SEO信息*/
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();  
		String branchStr = branchCompany.substring(branchCompany.length()-2,branchCompany.length());
	    logger.info("获取到的分公司的信息为："+branchStr);
		int num = 0;
		User currentLoginUser = (User)request.getSession().getAttribute("UserInfo");
		if(null==case1.getCaseId()){
			case1.setCreateTime(new Date());
			case1.setCreater(currentLoginUser.getUserName());
			case1.setUpdateTime(new Date());
			case1.setCaseStatus(5);
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
	
	@RequestMapping("delCaseStyle")
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
	
	@RequestMapping("delCaseStyleImage")
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
	
}
