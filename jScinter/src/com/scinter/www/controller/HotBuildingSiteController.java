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

import com.scinter.www.dao.DesignerMapper;
import com.scinter.www.dao.HotBuildingSiteImageMapper;
import com.scinter.www.dao.HotBuildingSiteMapper;
import com.scinter.www.dao.HouseTypeReviewMapper;
import com.scinter.www.dao.SysLogMapper;
import com.scinter.www.model.Designer;
import com.scinter.www.model.HotBuildingSite;
import com.scinter.www.model.HotBuildingSiteExample;
import com.scinter.www.model.HotBuildingSiteExample.Criteria;
import com.scinter.www.model.HotBuildingSiteImage;
import com.scinter.www.model.HotBuildingSiteImageExample;
import com.scinter.www.model.Role;
import com.scinter.www.model.SysLog;
import com.scinter.www.model.User;
import com.scinter.www.util.JsonPrintUtil;
import com.scinter.www.util.Page;
import com.scinter.www.util.SysLogUtil;
import com.scinter.www.util.TableName;

@Controller
@RequestMapping("admin")
public class HotBuildingSiteController extends BaseController {

	private Logger logger = Logger.getLogger(HotBuildingSiteController.class);
	
	@Autowired
	private HotBuildingSiteMapper hotBuildingSiteMapper;
	@Autowired
	private SysLogMapper sysLogMapper;
	@Autowired
	private DesignerMapper designerMapper;
	@Autowired 
	private HouseTypeReviewMapper houseTypeReviewMapper;
	@Autowired
	private HotBuildingSiteImageMapper hotBuildingSiteImageMapper;
	
	/**
	 * 获取在建工地的信息
	 * @param page  				页码
	 * @param rows					页容量
	 * @param response				返回处理结果的响应的内容
	 */
	@RequestMapping("listHotBuildingSiteToJson")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void listHotBuildingSiteToJson(@RequestParam("page") int page,@RequestParam("rows") int rows,HttpSession session,HttpServletResponse response) {
		
		logger.info("you are welcome listHotBuildingSiteToJson");
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
		HotBuildingSiteExample hotBuildingSiteExample = new HotBuildingSiteExample();
		Criteria criteria = hotBuildingSiteExample.createCriteria();
		Role currentRole= (Role)session.getAttribute("Role");
		String roleName = currentRole.getRoleName();
		if(!"超级管理员".equals(roleName)){
			
			String branchCompany = currentRole.getBranchCompany();
			criteria.andBranchCompanyEqualTo(branchCompany);//当前用户所属分公司
		}else{
			
			criteria.andBranchCompanyLike("%"+spilCompany+"%");
		}
		//非删除状态
		criteria.andStatusNotEqualTo(3);
		
		int totalNums = hotBuildingSiteMapper.countByExample(hotBuildingSiteExample);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		hotBuildingSiteExample.setPage(p);
		hotBuildingSiteExample.setOrderByClause("create_time desc");//排序
		List<HotBuildingSite> siteList4Page = hotBuildingSiteMapper.selectByExample(hotBuildingSiteExample);
		
		
		
		logger.info("the length "+siteList4Page.size());
		List<HotBuildingSite>  sites = new ArrayList<HotBuildingSite>() ;
		
		for(HotBuildingSite site:siteList4Page){

			Designer designer = designerMapper.selectByPrimaryKey(site.getDesignerId());
			site.setDesignerName(designer.getDesignerName());
			sites.add(site);
		
		}
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session,0 , TableName.hot_building_site, "在建工地列表信息");
		sysLogMapper.insert(sysLog);
		
