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
import org.springframework.web.servlet.ModelAndView;

import com.scinter.www.dao.RepairMapper;
import com.scinter.www.dao.SysLogMapper;
import com.scinter.www.model.HotBuildingExample;
import com.scinter.www.model.Repair;
import com.scinter.www.model.RepairExample;
import com.scinter.www.model.Role;
import com.scinter.www.model.RepairExample.Criteria;
import com.scinter.www.model.SysLog;
import com.scinter.www.util.JsonPrintUtil;
import com.scinter.www.util.Page;
import com.scinter.www.util.SysLogUtil;
import com.scinter.www.util.TableName;

@Controller
@RequestMapping("admin")
public class RepairController extends BaseController {

	private Logger logger = Logger.getLogger(RepairController.class);
	
	@Autowired
	private RepairMapper repairMapper;
	@Autowired
	private SysLogMapper sysLogMapper;
	
	/**
	 * 
	 * @param page 
	 * @param rows
	 * @param response
	 */
	@RequestMapping("listRepairToJson")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void listRepairToJson(@RequestParam("page") int page,@RequestParam("rows") int rows,HttpSession session,HttpServletResponse response) {
		
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
		RepairExample repairExample = new RepairExample();
		Criteria criteria = repairExample.createCriteria();
		//非删除状态
		criteria.andStatusNotEqualTo(3);
		Role currentRole= (Role)session.getAttribute("Role");
		String roleName = currentRole.getRoleName();
		if(!"超级管理员".equals(roleName)){
			String branchCompany = currentRole.getBranchCompany();
			criteria.andBranchCompanyEqualTo(branchCompany);//当前用户所属分公司
		}else{
			
			criteria.andBranchCompanyLike("%"+spilCompany+"%");
		}
		
		int totalNums = repairMapper.countByExample(repairExample);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		repairExample.setPage(p);
		repairExample.setOrderByClause("create_time desc");//排序
		List<Repair> caseList4Page = repairMapper.selectByExample(repairExample);
		JsonPrintUtil.printGridData(response, caseList4Page, totalNums,"rows","total");
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0, TableName.repair, "在线报修列表信息");
		sysLogMapper.insert(sysLog);
	}
	
	/**
	 * 
	 * @param repair    Repair实体类,封装了在线报属性修的全部信息
	 * @param response  用于动态响应客户端请示
	 * @param request   接受客户端所发出的请求
	 */
	@RequestMapping("saveRepair")
	@ResponseBody
	public void saveRepair(Repair repair,HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		//logger.info("行政区域:"+repair.getAddress()+"维修类别:"+repair.getRepairType()+"sex:"+repair.getSex()+"repairType:"+repair.getRepairType());
		int num = 0;
		if(null == repair.getId()){
			
			
			repair.setCreateTime(new Date());
			repair.setStatus(1);
			num = repairMapper.insert(repair);
			
//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.add(session, repair.getId(), TableName.repair, "在线报修信息");
			sysLogMapper.insert(sysLog);
		}else{
			num = repairMapper.updateByPrimaryKeySelective(repair);//只更新传值的字段
			
//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.edit(session, repair.getId(), TableName.repair, "在线报修信息");
			sysLogMapper.insert(sysLog);		
			
		}
		if(num>0){
			logger.info("saveRepair success!");
			JsonPrintUtil.printObjData(response, "ok");
		}
	}
	
	/**
	 * 在线保修单的编辑功能
	 * @param repairId
	 * @return
	 */
	@RequestMapping("showRepair")
	public ModelAndView showRepair(int repairId,HttpSession session){
		
		ModelAndView model = new ModelAndView();
		Repair repair = repairMapper.selectByPrimaryKey(repairId);
	
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, repairId, TableName.repair, "在线报修信息");
		sysLogMapper.insert(sysLog);
		
		model.addObject("repairInfo", repair);
		model.setViewName("/admin/repairSave");
		return model;
	}
	
	/**
	 * 查看在线报修单的信息
	 * @param page        页码
	 * @param rows        行号
	 * @param keyWord     查询条件
	 * @param request     接受客户端所发出的请求
	 * @param response    用于动态响应客户端请示
	 */
	@RequestMapping("searchListRepair")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void searchListRepair(@RequestParam("page") int page,@RequestParam("rows") int rows,String BCompany,String keyWord,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		RepairExample repairExample = new RepairExample();
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
		
		if (StringUtils.isNotBlank(keyWord) && !BCompany.equals("===请选择===")) {
			keyWord = "%" + keyWord + "%";
			//and or联合查询
			repairExample.or().andClientNameLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
			repairExample.or().andRepairIdLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
			repairExample.or().andPhoneLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
			repairExample.or().andBuildNameLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
			repairExample.or().andAddressLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
		}else if(StringUtils.isNotBlank(keyWord) && BCompany.equals("===请选择===")) {
			keyWord = "%" + keyWord + "%";
			//and or联合查询
			repairExample.or().andClientNameLike(keyWord).andStatusNotEqualTo(3);
			repairExample.or().andRepairIdLike(keyWord).andStatusNotEqualTo(3);
			repairExample.or().andPhoneLike(keyWord).andStatusNotEqualTo(3);
			repairExample.or().andBuildNameLike(keyWord).andStatusNotEqualTo(3);
			repairExample.or().andAddressLike(keyWord).andStatusNotEqualTo(3);
		}else if(StringUtils.isBlank(keyWord) && !BCompany.equals("===请选择===")) {
			
			RepairExample.Criteria criteria = repairExample.createCriteria();
			criteria.andStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
		
		}else{
			String roleName = currentRole.getRoleName();
			if(!"超级管理员".equals(roleName)){
				RepairExample.Criteria criteria = repairExample.createCriteria();
				criteria.andStatusNotEqualTo(3);//非删除状态
				criteria.andBranchCompanyEqualTo(currentRole.getBranchCompany());//当前用户所属分公司
			}else{
				RepairExample.Criteria criteria = repairExample.createCriteria();
				criteria.andStatusNotEqualTo(3);//非删除状态
			}
		}
		int totalNums = repairMapper.countByExample(repairExample);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		repairExample.setPage(p);
		//排序
		repairExample.setOrderByClause("create_time desc");
		List<Repair> orderList4Page = repairMapper.selectByExample(repairExample);
		

			
//		日志记录在线报修的查询
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0, TableName.repair, "在线报修列表信息");
		sysLogMapper.insert(sysLog);
		JsonPrintUtil.printGridData(response, orderList4Page, totalNums,"rows","total");
	}
	
	
	
	/**
	 * 删除在线报修单
	 * @param repairIds	  repairId的数组,接收用于批量删除数据
	 * @param session     存储用户会话所需要的的属性和配置的全部信息
	 * @param request     接受客户端所发出的请求
	 */
	@RequestMapping("delRepair")
	@ResponseBody
	public void delRepair(String repairIds,HttpSession session,HttpServletResponse response) {
		if(!StringUtils.isBlank(repairIds)){
			String[] orderIdsArr = repairIds.split(",");
			for(int i=0;i<orderIdsArr.length;i++){
				int uId = Integer.parseInt(orderIdsArr[i]);
				Repair  repair= repairMapper.selectByPrimaryKey(uId);
				
				//1正常  3repair已删除 
				repair.setStatus(3);
				repairMapper.updateByPrimaryKeySelective(repair);
				
//				日志记录
				SysLog sysLog = new SysLog();
				sysLog =SysLogUtil.delete(session, uId, TableName.repair, "在线报修信息");
				sysLogMapper.insert(sysLog);
			}
			

			JsonPrintUtil.printObjData(response, "ok");
		}else{
			JsonPrintUtil.printObjData(response, "fail");
		}
	}
	
	

	
}
