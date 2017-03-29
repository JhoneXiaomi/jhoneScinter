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
import com.scinter.www.model.HotBuildingExample;
import com.scinter.www.model.HouseTypeReview;
import com.scinter.www.model.HouseTypeReviewExample;
import com.scinter.www.model.Role;
import com.scinter.www.model.HouseTypeReviewExample.Criteria;
import com.scinter.www.model.SysLog;
import com.scinter.www.model.User;
import com.scinter.www.util.JsonPrintUtil;
import com.scinter.www.util.Page;
import com.scinter.www.util.SysLogUtil;
import com.scinter.www.util.TableName;

@Controller
@RequestMapping("admin")
public class HotBuildingController extends BaseController {

	private Logger logger = Logger.getLogger(HotBuildingController.class);
	
	@Autowired
	private HotBuildingMapper hotBuildingMapper;
	@Autowired
	private SysLogMapper sysLogMapper;
	@Autowired HouseTypeReviewMapper houseTypeReviewMapper;
	
	   /**
		 * 实现楼盘信息的查询的方法
		 * @param page        页码
		 * @param rows        行号
		 * @param keyWord     查询条件
		 * @param request     接受客户端所发出的请求
		 * @param response    用于动态响应客户端请示
		 */
		@RequestMapping("searchListHotBuilding")
		@ResponseBody
		// 页面参数：当前页 page 每页显示条数rows
		public void searchListHotBuilding(@RequestParam("page") int page,@RequestParam("rows") int rows,String BCompany,String keyWord,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
			Role currentRole= (Role)session.getAttribute("Role");
			String branchCompany = currentRole.getBranchCompany();
			HotBuildingExample hotBuildingExample = new HotBuildingExample();
			if (StringUtils.isNotBlank(keyWord) && !BCompany.equals("===请选择===")) {
				keyWord = "%" + keyWord + "%";
				//and or联合查询
				hotBuildingExample.or().andBulidingNameLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
			}else if(StringUtils.isNotBlank(keyWord) && BCompany.equals("===请选择===")) {
				keyWord = "%" + keyWord + "%";
				//and or联合查询
				hotBuildingExample.or().andBulidingNameLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(branchCompany);
			}else if(StringUtils.isBlank(keyWord) && !BCompany.equals("===请选择===")) {
				//and or联合查询
				HotBuildingExample.Criteria criteria = hotBuildingExample.createCriteria();
				criteria.andStatusNotEqualTo(3);//非删除状态
				criteria.andBranchCompanyEqualTo(BCompany);
			}else{
				String roleName = currentRole.getRoleName();
				if(!"超级管理员".equals(roleName)){
					HotBuildingExample.Criteria criteria = hotBuildingExample.createCriteria();
					criteria.andStatusNotEqualTo(3);//非删除状态
					criteria.andBranchCompanyEqualTo(currentRole.getBranchCompany());//当前用户所属分公司
				}else{
					HotBuildingExample.Criteria criteria = hotBuildingExample.createCriteria();
					criteria.andStatusNotEqualTo(3);//非删除状态
				}
				
				
			}
			int totalNums = hotBuildingMapper.countByExample(hotBuildingExample);
			Page p = new Page((page - 1) * rows, rows);
			p.setTotalRecords(totalNums);
			hotBuildingExample.setPage(p);
			//排序
			hotBuildingExample.setOrderByClause("create_time desc");
			List<HotBuilding> hotBuildingList4Page = hotBuildingMapper.selectByExample(hotBuildingExample);
			
//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.search(session,0 , TableName.hot_building, "热装楼盘列表信息");
			sysLogMapper.insert(sysLog);
			
			JsonPrintUtil.printGridData(response, hotBuildingList4Page, totalNums,"rows","total");
		}
		
