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

import com.scinter.www.dao.HotBuildingMapper;
import com.scinter.www.dao.HouseTypeReviewMapper;
import com.scinter.www.dao.SysLogMapper;
import com.scinter.www.model.HotBuilding;
import com.scinter.www.model.HouseTypeReview;
import com.scinter.www.model.HouseTypeReviewExample;
import com.scinter.www.model.HouseTypeReviewExample.Criteria;
import com.scinter.www.model.SysLog;
import com.scinter.www.model.User;
import com.scinter.www.util.JsonPrintUtil;
import com.scinter.www.util.Page;
import com.scinter.www.util.SysLogUtil;
import com.scinter.www.util.TableName;

@Controller
@RequestMapping("admin")
public class HouseTypeReviewController extends BaseController {

	private Logger logger = Logger.getLogger(HouseTypeReviewController.class);
	
	@Autowired
	private HouseTypeReviewMapper houseTypeReviewMapper;
	
	@Autowired
	private HotBuildingMapper hotBuildingMapper;
	
	@Autowired
	private SysLogMapper sysLogMapper;
	
	/**
	 * 户型点评的列表展示
	 * @param page            页码
	 * @param rows			   页容量
	 * @param response		   返回响应的结果信息
	 */
	@RequestMapping("listHouseTypeReviewToJson")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void listHouseTypeReviewToJson(@RequestParam("page") int page,@RequestParam("rows") int rows,HttpSession session,HttpServletResponse response) {
		
		//分页条件查询
		HouseTypeReviewExample houseTypeReviewExample = new HouseTypeReviewExample();
		com.scinter.www.model.HouseTypeReviewExample.Criteria criteria = houseTypeReviewExample.createCriteria();
		//非删除状态
		criteria.andStatusNotEqualTo(3);
		
		int totalNums = houseTypeReviewMapper.countByExample(houseTypeReviewExample);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		houseTypeReviewExample.setPage(p);
		houseTypeReviewExample.setOrderByClause("create_time desc");//排序
		List<HouseTypeReview> caseList4Page = houseTypeReviewMapper.selectByExample(houseTypeReviewExample);
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session,0, TableName.house_type_review, "户型点评列表信息");
		sysLogMapper.insert(sysLog);
		
