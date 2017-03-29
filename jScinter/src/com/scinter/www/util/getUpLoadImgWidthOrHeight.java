package com.scinter.www.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

public class getUpLoadImgWidthOrHeight {

	Logger logger = Logger.getLogger(getUpLoadImgWidthOrHeight.class);
	private static final String CONTENT_TYPE = "text/html;charset=UTF-8";  
	
	/**
	 * 解决图片的上传无法获取图片的宽和高度的问题
	 * 
	 * @author JhoneZhang
	 * @date   2016年10月15日上午9:06:35
	 * @param request
	 * @param response
	 * @param path
	 */
	public void getUploadImgWH(HttpServletRequest request, HttpServletResponse response,String path){
			response.setContentType(CONTENT_TYPE);  
			   try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}  
		   File file = new File(path);  
		   if (!file.exists()) {  
		    file.mkdir();  
		   } else {  
		    DiskFileItemFactory factory = new DiskFileItemFactory();  
		  
		    factory.setRepository(new File(path));  
		  
		    //factory.setSizeThreshold(1024 * 1024);  
		  
		    ServletFileUpload sfu = new ServletFileUpload(factory);  
		     
		    try {  
		     List<FileItem> _cache=sfu.parseRequest(request);  
		     for(FileItem item :_cache) {  
		      if(!item.isFormField()) {  
		       String name=item.getFieldName();  
		       String filedValue=item.getName();  
		       int start=filedValue.lastIndexOf("\\");  
		       String value=filedValue.substring(start+1);  
		       request.setAttribute(name, value);  
		       OutputStream os=new FileOutputStream(new File(path,value));  
		        
		       InputStream iis=item.getInputStream();  
		       BufferedImage bi=ImageIO.read(iis);  
		       int width=bi.getWidth();  
		        
		       int height=bi.getHeight();  
		        
		       System.out.println("width="+width);  
		       System.out.println("height="+height);  
		        
		       iis.close();  
		       os.close();  
		      }  
		     }  
		    } catch (Exception e) {  
		     System.out.println(e.getMessage());  
		     e.printStackTrace();  
		    }  
		  
		   }  
	}
}
