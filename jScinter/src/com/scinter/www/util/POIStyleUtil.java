package com.scinter.www.util;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddressList;

/**
 * @author conrad.liu
 * POI操作excel样式辅助类
 * 
 */
public  class POIStyleUtil {

	/**
	 * @param workbook
	 * @category 获取标题字体
	 * @return
	 */
	public static HSSFFont getTitleFont(HSSFWorkbook workbook) {
		// 生成字体
		HSSFFont font = workbook.createFont();
		// 字体颜色
		font.setColor(HSSFColor.BLACK.index);
		// 字体高度
		font.setFontHeightInPoints((short) 16);
		// 字体类型 微软雅黑
		font.setFontName("Microsoft YaHei");
		//设置中文字体，那必须还要再对单元格进行编码设置
		font.setCharSet(HSSFFont.DEFAULT_CHARSET);  
		// 字体宽度
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		return font;
	}

	public static HSSFFont getTitleFont11(HSSFWorkbook workbook) {
		// 生成字体
		HSSFFont font = workbook.createFont();
		// 字体颜色
		font.setColor(HSSFColor.BLACK.index);
		// 字体高度
		font.setFontHeightInPoints((short) 11);
		// 字体类型 微软雅黑
		font.setFontName("Microsoft YaHei");
		//设置中文字体，那必须还要再对单元格进行编码设置
		font.setCharSet(HSSFFont.DEFAULT_CHARSET);  
		// 字体宽度
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		return font;
	}
	
	public static HSSFFont getTitleFont10(HSSFWorkbook workbook) {
		// 生成字体
		HSSFFont font = workbook.createFont();
		// 字体颜色
		font.setColor(HSSFColor.BLACK.index);
		// 字体高度
		font.setFontHeightInPoints((short) 10);
		// 字体类型 微软雅黑
		font.setFontName("Microsoft YaHei");
		//设置中文字体，那必须还要再对单元格进行编码设置
		font.setCharSet(HSSFFont.DEFAULT_CHARSET);  
		// 字体宽度
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		return font;
	}
	
	/**
	 * @param workbook
	 * @category 获取正文字体
	 * @return
	 */
	public static HSSFFont getContentFont11(HSSFWorkbook workbook) {
		// 生成字体
		HSSFFont font = workbook.createFont();
		// 字体颜色
		font.setColor(HSSFColor.BLACK.index);
		// 字体高度
		font.setFontHeightInPoints((short) 11);
		// 字体类型
		font.setFontName("Microsoft YaHei");
		//设置中文字体，那必须还要再对单元格进行编码设置
		font.setCharSet(HSSFFont.DEFAULT_CHARSET);
		// 字体宽度
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		return font;
	}
	
	public static HSSFFont getContentFont10_5(HSSFWorkbook workbook) {
		// 生成字体
		HSSFFont font = workbook.createFont();
		// 字体颜色
		font.setColor(HSSFColor.BLACK.index);
		// 字体高度
		font.setFontHeightInPoints((short) 10.5);
		// 字体类型
		font.setFontName("Microsoft YaHei");
		// 字体宽度
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		return font;
	}
	
	public static HSSFFont getContentFontWhite(HSSFWorkbook workbook) {
		// 生成字体
		HSSFFont font = workbook.createFont();
		// 字体颜色
		font.setColor(HSSFColor.WHITE.index);
		// 字体高度
		font.setFontHeightInPoints((short) 11);
		// 字体类型
		font.setFontName("Microsoft YaHei");
		// 字体宽度
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		return font;
	}
	
	public static HSSFFont getContentFontGrey(HSSFWorkbook workbook) {
		// 生成字体
		HSSFFont font = workbook.createFont();
		// 字体颜色
		font.setColor(HSSFColor.BROWN.index);
		// 字体高度
		font.setFontHeightInPoints((short) 11);
		// 字体类型
		font.setFontName("Microsoft YaHei");
		// 字体宽度
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		return font;
	}
	

