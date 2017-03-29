package com.scinter.www.controller;

import java.io.PrintWriter;
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

import com.scinter.www.dao.FaqMapper;
import com.scinter.www.dao.SysLogMapper;
import com.scinter.www.model.CaseShowImage;
import com.scinter.www.model.Cases;
import com.scinter.www.model.Faq;
import com.scinter.www.model.FaqExample;
import com.scinter.www.model.Role;
import com.scinter.www.model.FaqExample.Criteria;
import com.scinter.www.model.SysLog;
import com.scinter.www.model.User;
import com.scinter.www.util.JsonPrintUtil;
import com.scinter.www.util.Page;
import com.scinter.www.util.SysLogUtil;
import com.scinter.www.util.TableName;

@Controller
@RequestMapping("admin")
public class FaqController extends BaseController {

	private Logger logger = Logger.getLogger(FaqController.class);

	@Autowired
	private FaqMapper faqMapper;
	@Autowired
	private SysLogMapper sysLogMapper;
	/**
	 * 创建装修问答列表
	 * @param page
	 * @param rows
	 * @param response
	 */
	@RequestMapping("listFaqToJson")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void listFaqToJson(@RequestParam("page") int page,@RequestParam("rows") int rows,HttpSession session ,HttpServletResponse response) {
		
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
		FaqExample faqExample = new FaqExample();
		Criteria criteria = faqExample.createCriteria();
		criteria.andFaqStatusEqualTo(1);
		Role currentRole= (Role)session.getAttribute("Role");
		String roleName = currentRole.getRoleName();
		if(!"超级管理员".equals(roleName)){
			String branchCompany = currentRole.getBranchCompany();
			criteria.andBranchCompanyEqualTo(branchCompany);//当前用户所属分公司
		}else{
			
			criteria.andBranchCompanyLike("%"+spilCompany+"%");
		}
		
		int totalNums = faqMapper.countByExample(faqExample);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		faqExample.setPage(p);
		//排序
		faqExample.setOrderByClause("update_time desc");
		List<Faq> faqList4Page = faqMapper.selectByExample(faqExample);
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0 , TableName.faq, "装修问答列表信息");
		sysLogMapper.insert(sysLog);
		