		JsonPrintUtil.printGridData(response, caseList4Page, totalNums,"rows","total");
	}

	/**
	 * 新建，编辑的方法编写
	 * @param houseTypeId			户型点评信息的ID 号
	 * @return
	 */
	@RequestMapping("showHouseTypeReview")
	public ModelAndView showHouseTypeReview(@RequestParam("houseTypeId") int houseTypeId,HttpSession session){
		
		ModelAndView model = new ModelAndView();

		
		HouseTypeReview houseTypeReview = houseTypeReviewMapper.selectByPrimaryKey(houseTypeId);
		
//		查询相关点评户型下的所属楼盘信息，从而获取该点评户型下关联的楼盘名称
		HotBuilding  hotBuilding = hotBuildingMapper.selectByPrimaryKey(houseTypeReview.getBulidingId());
		String buildingName = hotBuilding.getBulidingName();
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, houseTypeReview.getId(), TableName.house_type_review, "户型点评信息");
		sysLogMapper.insert(sysLog);
		
		model.addObject("buildingName",buildingName);
		model.addObject("houseTypeReviewInfo", houseTypeReview);
		model.setViewName("/admin/houseTypeReviewSave");
		return model;
	}
	
	
	/**
	 * 实现户型点评的信息保存
	 * @param houseTypeReview    houseTypeReview实体类,封装了在线报属性修的全部信息
	 * @param response  用于动态响应客户端请示
	 * @param request   接受客户端所发出的请求
	 */
	@RequestMapping("saveHouseTypeReview")
	@ResponseBody
	public void saveHouseTypeReview(HouseTypeReview houseTypeReview,HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		//logger.info("行政区域:"+repair.getAddress()+"维修类别:"+repair.getRepairType()+"sex:"+repair.getSex()+"repairType:"+repair.getRepairType());
		int num = 0;
		if(null==houseTypeReview.getId()){
			
			User creater = (User) session.getAttribute("UserInfo");
			houseTypeReview.setStatus(1);
			houseTypeReview.setCreateTime(new Date());
			houseTypeReview.setCreater(creater.getNickName());
			num = houseTypeReviewMapper.insert(houseTypeReview);
			
//			日志记录记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.add(session, houseTypeReview.getId(), TableName.house_type_review, "户型点评信息");
			sysLogMapper.insert(sysLog);
		}else{
			
			User Updater = (User) session.getAttribute("UserInfo");
			houseTypeReview.setStatus(1);
			houseTypeReview.setUpdateTime(new Date());
			houseTypeReview.setUpdater(Updater.getNickName());
			num = houseTypeReviewMapper.updateByPrimaryKeySelective(houseTypeReview);//只更新传值的字段
			
//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.edit(session, houseTypeReview.getId(), TableName.house_type_review, "户型点评信息");
			sysLogMapper.insert(sysLog);
		}
		if(num>0){
			logger.info("saveHouseTypeReview success!");
			JsonPrintUtil.printObjData(response, "ok");
		}
	}
	

	
	/**
	 * 事项点评信息的搜索功能
	 * @param page        页码
	 * @param rows        行号
	 * @param keyWord     查询条件
	 * @param request     接受客户端所发出的请求
	 * @param response    用于动态响应客户端请示
	 */
	@RequestMapping("searchListHouseTypeReview")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void searchListHouseTypeReview(@RequestParam("page") int page,@RequestParam("rows") int rows,String keyWord,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		HouseTypeReviewExample houseTypeReviewExample = new HouseTypeReviewExample();
		if (StringUtils.isNotBlank(keyWord)) {
			keyWord = "%" + keyWord + "%";
			//分页条件查询
			//and or联合查询
			houseTypeReviewExample.or().andTitleLike(keyWord).andStatusNotEqualTo(3);
			houseTypeReviewExample.or().andDesignerLike(keyWord).andStatusNotEqualTo(3);

		}else{
			Criteria criteria = houseTypeReviewExample.createCriteria();
			criteria.andStatusNotEqualTo(3);//非删除状态
		}
		int totalNums = houseTypeReviewMapper.countByExample(houseTypeReviewExample);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		houseTypeReviewExample.setPage(p);
		//排序
		houseTypeReviewExample.setOrderByClause("create_time desc");
		List<HouseTypeReview> orderList4Page = houseTypeReviewMapper.selectByExample(houseTypeReviewExample);
		
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0, TableName.house_type_review, "户型点评列表信息");
		sysLogMapper.insert(sysLog);

		JsonPrintUtil.printGridData(response, orderList4Page, totalNums,"rows","total");
	}
	
	
	
	/**
	 * 事项户型点评的信息的删除
	 * @param houseTypeIds	  houseTypeId的数组,接收用于批量删除数据
	 * @param session         存储用户会话所需要的的属性和配置的全部信息
	 * @param request         接受客户端所发出的请求
	 */
	@RequestMapping("delHouseTypeReview")
	@ResponseBody
	public void delHouseTypeReview(String houseTypeIds,HttpSession session,HttpServletResponse response) {
		if(!StringUtils.isBlank(houseTypeIds)){
			String[] orderIdsArr = houseTypeIds.split(",");
			for(int i=0;i<orderIdsArr.length;i++){
				int uId = Integer.parseInt(orderIdsArr[i]);
				HouseTypeReview  houseTypeReview= houseTypeReviewMapper.selectByPrimaryKey(uId);
				
				//1正常  3repair已删除 
				houseTypeReview.setStatus(3);
				houseTypeReviewMapper.updateByPrimaryKeySelective(houseTypeReview);
				
//				日志记录
				SysLog sysLog = new SysLog();
				sysLog =SysLogUtil.delete(session, houseTypeReview.getId(), TableName.house_type_review, "户型点评信息");
				sysLogMapper.insert(sysLog);
				
			}
			JsonPrintUtil.printObjData(response, "ok");
		}else{
			JsonPrintUtil.printObjData(response, "fail");
		}
	}
	
	
	@RequestMapping("/reviewImgFileListUpload")  
	@ResponseBody
	public void reviewImgFileListUpload(HttpSession session,HttpServletRequest request,HttpServletResponse response,MultipartFile file) {  
	    
		String idStr = request.getParameter("reviewImgId");
		int id = 0;
		if(StringUtils.isNotBlank(idStr) && StringUtils.isNumeric(idStr)){			
			id = Integer.parseInt(idStr);
		}
		String url = "";
		HouseTypeReview  houseTypeReview= houseTypeReviewMapper.selectByPrimaryKey(id);
		try {
			url = "/images/"+super.uploadToFileUrl(file , request, session);
			houseTypeReview.setThumbImg(url);
			houseTypeReviewMapper.updateByPrimaryKeySelective(houseTypeReview);
			//日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.upload(session, id, TableName.house_type_review, "楼盘点评缩略图");
			sysLogMapper.insert(sysLog);
			logger.info("文件上传成功... 服务器保存路径为："+url);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		JsonPrintUtil.printObjData(response, url);
	}

	
}
