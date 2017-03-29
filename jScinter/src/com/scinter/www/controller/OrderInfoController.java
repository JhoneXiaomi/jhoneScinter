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

import com.scinter.www.dao.OrderInfoMapper;
import com.scinter.www.dao.SysLogMapper;
import com.scinter.www.model.OrderInfo;
import com.scinter.www.model.OrderInfoExample;
import com.scinter.www.model.Role;
import com.scinter.www.model.OrderInfoExample.Criteria;
import com.scinter.www.model.SysLog;
import com.scinter.www.util.JsonPrintUtil;
import com.scinter.www.util.Page;
import com.scinter.www.util.SysLogUtil;
import com.scinter.www.util.TableName;

@Controller
@RequestMapping("admin")
public class OrderInfoController extends BaseController {

	private Logger logger = Logger.getLogger(OrderInfoController.class);
	
	@Autowired
	private OrderInfoMapper orderMapper;
	@Autowired
	private SysLogMapper sysLogMapper;
	
	@RequestMapping("listOrderInfoToJson")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void listOrderInfoToJson(@RequestParam("page") int page,@RequestParam("rows") int rows,HttpServletRequest request,HttpSession session, HttpServletResponse response) {
		
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
		OrderInfoExample rx = new OrderInfoExample();
		Criteria criteria = rx.createCriteria();
		criteria.andStatusNotEqualTo(3);//非删除状态
		Role currentRole= (Role)session.getAttribute("Role");
		String roleName = currentRole.getRoleName();
		if(!"超级管理员".equals(roleName)){
			String branchCompany = currentRole.getBranchCompany();
			request.setAttribute("BCompany", branchCompany);
			criteria.andBranchCompanyEqualTo(branchCompany);//当前用户所属分公司
		}else{
			
			criteria.andBranchCompanyLike("%"+spilCompany+"%");
		}
		int totalNums = orderMapper.countByExample(rx);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		rx.setPage(p);
		rx.setOrderByClause("create_time desc");//排序
		List<OrderInfo> orderList4Page = orderMapper.selectByExample(rx);
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0, TableName.order_info, "在线订单列表信息");
		sysLogMapper.insert(sysLog);
		JsonPrintUtil.printGridData(response, orderList4Page, totalNums,"rows","total");
	}
	
	@RequestMapping("searchListOrderInfo")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void searchListOrderInfo(@RequestParam("page") int page,@RequestParam("rows") int rows,String BCompany,String keyWord,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		OrderInfoExample ux = new OrderInfoExample();
		OrderInfoExample.Criteria criteria = ux.createCriteria();
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
		
		// 默认所有
		if (StringUtils.isBlank(keyWord) && BCompany.equals("===请选择===")) {
			String roleName = currentRole.getRoleName();
			if(!"超级管理员".equals(roleName)){
				criteria.andStatusNotEqualTo(3);// 非删除状态
				criteria.andBranchCompanyEqualTo(branchCompany);//当前用户所属分公司
			}else{
			
				criteria.andStatusNotEqualTo(3);// 非删除状态
			}
		}
		if (StringUtils.isNotBlank(keyWord) && BCompany.equals("===请选择===")) {
			keyWord = "%" + keyWord + "%";
			// 分页条件查询
			// and or联合查询
			ux.or().andPhoneLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(branchCompany);
			ux.or().andClientNameLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(branchCompany);
			ux.or().andAddressLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(branchCompany);
			ux.or().andNoteLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(branchCompany);
		}
		if (StringUtils.isBlank(keyWord) && !BCompany.equals("===请选择===")) {
			criteria.andStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
		}
		if (StringUtils.isNotBlank(keyWord) && !BCompany.equals("===请选择===")) {
			keyWord = "%" + keyWord + "%";
			ux.or().andPhoneLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
			ux.or().andClientNameLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
			ux.or().andAddressLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
			ux.or().andNoteLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
		}
		int totalNums = orderMapper.countByExample(ux);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		ux.setPage(p);
		ux.setOrderByClause("create_time desc");//排序
		List<OrderInfo> orderList4Page = orderMapper.selectByExample(ux);
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session,0, TableName.order_info, "在线订单列表信息");
		sysLogMapper.insert(sysLog);				

		JsonPrintUtil.printGridData(response, orderList4Page, totalNums,"rows","total");
	}
	
	@RequestMapping("showOrderInfo")
	public ModelAndView showOrderInfo(int orderId,HttpSession session){
		ModelAndView model = new ModelAndView();
		OrderInfo order = orderMapper.selectByPrimaryKey(orderId);
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, order.getId(), TableName.order_info, "在线订单信息");
		sysLogMapper.insert(sysLog);
		
		model.addObject("orderInfo", order);
		model.setViewName("/admin/orderSave");
		return model;
	}
	
	@RequestMapping("saveOrderInfo")
	@ResponseBody
	public void saveOrderInfo(OrderInfo order,HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		int num = 0;
		if(null==order.getId()){
			order.setCreateTime(new Date());
			order.setStatus(1);
			num = orderMapper.insert(order);
			
//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.add(session, order.getId(), TableName.order_info, "在线订单信息");
			sysLogMapper.insert(sysLog);
			
		}else{
			num = orderMapper.updateByPrimaryKeySelective(order);//只更新传值的字段
			
//			日志记录在线订单的编辑信息
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.edit(session, order.getId(), TableName.order_info, "在线订单信息");
			sysLogMapper.insert(sysLog);
		}
		if(num>0){
			logger.info("saveOrderInfo success!");
			JsonPrintUtil.printObjData(response, "ok");
		}
	}
	
	@RequestMapping("delOrderInfo")
	@ResponseBody
	public void delOrderInfo(String orderIds,HttpSession session,HttpServletResponse response) {
		if(!StringUtils.isBlank(orderIds)){
			String[] orderIdsArr = orderIds.split(",");
			for(int i=0;i<orderIdsArr.length;i++){
				int uId = Integer.parseInt(orderIdsArr[i]);
				OrderInfo u = orderMapper.selectByPrimaryKey(uId);
				u.setStatus(3);//1正常  3已删除 
				orderMapper.updateByPrimaryKeySelective(u);
				
//				日志记录在线订单的删除信息
				SysLog sysLog = new SysLog();
				sysLog =SysLogUtil.delete(session, u.getId(), TableName.order_info, "在线订单信息");
				sysLogMapper.insert(sysLog);
			}
			JsonPrintUtil.printObjData(response, "ok");
		}else{
			JsonPrintUtil.printObjData(response, "fail");
		}
	}
}
