package com.scinter.www.util;


import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonPrintUtil {
	
	private static Logger logger = Logger.getLogger(JsonPrintUtil.class);
	
	public static void printGridData(HttpServletResponse response, Object obj, int total, String root, String count) {
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = null;
		
		//日期格式化
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss"));
		JSONArray jsonArray = JSONArray.fromObject(obj, jsonConfig);
		
		try {
			out = response.getWriter();
			JSONObject json = new JSONObject();
			if (!StringUtils.isBlank(root)) {
				json.put(root, jsonArray);
				json.put(count, total);
			}
			out.print(json.toString());
			logger.debug(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void printObjData(HttpServletResponse response, Object obj) {
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			JSONObject json = new JSONObject();
			json.put("data", obj);
			out.print(json.toString());
			logger.debug(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printObjDataWithKey(HttpServletResponse response,String key ,Object obj) {
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			JSONObject json = new JSONObject();
			json.put(key, obj);
			out.print(json.toString());
			logger.debug(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printObjDataWithNoRoot(HttpServletResponse response, Object obj) {
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			JSONArray json = JSONArray.fromObject(obj);
			out.print(json.toString());
			logger.debug(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//JacksonMapper输出
	public static void printJsonObj(HttpServletResponse response, Object obj) {
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		ObjectMapper mapper = JacksonMapper.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.setDateFormat(df);
		try {
			mapper.writeValue(response.getWriter(), obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