	/**
	 * @param cellStyle
	 *            设置单元格样式
	 * @return
	 */
	public static HSSFCellStyle getCellStyle(HSSFCellStyle cellStyle) {
		// 设置样式
		cellStyle.setFillForegroundColor(HSSFColor.WHITE.index);// 背景色
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);// 填充图案
		// 水平居中对齐
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 垂直居中对齐
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 指定单元格自动换行
		cellStyle.setWrapText(true);
		//设置边框 实线黑细线
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		return cellStyle;
	}

	/**
	 * @param cellStyle
	 *  设置单元格样式
	 * @return
	 */
	public static HSSFCellStyle getCellStyleBGColor(HSSFCellStyle cellStyle,Short color) {
		// 设置样式
		cellStyle.setFillForegroundColor(color);// 背景色
																			// 25%灰色
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);// 填充图案
		// 水平居中对齐
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 垂直居中对齐
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 指定单元格自动换行
		cellStyle.setWrapText(true);
		return cellStyle;
	}

	// 自定义的方法,插入某个图片到指定索引的位置 图片固定大小
	public static void insertImage(HSSFWorkbook wb, HSSFPatriarch pa, byte[] data, int row, int column, int index) {
		int x1 = 0;
		int y1 = 0;
		int x2 = 1023;
		int y2 = 255;
		HSSFClientAnchor anchor = new HSSFClientAnchor(x1, y1, x2, y2, (short) column, row, (short) column, row);
		anchor.setAnchorType(2);
		pa.createPicture(anchor, wb.addPicture(data, HSSFWorkbook.PICTURE_TYPE_JPEG));
	}
	
	//插入图片可以设置图片缩放大小
	public static void insertImageSize(HSSFWorkbook wb, HSSFPatriarch pa, byte[] data, int row, int column, int index,float size) {
		int x1 = 10;
		int y1 = 10;
		int x2 = 1023;
		int y2 = 255;
		HSSFClientAnchor anchor = new HSSFClientAnchor(x1, y1, x2, y2, (short) column, row, (short) column, row);
		anchor.setAnchorType(2);
		pa.createPicture(anchor, wb.addPicture(data, HSSFWorkbook.PICTURE_TYPE_PNG)).resize(size);
	}

	// 从图片里面得到字节数组
	public static byte[] getImageByteData(String imagePath) {
		try {
			BufferedImage bi = ImageIO.read(new File(imagePath));
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			ImageIO.write(bi, "PNG", bout);
			return bout.toByteArray();
		} catch (Exception exe) {
			exe.printStackTrace();
			return null;
		}
	}

	// excel设置下拉列表
	 /** 
     * 设置某些列的值只能输入预制的数据,显示下拉框. 
     * @param sheet 要设置的sheet. 
     * @param textlist 下拉框显示的内容 
     * @param firstRow 开始行 
     * @param endRow 结束行 
     * @param firstCol   开始列 
     * @param endCol  结束列 
     * @return 设置好的sheet. 
     */  
	public static HSSFSheet setHSSFValidation(HSSFSheet sheet, String[] textlist, int firstRow, int endRow, int firstCol, int endCol) {
		// 加载下拉列表内容
		DVConstraint constraint = DVConstraint.createExplicitListConstraint(textlist);
		// 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
		CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
		// 数据有效性对象
		HSSFDataValidation data_validation_list = new HSSFDataValidation(regions, constraint);
		sheet.addValidationData(data_validation_list);
		return sheet;
	}

	/**
	 * 设置单元格内容为超链接
	 * @param wb 工作表对象
	 * @param cell单元格对象
	 * @param url链接地址 
	 */
	public static void setHSSFHyperlink(HSSFWorkbook wb,HSSFCell cell,String url) {
		HSSFCellStyle cellStyle = wb.createCellStyle();
		HSSFFont font = wb.createFont();
		// 字体下划线
		//font.setUnderline((byte) 1);
		// 字体高度
		font.setFontHeightInPoints((short) 10);
		// 字体类型
		font.setFontName("微软雅黑");
		// 字体颜色
		font.setColor(HSSFColor.BLUE.index);
		cellStyle.setFont(font);
		// 边框 实线黑细线
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		//默认居左
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		cell.setCellStyle(cellStyle);
		HSSFHyperlink link = cell.getHyperlink();
		link = new HSSFHyperlink(HSSFHyperlink.LINK_URL);
		link.setAddress(url);
		cell.setHyperlink(link);
		/*
		if (url.length() > 60) {
			url = url.substring(0, 50) + "...";
		}*/
		cell.setCellValue(url);
	}
	
}
