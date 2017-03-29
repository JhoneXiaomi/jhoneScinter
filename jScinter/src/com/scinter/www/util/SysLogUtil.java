package com.scinter.www.util;


import java.util.Date;

import javax.servlet.http.HttpSession;

import com.scinter.www.model.SysLog;
import com.scinter.www.model.User;


public class SysLogUtil {
 
	
	
//	查找
	public static SysLog search(HttpSession session,int mainkey,String tableName,String DescName) {
		

		SysLog sysLog = new SysLog();
		User user = (User) session.getAttribute("UserInfo");
		sysLog.setCreater(user.getNickName());
		sysLog.setCreateTime(new Date());
		sysLog.setDescName("用户："+user.getNickName()+OperationType.RESEARCH+DescName);
		sysLog.setLogStatus(1);
		Integer mkey = new Integer(mainkey);
		sysLog.setMainKey(mkey);
		sysLog.setOperationType(OperationType.RESEARCH);
		sysLog.setTableName(tableName);
		return sysLog;
	}
	
//	编辑
	public static SysLog edit(HttpSession session,Integer mainkey,String tableName,String DescName) {
		SysLog sysLog = new SysLog();
		User user = (User) session.getAttribute("UserInfo");
		sysLog.setCreater(user.getNickName());
		sysLog.setCreateTime(new Date());
		sysLog.setDescName("用户："+user.getNickName()+OperationType.EDIT+DescName);
		sysLog.setLogStatus(1);
		sysLog.setMainKey(mainkey);
		sysLog.setOperationType(OperationType.EDIT);
		sysLog.setTableName(tableName);
		
		return sysLog;
	}
	
//	删除
	public static SysLog delete(HttpSession session,Integer mainkey,String tableName,String DescName) {
		SysLog sysLog = new SysLog();
		User user = (User) session.getAttribute("UserInfo");
		sysLog.setCreater(user.getNickName());
		sysLog.setCreateTime(new Date());
		sysLog.setDescName("用户："+user.getNickName()+OperationType.DELETE+DescName);
		sysLog.setLogStatus(1);
		sysLog.setMainKey(mainkey);
		sysLog.setOperationType(OperationType.DELETE);
		sysLog.setTableName(tableName);
		return sysLog;
	}
	
//	注销
	public static SysLog loginOut(HttpSession session,Integer mainkey,String tableName,String DescName) {
		SysLog sysLog = new SysLog();
		User user = (User) session.getAttribute("UserInfo");
		sysLog.setCreater(user.getNickName());
		sysLog.setCreateTime(new Date());
		sysLog.setDescName("用户："+user.getNickName()+OperationType.LOGINOUT+DescName);
		sysLog.setLogStatus(1);
		sysLog.setMainKey(mainkey);
		sysLog.setOperationType(OperationType.LOGINOUT);
		sysLog.setTableName(tableName);
		return sysLog;
	}

//	添加
	public static SysLog add(HttpSession session,Integer mainkey,String tableName,String DescName) {
		SysLog sysLog = new SysLog();
		User user = (User) session.getAttribute("UserInfo");
		sysLog.setCreater(user.getNickName());
		sysLog.setCreateTime(new Date());
		sysLog.setDescName("用户："+user.getNickName()+OperationType.ADD+DescName);
		sysLog.setLogStatus(1);
		sysLog.setMainKey(mainkey);
		sysLog.setOperationType(OperationType.ADD);
		sysLog.setTableName(tableName);
		return sysLog;
	}
	
	
//	上传
	public static SysLog upload(HttpSession session,Integer mainkey,String tableName,String DescName) {
		SysLog sysLog = new SysLog();
		User user = (User) session.getAttribute("UserInfo");
		sysLog.setCreater(user.getNickName());
		sysLog.setCreateTime(new Date());
		sysLog.setDescName("用户："+user.getNickName()+OperationType.UPLOAD+DescName);
		sysLog.setLogStatus(1);
		Integer mkey = new Integer(mainkey);
		sysLog.setMainKey(mkey);
		sysLog.setOperationType(OperationType.UPLOAD);
		sysLog.setTableName(tableName);
		return sysLog;
	}
//	登录
	public static SysLog login(HttpSession session,Integer mainkey,String tableName,String DescName) {
		SysLog sysLog = new SysLog();
		User user = (User) session.getAttribute("UserInfo");
		sysLog.setCreater(user.getNickName());
		sysLog.setCreateTime(new Date());
		sysLog.setDescName("用户："+user.getNickName()+OperationType.LOGIN+DescName);
		sysLog.setLogStatus(1);
		Integer mkey = new Integer(mainkey);
		sysLog.setMainKey(mkey);
		sysLog.setOperationType(OperationType.LOGIN);
		sysLog.setTableName(tableName);
		return sysLog;
	}
	
//	备份
	public static SysLog backup(HttpSession session,Integer mainkey,String tableName,String DescName) {
		SysLog sysLog = new SysLog();
		User user = (User) session.getAttribute("UserInfo");
		sysLog.setCreater(user.getNickName());
		sysLog.setCreateTime(new Date());
		sysLog.setDescName("用户："+user.getNickName()+OperationType.BACKUP+DescName);
		sysLog.setLogStatus(1);
		Integer mkey = new Integer(mainkey);
		sysLog.setMainKey(mkey);
		sysLog.setOperationType(OperationType.BACKUP);
		sysLog.setTableName(tableName);
		return sysLog;
	}

}