	/**
	 * 获取热装楼盘的信息
	 * @param page  				页码
	 * @param rows					页容量
	 * @param response				返回处理结果的响应的内容
	 */
	@RequestMapping("listHotBuildingToJson")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void listHotBuildingToJson(@RequestParam("page") int page,@RequestParam("rows") int rows,HttpSession session,HttpServletResponse response) {
		
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
		HotBuildingExample hotBuildingExample = new HotBuildingExample();
		com.scinter.www.model.HotBuildingExample.Criteria criteria = hotBuildingExample.createCriteria();
		Role currentRole= (Role)session.getAttribute("Role");
		String roleName = currentRole.getRoleName();
		String branchCompany = "";
		if(!"超级管理员".equals(roleName)){
			branchCompany = currentRole.getBranchCompany();
			criteria.andBranchCompanyEqualTo(branchCompany);//当前用户所属分公司
		}else{
			
			criteria.andBranchCompanyLike("%"+spilCompany+"%");
		}
		//非删除状态
		criteria.andStatusNotEqualTo(3);
		
		int totalNums = hotBuildingMapper.countByExample(hotBuildingExample);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		hotBuildingExample.setPage(p);
		hotBuildingExample.setOrderByClause("create_time desc");//排序
		List<HotBuilding> caseList4Page = hotBuildingMapper.selectByExample(hotBuildingExample);
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session,0 , TableName.hot_building, "热装楼盘列表信息");
		sysLogMapper.insert(sysLog);
		session.setAttribute("branchCompany", branchCompany);
		JsonPrintUtil.printGridData(response, caseList4Page, totalNums,"rows","total");
	}
	
	/**
	 * 编写编辑方法
	 * @param buildingId			热装楼盘的Id
	 * @return
	 */
	@RequestMapping("showHotBuilding")
	public ModelAndView showHotBuilding(@RequestParam("buildingId") int buildingId,HttpSession session){
		
		ModelAndView model = new ModelAndView();
		HotBuilding hotBuilding = hotBuildingMapper.selectByPrimaryKey(buildingId);
		
//		获取对应的BulidingId 下的搜有的户型
		HouseTypeReviewExample houseTypeReviewExample = new HouseTypeReviewExample();
		Criteria criteria = houseTypeReviewExample.createCriteria();
//		查询状态非删除状态的户型
		
		criteria.andBulidingIdEqualTo(buildingId);
		criteria.andStatusNotEqualTo(3);
	    List<HouseTypeReview> houseList = houseTypeReviewMapper.selectByExample(houseTypeReviewExample);
	    model.addObject("houseList",houseList);
	    
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, hotBuilding.getBulidingId(), TableName.hot_building, "热装楼盘信息");
		sysLogMapper.insert(sysLog);
		
		model.addObject("hotBuildingInfo", hotBuilding);
		model.setViewName("/admin/hotBuildingSave");
		return model;
	}
	
	/**
	 * 实现保存，更行，新建的方法
	 * @param hotBuilding    hotBuiling实体类,封装了在线报属性修的全部信息
	 * @param response  用于动态响应客户端请示
	 * @param request   接受客户端所发出的请求
	 */
	@RequestMapping("saveHotBuilding")
	@ResponseBody
	public void saveHotBuilding(HotBuilding hotBuilding,HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		
		int num = 0;
		if(null==hotBuilding.getBulidingId()){
			
			User creater = (User) session.getAttribute("UserInfo");
			hotBuilding.setStatus(1);
			hotBuilding.setCreateTime(new Date());
			hotBuilding.setCreater(creater.getNickName());
			num = hotBuildingMapper.insert(hotBuilding);
			
			
//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.add(session, hotBuilding.getBulidingId(), TableName.hot_building, "热装楼盘信息");
			sysLogMapper.insert(sysLog);
		}else{
			User Updater = (User) session.getAttribute("UserInfo");
			hotBuilding.setStatus(1);
			hotBuilding.setUpdateTime(new Date());
			hotBuilding.setUpdater(Updater.getNickName());
			num = hotBuildingMapper.updateByPrimaryKeySelective(hotBuilding);//只更新传值的字段
			

//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.edit(session,hotBuilding.getBulidingId(), TableName.hot_building, "热装楼盘信息");
			sysLogMapper.insert(sysLog);			
		}
		if(num>0){
			logger.info("saveHotBuilding success!");
			JsonPrintUtil.printObjData(response, "ok");
		}
	}
 
     /**
	 * 实现删除的方法
	 * @param builidingIds	    buildingIds的数组,接收用于批量删除数据
	 * @param session           存储用户会话所需要的的属性和配置的全部信息
	 * @param request           接受客户端所发出的请求
	 */
	@RequestMapping("delHotBuilding")
	@ResponseBody
	public void delHotBuilding(String buildingIds,HttpSession session,HttpServletResponse response) {
		if(!StringUtils.isBlank(buildingIds)){
			String[] orderIdsArr = buildingIds.split(",");
			for(int i=0;i<orderIdsArr.length;i++){
				int uId = Integer.parseInt(orderIdsArr[i]);
				HotBuilding  hotBuilding= hotBuildingMapper.selectByPrimaryKey(uId);
				
				//1正常  3repair已删除 
				hotBuilding.setStatus(3);
				hotBuildingMapper.updateByPrimaryKeySelective(hotBuilding);
				
//				日志记录热装楼盘的删除信息
				SysLog sysLog = new SysLog();
				sysLog =SysLogUtil.delete(session, hotBuilding.getBulidingId(), TableName.hot_building, "热装楼盘信息");
				sysLogMapper.insert(sysLog);
			}
			JsonPrintUtil.printObjData(response, "ok");
		}else{
			JsonPrintUtil.printObjData(response, "fail");
		}
	}

	/**
	 * 实现图片的上传的方法的编写
	 * @param t						   上传图片类型的标识
	 * @param buildingId			   热点楼盘的编号
	 * @param request				   接受客户端所发出的请求
	 * @param response				   响应返回的结果	
	 * @param file					  上传的文件
	 */
	@RequestMapping("/hotBuildingImgFileUpload")  
	@ResponseBody
	public void hotBuildingImgFileUpload(HttpSession session,HttpServletRequest request,HttpServletResponse response,MultipartFile file) {  
	    
		String buildingIdStr = request.getParameter("buildingId");
		int buildingId = 0;
		if(StringUtils.isNotBlank(buildingIdStr) && StringUtils.isNumeric(buildingIdStr)){			
			buildingId = Integer.parseInt(buildingIdStr);
		}
		
		String url = "";
	    HotBuilding hotBuilding = hotBuildingMapper.selectByPrimaryKey(buildingId);
		try {
			
			url = "/images/"+super.uploadToFileUrl(file , request, session);
			
			hotBuilding.setBulidingThumbImg(url);
			hotBuildingMapper.updateByPrimaryKeySelective(hotBuilding);
			//日志记录热装楼盘的删除信息
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.upload(session, hotBuilding.getBulidingId(), TableName.hot_building, "热装楼盘图片");
			sysLogMapper.insert(sysLog);
			
			logger.info("文件上传成功... 服务器保存路径为："+url);
			
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		JsonPrintUtil.printObjData(response, url);
	}

        /**
         * 
         * 编写获取热点楼盘的信息
         * @param response		返回相应的数据
         */
		@RequestMapping("getAllbuildingName")
		@ResponseBody
		public void getAllbuildingName(HttpServletResponse response) {
			HotBuildingExample hotBuildingExample = new HotBuildingExample();
			com.scinter.www.model.HotBuildingExample.Criteria criteria = hotBuildingExample.createCriteria();
			
			criteria.andStatusNotEqualTo(3);//非删除状态
			
			hotBuildingExample.setOrderByClause("buliding_id desc");
			List<HotBuilding> buildingList = hotBuildingMapper.selectByExample(hotBuildingExample);
			logger.info(buildingList.size());
			JsonPrintUtil.printObjDataWithNoRoot(response, buildingList);
		}
	
}
