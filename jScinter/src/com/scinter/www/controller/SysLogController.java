package com.scinter.www.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scinter.www.dao.SysLogMapper;
import com.scinter.www.model.SysLog;
import com.scinter.www.model.SysLogExample;
import com.scinter.www.model.SysLogExample.Criteria;
import com.scinter.www.util.DateUtil;
import com.scinter.www.util.JsonPrintUtil;
import com.scinter.www.util.POIStyleUtil;
import com.scinter.www.util.Page;

@Controller
@RequestMapping("admin")
public class SysLogController {

	private Logger logger = Logger.getLogger(SysLogController.class);

	@Autowired
	private SysLogMapper sysLogMapper;
	
	
	/**
	 * 日志记录的列表展示
	 * @param page				页码
	 * @param rows				页容量
	 * @param response			用于动态响应客户端请示
	 */
	@RequestMapping("listSysLogToJson")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void listSysLogToJson(@RequestParam("page") int page,@RequestParam("rows") int rows,HttpServletResponse response) {
		
		//分页条件查询
		SysLogExample sysLogExample = new SysLogExample();
		Criteria criteria = sysLogExample.createCriteria();
		
		//非删除状态
		criteria.andLogStatusNotEqualTo(3);
		int totalNums = sysLogMapper.countByExample(sysLogExample);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		sysLogExample.setPage(p);
		
		//排序
		sysLogExample.setOrderByClause("create_time desc");
		List<SysLog> caseList4Page = sysLogMapper.selectByExample(sysLogExample);
		JsonPrintUtil.printGridData(response, caseList4Page, totalNums,"rows","total");
	}
	
	
	/**
	 * 日志记录的删除的操纵
	 * @param logIds	  logId 的数组,接收用于批量删除数据
	 * @param session     存储用户会话所需要的的属性和配置的全部信息
	 * @param request     接受客户端所发出的请求
	 */
	@RequestMapping("delSysLog")
	@ResponseBody
	public void delSysLog(String logIds,HttpSession session,HttpServletResponse response) {
		if(!StringUtils.isBlank(logIds)){
			String[] orderIdsArr = logIds.split(",");
			
			for(int i=0;i<orderIdsArr.length;i++){
				int uId = Integer.parseInt(orderIdsArr[i]);
				SysLog  sysLog= sysLogMapper.selectByPrimaryKey(uId);
				//1正常  3repair已删除 
				sysLog.setLogStatus(3);
				sysLogMapper.updateByPrimaryKeySelective(sysLog);
			}
			JsonPrintUtil.printObjData(response, "ok");
		}else{
			JsonPrintUtil.printObjData(response, "fail");
		}
	}
	
	/**
	 * 
	 * @param page        页码
	 * @param rows        行号
	 * @param keyWord     查询条件
	 * @param request     接受客户端所发出的请求
	 * @param response    用于动态响应客户端请示
	 */
	@RequestMapping("searchListSysLog")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void searchListSysLog(@RequestParam("page") int page,@RequestParam("rows") int rows,String keyWord,String startDate,String endDate,HttpServletRequest request,HttpServletResponse response) {
		SysLogExample sysLogExample = new SysLogExample();
		Criteria criteria = sysLogExample.createCriteria();
		if (StringUtils.isNotBlank(keyWord)) {
			keyWord = "%" + keyWord + "%";
			//分页条件查询
			criteria.andDescNameLike(keyWord);
			if(StringUtils.isNotBlank(endDate) && StringUtils.isNotBlank(startDate)){				
				criteria.andCreateTimeGreaterThanOrEqualTo(DateUtil.getDate(startDate));
				criteria.andCreateTimeLessThanOrEqualTo(DateUtil.getDate(endDate));
			}
			criteria.andLogStatusNotEqualTo(3);
		}else{
			if(StringUtils.isNotBlank(endDate) && StringUtils.isNotBlank(startDate)){				
				criteria.andCreateTimeGreaterThanOrEqualTo(DateUtil.getDate(startDate));
				criteria.andCreateTimeLessThanOrEqualTo(DateUtil.getDate(endDate));
				criteria.andLogStatusNotEqualTo(3);
			}else{
				criteria.andLogStatusNotEqualTo(3);
			}
		}		
		
		int totalNums = sysLogMapper.countByExample(sysLogExample);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		sysLogExample.setPage(p);
		//排序
		sysLogExample.setOrderByClause("create_time desc");
		List<SysLog> logList4Page = sysLogMapper.selectByExample(sysLogExample);
		JsonPrintUtil.printGridData(response, logList4Page, totalNums,"rows","total");
	}
	
	@RequestMapping("exportSystemLogExcel")
	@ResponseBody
	public void exportLogExcel(HttpServletResponse response) {
		SysLogExample sysLogExample = new SysLogExample();
		sysLogExample.setOrderByClause("create_time desc");
		List<SysLog> logList4Page = sysLogMapper.selectByExample(sysLogExample);
		
		// 生成excel
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("系统操作日志列表");
		// 创建标题样式
		HSSFCellStyle titleStyle = workbook.createCellStyle();
		titleStyle = POIStyleUtil.getCellStyle(titleStyle);
		// 创建第一行
		HSSFRow row1 = sheet.createRow(0);
		// 设置行高
		row1.setHeightInPoints(23);
		row1.createCell(0).setCellValue("操作描述");
		row1.createCell(1).setCellValue("操作类型");
		row1.createCell(2).setCellValue("操作表主键");
		row1.createCell(3).setCellValue("操作表名称");
		row1.createCell(4).setCellValue("操作人");
		row1.createCell(5).setCellValue("操作时间");

		HSSFRow rowTemp = null;
		if (null != logList4Page && logList4Page.size() > 0) {
			int size = logList4Page.size();
			for (int i = 0; i < size; i++) {
				SysLog result = logList4Page.get(i);
				rowTemp = sheet.createRow(i + 1);
				rowTemp.createCell(0).setCellValue(result.getDescName());
				rowTemp.createCell(1).setCellValue(result.getOperationType());
				rowTemp.createCell(2).setCellValue(result.getMainKey());
				rowTemp.createCell(3).setCellValue(result.getTableName());
				rowTemp.createCell(4).setCellValue(result.getCreater());
				rowTemp.createCell(5).setCellValue(DateUtil.getStr(result.getCreateTime(), DateUtil.DATE_TIME_FORMAT));
			}
		}
		String timeStrNow = DateUtil.getStr(new Date(), DateUtil.DATE_TIME_FORMAT_Str);
		String excelFileName = timeStrNow + ".xls";
		response.reset();// 清空缓冲区, 防止页面中的空行等输出到下载内容里去
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename="+excelFileName);
		response.setHeader("Connection", "close");
		OutputStream excelOutPutStream = null;
		try {
			excelOutPutStream = response.getOutputStream();
			workbook.write(excelOutPutStream);
			excelOutPutStream.flush();
			excelOutPutStream.close();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}
	
}