		JsonPrintUtil.printGridData(response, faqList4Page, totalNums,"rows","total");
	}
	
	/**
	 * 装修问答信息显示
	 * @param faqId              装修问答的ID 值用于获取点击的行值得信息
	 * @return
	 */
	@RequestMapping("showFaq")
	public ModelAndView showFaq(@RequestParam("faqId") int faqId,HttpSession session){
		
		ModelAndView model = new ModelAndView();
		Faq faq = faqMapper.selectByPrimaryKey(faqId);
		
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, faq.getFaqId(), TableName.faq, "装修问答信息");
		sysLogMapper.insert(sysLog);
		
		model.addObject("faqInfo", faq);
		model.setViewName("/admin/faqSave");
		return model;
	}
	
	/**
	 * 编写保存，新建，编辑的方法
	 * @param faq				faq model 类接受客户端传来的类
	 * @param response			用于动态响应客户端请示，这里主要是返回响应的结果
	 * @param request			接受客户端所发出的请求，
	 */
	@RequestMapping("saveFaq")
	@ResponseBody
	public void saveFaq(Faq faq,HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		int num = 0;
		
		if(null==faq.getFaqId()){
			
			User creater = (User) session.getAttribute("UserInfo");
			faq.setFaqStatus(1);
			faq.setCreateTime(new Date());
			faq.setCreater(creater.getNickName());
			num = faqMapper.insert(faq);
			
//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.add(session, faq.getFaqId(), TableName.faq, "装修问答信息");
			sysLogMapper.insert(sysLog);
		}else{
			
			User Updater = (User) session.getAttribute("UserInfo");
			faq.setFaqStatus(1);
			faq.setUpdateTime(new Date());
			faq.setUpdater(Updater.getNickName());
			num = faqMapper.updateByPrimaryKeySelective(faq);//只更新传值的字段
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.edit(session, faq.getFaqId(), TableName.faq, "装修问答信息");
			sysLogMapper.insert(sysLog);
		}
		
		if(num>0){
			JsonPrintUtil.printObjData(response, "ok");
		}
	}
	
	/**
	 * 编写装修问答删除方法
	 * @param faqIds	  faqIds的数组,接收用于批量删除数据
	 * @param session     存储用户会话所需要的的属性和配置的全部信息
	 * @param request     接受客户端所发出的请求
	 */
	@RequestMapping("delFaq")
	@ResponseBody
	public void delFaq(String faqIds,HttpSession session,HttpServletResponse response) {
		if(!StringUtils.isBlank(faqIds)){
			
			String[] faqdsArr = faqIds.split(",");
			for(int i=0;i<faqdsArr.length;i++){
				int fId = Integer.parseInt(faqdsArr[i]);
				Faq  faq= faqMapper.selectByPrimaryKey(fId);
				
				faq.setFaqStatus(3);
				faqMapper.updateByPrimaryKeySelective(faq);
				
//				日志记录
				SysLog sysLog = new SysLog();
				sysLog =SysLogUtil.delete(session, faq.getFaqId(), TableName.faq, "装修问答信息");
				sysLogMapper.insert(sysLog);
			}
			JsonPrintUtil.printObjData(response, "ok");
		}else{
			JsonPrintUtil.printObjData(response, "fail");
		}
	}
	
	/**
	 * 用于查询装修问答的所有的信息
	 * @param page        页码
	 * @param rows        页容量
	 * @param keyWord     查询条件
	 * @param request     接受客户端所发出的请求
	 * @param response    用于动态响应客户端请示
	 */
	@RequestMapping("searchListFaq")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void searchListFaq(@RequestParam("page") int page,@RequestParam("rows") int rows,String BCompany,String keyWord,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
		
		
		FaqExample faqExample = new FaqExample();
		if (StringUtils.isNotBlank(keyWord) && !BCompany.equals("===请选择===")) {
			keyWord = "%" + keyWord + "%";
			//and or联合查询
			faqExample.or().andFaqDescLike(keyWord).andFaqStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
			faqExample.or().andFaqAnswerLike(keyWord).andFaqStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
		}else if(StringUtils.isNotBlank(keyWord) && BCompany.equals("===请选择===")) {
			keyWord = "%" + keyWord + "%";
			//and or联合查询
			faqExample.or().andFaqDescLike(keyWord).andFaqStatusNotEqualTo(3);
			faqExample.or().andFaqAnswerLike(keyWord).andFaqStatusNotEqualTo(3);
		}else if(StringUtils.isBlank(keyWord) && !BCompany.equals("===请选择===")) {
			keyWord = "%" + keyWord + "%";
			Criteria criteria= faqExample.createCriteria();
			criteria.andFaqStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
		}else{
			String roleName = currentRole.getRoleName();
			if(!"超级管理员".equals(roleName)){
				FaqExample.Criteria criteria = faqExample.createCriteria();
				criteria.andFaqStatusNotEqualTo(3);//非删除状态
				criteria.andBranchCompanyEqualTo(currentRole.getBranchCompany());//当前用户所属分公司
			}else{
				FaqExample.Criteria criteria = faqExample.createCriteria();
				criteria.andFaqStatusNotEqualTo(3);//非删除状态
			}
			
		}
		int totalNums = faqMapper.countByExample(faqExample);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		faqExample.setPage(p);
		//排序
		faqExample.setOrderByClause("create_time desc");
		List<Faq> orderList4Page = faqMapper.selectByExample(faqExample);

		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session,0, TableName.faq, "装修问答信息");
		sysLogMapper.insert(sysLog);
	
		JsonPrintUtil.printGridData(response, orderList4Page, totalNums,"rows","total");
	}
	
	@RequestMapping("faqThumbImgFileUpload")
	@ResponseBody
	public void faqThumbImgFileUpload(HttpServletRequest request,HttpSession session,HttpServletResponse response,MultipartFile file) {  
		
		
		User user = (User)request.getSession().getAttribute("UserInfo");
		String faqIdStr = request.getParameter("faqId");
		int faqId = 0;
		if(StringUtils.isNotBlank(faqIdStr) && StringUtils.isNumeric(faqIdStr))			
			faqId = Integer.parseInt(faqIdStr);
		
		String url = "";
		try {
			Faq faqObj = faqMapper.selectByPrimaryKey(faqId);		
			url = "/images/"+super.uploadToFileUrl(file , request,session);
			faqObj.setFaqImage(url);
			faqMapper.updateByPrimaryKey(faqObj);
			logger.info("文件上传成功... 服务器保存路径为："+url);
			
//			日志记录图片上传的日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.upload(session, faqObj.getFaqId(), TableName.cases, "装修知识缩略图");
			sysLogMapper.insert(sysLog);
			
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		JsonPrintUtil.printObjData(response, url);	
	}
	
	
}