		JsonPrintUtil.printGridData(response, sites, totalNums,"rows","total");
	}
		
	
	/**
	 * 在建工地保存，更新，新建的方法
	 * @param hotBuildingSite  		 hotBuilingSite实体类,封装了在线报属性修的全部信息
	 * @param response 				 用于动态响应客户端请示
	 * @param request  				 接受客户端所发出的请求
	 */
	@RequestMapping("saveHotBuildingSite")
	@ResponseBody
	public void saveHotBuildingSite(HotBuildingSite hotBuildingSite,HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		
		int num = 0;
		if(null==hotBuildingSite.getId()){
			
			User creater = (User) session.getAttribute("UserInfo");
			hotBuildingSite.setStatus(1);
			hotBuildingSite.setCreateTime(new Date());
			hotBuildingSite.setCreater(creater.getNickName());
			num = hotBuildingSiteMapper.insert(hotBuildingSite);
			
			int siteId = hotBuildingSite.getId();
			//更新关联的工地图片信息
			String siteImageIdArr = request.getParameter("siteImageIdArr");
			HotBuildingSiteImage img = null;
			if(StringUtils.isNotBlank(siteImageIdArr)){
				String[] imgIdArr = siteImageIdArr.split(",");
				for(String imageIdStr : imgIdArr){
					if(StringUtils.isNotBlank(imageIdStr) && StringUtils.isNumeric(imageIdStr)){
						img = new HotBuildingSiteImage();
						int imageId = Integer.parseInt(imageIdStr);
						img.setImageId(imageId);
						img.setSiteId(siteId);
						hotBuildingSiteImageMapper.updateByPrimaryKeySelective(img);
					}
				}
			}
			
//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.add(session, hotBuildingSite.getId(), TableName.hot_building_site, "在建工地信息");
			sysLogMapper.insert(sysLog);
		}else{
			User Updater = (User) session.getAttribute("UserInfo");
			hotBuildingSite.setStatus(1);
			hotBuildingSite.setUpdateTime(new Date());
			hotBuildingSite.setUpdater(Updater.getNickName());
			num = hotBuildingSiteMapper.updateByPrimaryKeySelective(hotBuildingSite);//只更新传值的字段
			

//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.edit(session,hotBuildingSite.getId(), TableName.hot_building_site, "在建工地信息");
			sysLogMapper.insert(sysLog);			
		}
		if(num>0){
			logger.info("saveHotBuildingSite success!");
			JsonPrintUtil.printObjData(response, "ok");
		}
	}	
	

	/**
	 * 编写编辑方法
	 * @param buildingSiteId			所要编辑的在建工地的Id
	 * @return
	 */
	@RequestMapping("showHotBuildingSite")
	public ModelAndView showHotBuildingSite(@RequestParam("buildingSiteId") int buildingSiteId,HttpSession session){
		
		ModelAndView model = new ModelAndView();
		HotBuildingSite hotBuildingSite = hotBuildingSiteMapper.selectByPrimaryKey(buildingSiteId);
		model.addObject("hotBuildingSiteInfo", hotBuildingSite);
		
		// 日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, hotBuildingSite.getId(), TableName.hot_building_site, "在建工地信息");
		sysLogMapper.insert(sysLog);
		
		
		HotBuildingSiteImageExample sx = new HotBuildingSiteImageExample();
		HotBuildingSiteImageExample.Criteria criteria = sx.createCriteria();
		criteria.andStatusEqualTo(1);
		criteria.andSiteIdEqualTo(buildingSiteId);
		
		List<HotBuildingSiteImage> imgList = hotBuildingSiteImageMapper.selectByExample(sx);
		model.addObject("hotBuildingSiteListInfo", imgList);
		
		
		model.setViewName("/admin/hotBuildingSiteSave");
		return model;
	}

  /**
	 * 实现删除的方法
	 * @param builidingIds	    buildingIds的数组,接收用于批量删除数据
	 * @param session           存储用户会话所需要的的属性和配置的全部信息
	 * @param request           接受客户端所发出的请求
	 */
	@RequestMapping("delHotBuildingSite")
	@ResponseBody
	public void delHotBuildingSite(String buildingSiteIds,HttpSession session,HttpServletResponse response) {
		if(!StringUtils.isBlank(buildingSiteIds)){
			String[] buildingSiteIdsArr = buildingSiteIds.split(",");
			for(int i=0;i<buildingSiteIdsArr.length;i++){
				int uId = Integer.parseInt(buildingSiteIdsArr[i]);
				HotBuildingSite  hotBuildingSite= hotBuildingSiteMapper.selectByPrimaryKey(uId);
				
				//1正常  3repair已删除 
				hotBuildingSite.setStatus(3);
				hotBuildingSiteMapper.updateByPrimaryKeySelective(hotBuildingSite);
				
//				日志记录热装楼盘的删除信息
				SysLog sysLog = new SysLog();
				sysLog =SysLogUtil.delete(session, hotBuildingSite.getId(), TableName.hot_building_site, "在建工地信息");
				sysLogMapper.insert(sysLog);
			}
			JsonPrintUtil.printObjData(response, "ok");
		}else{
			JsonPrintUtil.printObjData(response, "fail");
		}
	}

	   /**
		 * 实现在建工地的查询的方法
		 * @param page        页码
		 * @param rows        行号
		 * @param keyWord     查询条件
		 * @param request     接受客户端所发出的请求
		 * @param response    用于动态响应客户端请示
		 */
	@RequestMapping("searchListHotBuildingSite")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void searchListHotBuildingSite(@RequestParam("page") int page,@RequestParam("rows") int rows,String BCompany,String keyWord,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		HotBuildingSiteExample hotBuildingSiteExample = new HotBuildingSiteExample();
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
		
		logger.info("the value of BCompany:"+BCompany);
		if (StringUtils.isNotBlank(keyWord) && !BCompany.equals("===请选择===")) {
			
			keyWord = "%" + keyWord + "%";
			//and or联合查询
			hotBuildingSiteExample.or().andSiteNameLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
		}else if(StringUtils.isNotBlank(keyWord) && BCompany.equals("===请选择===")) {
			
			keyWord = "%" + keyWord + "%";
			//and or联合查询
			hotBuildingSiteExample.or().andSiteNameLike(keyWord).andStatusNotEqualTo(3).andBranchCompanyEqualTo(branchCompany);
		}else if(StringUtils.isBlank(keyWord) && !BCompany.equals("===请选择===")) {
			
			keyWord = "%" + keyWord + "%";
			//and or联合查询
			hotBuildingSiteExample.or().andStatusNotEqualTo(3).andBranchCompanyEqualTo(BCompany);
		}else{
			
			Criteria criteria = hotBuildingSiteExample.createCriteria();
			criteria.andBranchCompanyEqualTo(branchCompany);//当前用户所属分公司
			criteria.andStatusNotEqualTo(3);//非删除状态
		}
		int totalNums = hotBuildingSiteMapper.countByExample(hotBuildingSiteExample);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		hotBuildingSiteExample.setPage(p);
		//排序
		hotBuildingSiteExample.setOrderByClause("create_time desc");
		List<HotBuildingSite> hotBuildingList4Page = hotBuildingSiteMapper.selectByExample(hotBuildingSiteExample);
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session,0 , TableName.hot_building_site, "在建工地列表信息");
		sysLogMapper.insert(sysLog);
		
		JsonPrintUtil.printGridData(response, hotBuildingList4Page, totalNums,"rows","total");
	}
	
	// 工地展示图片上传
	@RequestMapping("/siteImgFileListUpload")
	@ResponseBody
	public void caseImgFileListUpload(HttpServletRequest request,
			HttpSession session, HttpServletResponse response,
			MultipartFile file) {
		User user = (User) request.getSession().getAttribute("UserInfo");
		String siteIdStr = request.getParameter("siteId");
		String imageType = request.getParameter("imageType");
		int siteId = 0;
		if (StringUtils.isNotBlank(siteIdStr)
				&& StringUtils.isNumeric(siteIdStr)) {
			siteId = Integer.parseInt(siteIdStr);
		}

		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			JSONObject json = new JSONObject();
			String path = "/images/" + super.uploadToFileUrl(file, request, session);
			logger.info("文件上传成功... 服务器保存路径为：" + path);
			
			// 图片信息入库
			HotBuildingSiteImage siteImg = new HotBuildingSiteImage();
			siteImg.setCreater(user.getUserName());
			siteImg.setCreateTime(new Date());
			siteImg.setImageUrl(path);
			siteImg.setImageType(imageType);
			siteImg.setSiteId(siteId);
			siteImg.setStatus(1);
			hotBuildingSiteImageMapper.insert(siteImg);
			
			json.put("imageId", siteImg.getImageId());
			json.put("url", path);

			// 日志记录
			SysLog sysLog = new SysLog();
			sysLog = SysLogUtil.upload(session, siteImg.getImageId(),
					TableName.hot_building_site_img, "在建工地施工阶段图片");
			sysLogMapper.insert(sysLog);
			out.print(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
	}
	
	//工地缩略图上传
	@RequestMapping("/siteThumbImgFileUpload")
	@ResponseBody
	public void siteThumbImgFileUpload(HttpServletRequest request,
			HttpSession session, HttpServletResponse response,
			MultipartFile file) {
		User user = (User) request.getSession().getAttribute("UserInfo");
		String siteIdStr = request.getParameter("siteId");
		int siteId = 0;
		if (StringUtils.isNotBlank(siteIdStr)&& StringUtils.isNumeric(siteIdStr)) {
			siteId = Integer.parseInt(siteIdStr);
		}
		
		String url = "";
		try {
			url = "/images/" + super.uploadToFileUrl(file, request, session);
			logger.info("文件上传成功... 服务器保存路径为：" + url);

			//信息入库
			HotBuildingSite hs =  hotBuildingSiteMapper.selectByPrimaryKey(siteId);
			hs.setSiteThumbImg(url);
			hs.setUpdater(user.getUserName());
			hs.setUpdateTime(new Date());
			hotBuildingSiteMapper.updateByPrimaryKeySelective(hs);
			
			// 日志记录
			SysLog sysLog = new SysLog();
			sysLog = SysLogUtil.upload(session, siteId,TableName.hot_building_site, "在建工地缩略图上传");
			sysLogMapper.insert(sysLog);
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		JsonPrintUtil.printObjData(response, url);
	}
	
	
	@RequestMapping("delBuildingImage")
	@ResponseBody
	public void delBuildingImage(Integer buildingImageId,HttpSession session,HttpServletResponse response){
		
		if(buildingImageId!=null){
			HotBuildingSiteImage csi = hotBuildingSiteImageMapper.selectByPrimaryKey(buildingImageId);
			csi.setStatus(3);
			hotBuildingSiteImageMapper.updateByPrimaryKeySelective(csi);
			JsonPrintUtil.printObjData(response, "ok");
			
			// 日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.delete(session, csi.getImageId(), TableName.hot_building_site_img, "在建工地展示图");
			sysLogMapper.insert(sysLog);

		}else{
			JsonPrintUtil.printObjData(response, "fail");
		}
	}

	
}
