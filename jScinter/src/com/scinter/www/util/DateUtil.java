package com.scinter.www.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 日期处理工具类 。
 * <p>
 * 
 * Create date:3/11/2011
 * 
 * @author jianwei.liu
 * 
 */

/**
 * @author Conrad Liu
 *
 */
public class DateUtil {
	
	private static Logger log = Logger.getLogger(DateUtil.class);
	
	/** yyyy-MM-dd */
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATE_FORMAT_DIR = "yyyy/MM/dd";
	public static final String DATE_FORMAT_CN = "yyyy年MM月dd日";
	public static final String DATE_TIME_FORMAT_CN = "yyyy年MM月dd日 HH时mm分ss秒";
	/** yyyy-MM-dd HH:mm:ss */
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_TIME_FORMAT_Str = "yyyyMMddHHmmss";
	/** yyyy-MM-dd HH:mm:ss */
	public static final String DATE_SHORT_TIME_FORMAT = "yyyy-MM-dd HH:mm";
	public static final String SHORT_HOUR_MINUTE_FORMAT = "HH:mm";
	public static final String SHORT_HOUR_TIME_FORMAT = "HH:mm:ss";
	
	public static final String SHORT_TIME_FORMAT = "dd日HH时";
	/** 1970-1-1 */
	public static final String DEFAULT_DATE = "1970-1-1";

	/**
	 * 获取默认格式（yyyy-MM-dd）的日期日期对象 。<br>
	 * 
	 * Create date:8/30/2012 Last modify:8/30/2012
	 * 
	 * @param strDate
	 *            目标日期字符串
	 * @return 日期对象
	 * 
	 * @author jianwei.liu
	 */
	public static Date getDate(String strDate) {
		return getDate(strDate, DATE_FORMAT);
	}
	
	/**
	 * 用指定的格式的字符串生成日期对象 。<br>
	 * Format eg. yyyy-MM-dd HH:mm:ss<br>
	 * 
	 * Create date:3/11/2011 Last modify:3/11/2011
	 * 
	 * @param strDate
	 *            被判断的字符串
	 * @param format
	 *            格式
	 * @return 日期对象
	 * 
	 * @author jianwei.liu
	 */
	public static Date getDate(String strDate, String format) {
		Date date = null;
		try {
			if (StringUtils.isNotBlank(strDate)) {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				date = sdf.parse(strDate);
			}
		} catch (Exception ex) {
			date = new Date();
		}

		return date;
	}
	
	/**
	 * @function 转换格式如Mon, 18 Jun 2012 20:24:23 +0800的字符串为Date类型
	 * @param dateStr
	 * @return Date
	 */
	public static Date getMyDate(String dateStr){
		Date myDate = null;
		
		if (!StringUtils.isNotBlank(dateStr)) {
			return myDate;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("EEE,dd MMM yyyy HH:mm:ss Z", new Locale("ENGLISH", "CHINA"));
		try {
			myDate = sdf.parse(dateStr);
		} catch (ParseException e) {
			log.error("date format error");
		}
		return myDate;
	}

	/**
	 * 用指定的格式的字符串生成日期字符串 。<br>
	 * Format eg. yyyy-MM-dd HH:mm:ss<br>
	 * 
	 * Create date:3/23/2011 Last modify:3/231/2011
	 * 
	 * @param strDate
	 *            目标日期对象
	 * @param format
	 *            格式
	 * @return 日期字符串
	 * 
	 * @author jianwei.liu
	 */
	public static String getStr(Date date, String format) {
		if (date != null) {
			SimpleDateFormat dFormat = new SimpleDateFormat(format);
			return dFormat.format(date);

		} else {
			return "";
		}
	}

	public static String getStr(Date date, String format, Locale locale) {
		
		if(locale == null){
			return getStr(date, format);
		}
		
		if (date != null) {
			SimpleDateFormat dFormat = new SimpleDateFormat(format, locale);
			return dFormat.format(date);
			
		} else {
			return "";
		}
	}
	
	/**
	 * 获取默认格式（yyyy-MM-dd）的日期字符串 。<br>
	 * 
	 * Create date:7/17/2012 Last modify:7/17/2012
	 * 
	 * @param strDate
	 *            目标日期对象
	 * @return 日期字符串
	 * 
	 * @author jianwei.liu
	 */
	public static String getStr(Date date) {
		return getStr(date, DATE_FORMAT);
	}

	/**
	 * 获取相对时间 。<br>
	 * 
	 * Create date:12/6/2011 Last modify:12/6/2011
	 * 
	 * @param date
	 *            基础日期对象
	 * @param field
	 *            单位，月、日、年等，如：Calendar.MONTH, Calendar.DATE
	 * @param amount
	 *            相差单位的个数，可为负值
	 * @return 日期对象
	 * 
	 * @author jianwei.liu
	 */
	public static Date getRelativeDate(Date date, int field, int amount) {
		if (date == null)
			return null;

		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(field, amount);

		return gc.getTime();
	}
	
	
	/**
	 * 计算日期是星期几
	 * @param dt  待计算日期
	 * @param type 结果类型，分中文星期和数字,对应的参数值分别为 cn 和 num
	 * @return string
	 */
	public static String getWeekOfDate(Date dt,String type) {
        String[] weekDaysCn = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        String[] weekDaysNum = {"0", "1", "2", "3", "4", "5", "6"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0){
            w = 0;
        }
        String week = "";
        if(type.equals("cn")){
        	week = weekDaysCn[w];
        }
        if(type.equals("num")){
        	week = weekDaysNum[w];
        }
        return week;
    }
	
	/**
	 * 获取与今天时间相差n天的String形式时间
	 * */
	public static String getdate(int n,String format){
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_MONTH,n);
		String d=sdf.format(c.getTime());
		return d;
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			smdate = sdf.parse(sdf.format(smdate));
			bdate = sdf.parse(sdf.format(bdate));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		int dayDiff = Integer.parseInt(String.valueOf(between_days));
		return dayDiff;
	}
	
	// 根据日期获取星期
	public static String getWeekOfDate(Date dt) {
		String[] weekDays = { "0", "1", "2", "3", "4", "5", "6" };// 周日--周六
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}
	
	// 计算两个日期时间差 小时
	public static long getTimeInHours(Date start_date, Date end_date) {

		long hours = 0;
		long diff = end_date.getTime() - start_date.getTime();
		if (diff > 0) {
			hours = diff / (1000 * 60 * 60);
		}
		return hours;
	}

	public static void main(String[] args) {

		Date d1 = DateUtil.getDate("2016-01-14 09:01:00", DateUtil.DATE_TIME_FORMAT);
		Date d2 = DateUtil.getDate("2016-01-15 10:50:00", DateUtil.DATE_TIME_FORMAT);
	
	}
	
}

