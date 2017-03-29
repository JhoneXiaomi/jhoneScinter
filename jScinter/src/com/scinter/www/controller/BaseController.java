package com.scinter.www.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import com.scinter.www.dao.SysConfigMapper;
import com.scinter.www.model.Role;
import com.scinter.www.model.SysConfigExample;
import com.scinter.www.model.SysConfigExample.Criteria;
import com.scinter.www.util.DateUtil;
import com.scinter.www.util.ImageMarkLogoByIcon;
import com.scinter.www.util.StringUtil;

/**
 * 
 * <p class="detail">
 * 功能：公共BaseController
 * </p>
 * 
 * @ClassName: BaseController
 * @version V1.0
 * @date 2016年6月20日
 * @author xun.liu
 */
@Controller
public class BaseController {
	
	@Autowired
	private SysConfigMapper sysConfigMapper;
	
	private String allowSuffix = "gif,jpg,jpeg,bmp,png,GIF,JPG,JPEG,BMP,PNG";//允许文件格式
	private long allowSize = 4L;// 允许文件大小2m
	private String fileName;
	private String[] fileNames;
	private String serverUploadFilePath;// 服务器端默认文件上传保存路径
	
	private void setFilePath() {
		// server_upload_file_path
		SysConfigExample cx = new SysConfigExample();
		Criteria criteria = cx.createCriteria();
		criteria.andKeyNameEqualTo("server_upload_file_path");
		serverUploadFilePath = sysConfigMapper.selectByExample(cx).get(0).getValue();
	}
	
	public String getAllowSuffix() {
		return allowSuffix;
	}

	public void setAllowSuffix(String allowSuffix) {
		this.allowSuffix = allowSuffix;
	}

	public long getAllowSize() {
		return allowSize * 1024 * 1024;
	}

	public void setAllowSize(long allowSize) {
		this.allowSize = allowSize;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String[] getFileNames() {
		return fileNames;
	}

	public void setFileNames(String[] fileNames) {
		this.fileNames = fileNames;
	}

	// 时间命名服务器端新文件
	private String getFileNameNew() {
		//SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		//String dateTimeStr = fmt.format(new Date());
		return StringUtil.getRandomString(8);
	}
	
	public void uploads(MultipartFile[] files,HttpServletRequest request) throws Exception {
		//String path = request.getContextPath();
		//String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
		setFilePath();
		try {
			fileNames = new String[files.length];
			int index = 0;
			for (MultipartFile file : files) {
				String suffix = file.getOriginalFilename().substring(
						file.getOriginalFilename().lastIndexOf(".") + 1);
				int length = getAllowSuffix().indexOf(suffix);
				if (length == -1) {
					throw new Exception("请上传允许格式的文件");
				}
				/*if (file.getSize() > getAllowSize()) {
					throw new Exception("您上传的文件大小已经超出范围");
				}*/
				//String realPath = request.getSession().getServletContext().getRealPath("/");
				File destFile = new File(serverUploadFilePath);
				if (!destFile.exists()) {
					destFile.mkdirs();
				}
				String fileNameNew = getFileNameNew() + "." + suffix;//
				File f = new File(destFile.getAbsoluteFile() + "\\"
						+ fileNameNew);
				file.transferTo(f);
				f.createNewFile();
				fileNames[index++] = serverUploadFilePath + fileNameNew;
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String uploadToFileUrl(MultipartFile file,HttpServletRequest request,HttpSession session) throws Exception {
		
		// 获取分公司信息
		Role currentRole= (Role)session.getAttribute("Role");
		
		String branchCompany = "";
		String branchStr = "";
		if(currentRole.getRoleName().equals("超级管理员")){
			
			branchCompany = (String)session.getAttribute("controlledCompany");
			if(branchCompany.equals("xzzs"))
				branchStr = branchCompany.substring(0, 2);
			else if(branchCompany.equals("sczs"))
				branchStr = branchCompany.substring(0, 2);
			else if(branchCompany.equals("rbwzs2"))
				branchStr = "w2";
			else if(branchCompany.equals("rbwzs1"))
				branchStr = "w1";
			else if(branchCompany.equals("rrlzs"))
				branchStr = "rl";
			else 
				branchStr = "sc";
		}
		else
		{
			branchCompany = currentRole.getBranchCompany(); 
			branchStr = branchCompany.substring(branchCompany.length()-2,branchCompany.length());
		}
			
	
		
		setFilePath();
		String fileUrl = "";
		try {
			String suffix = file.getOriginalFilename().substring(
					file.getOriginalFilename().lastIndexOf(".") + 1);
			int length = getAllowSuffix().indexOf(suffix);
			if (length == -1) {
				throw new Exception("请上传允许格式的文件");
			}
			if (file.getSize() > getAllowSize()) {
				throw new Exception("您上传的文件大小已经超出范围");
			}
			System.out.println("上传文件的大小为："+file.getSize()+"上传文件的允许的大小为："+getAllowSize());
			// 格式化的年月日
			String nowDateTimeDir = DateUtil.getStr(new Date(), DateUtil.DATE_FORMAT_DIR);
			// 根据年月日和taskId创建文件夹
			String path = serverUploadFilePath + nowDateTimeDir + "/";
			File destFile = new File(path);
			if (!destFile.exists()) {
				destFile.mkdirs();
			}
			String fileNameNewStr = getFileNameNew();
			String fileNameNew = fileNameNewStr + "." + suffix;
			File f = new File(destFile.getAbsoluteFile() + "/" + fileNameNew);
			file.transferTo(f);
			f.createNewFile();
			//添加图片水印 位置图片中间
			String fileNameNewWithLogo = fileNameNewStr + "_logo." + suffix;
			String logoPath = null;
			System.out.println(branchCompany);
			if(branchCompany.equals("sjzsc")){
				logoPath = request.getServletContext().getRealPath("/")+"\\static\\www\\images\\scinter_logo_sjz.png";
			}else if(branchCompany.equals("bdrbw1")){
				logoPath = request.getServletContext().getRealPath("/")+"\\static\\www\\images\\rbwzs_logo_bd.png";
			}else{
				if(branchStr.equals("sc")){
					logoPath = request.getServletContext().getRealPath("/")+"\\static\\www\\images\\scinter_logo.png";
				}else if(branchStr.equals("xz")){
					logoPath = request.getServletContext().getRealPath("/")+"\\static\\www\\images\\xzzs_logo.png";
				}else if(branchStr.equals("w1")){
					logoPath = request.getServletContext().getRealPath("/")+"\\static\\www\\images\\rbwzs_logo.png";
				}else if(branchStr.equals("w2")){
					logoPath = request.getServletContext().getRealPath("/")+"\\static\\www\\images\\rbwzs_logo.png";
				}else if(branchStr.equals("rl")){
					logoPath = request.getServletContext().getRealPath("/")+"\\static\\www\\images\\rrl_logo.png";
				}
			}
			
			String targetFileWithLogoPath = destFile.getAbsoluteFile() + "/" + fileNameNewWithLogo;
			ImageMarkLogoByIcon.markImageByIcon(logoPath, f.getPath(), targetFileWithLogoPath);
			
			fileUrl =  nowDateTimeDir +"/" +fileNameNew;
		} catch (Exception e) {
			throw e;
		}
		return fileUrl;
	}
	
	public String uploadToFilePath(MultipartFile file,HttpServletRequest request) throws Exception {
		setFilePath();
		String filePath = "";
		//String path = request.getContextPath();
		//String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
		try {
			String suffix = file.getOriginalFilename().substring(
					file.getOriginalFilename().lastIndexOf(".") + 1);
			int length = getAllowSuffix().indexOf(suffix);
			if (length == -1) {
				throw new Exception("请上传允许格式的文件");
			}
			if (file.getSize() > getAllowSize()) {
				throw new Exception("您上传的文件大小已经超出范围");
			}
			
			// 格式化的年月日
			String nowDateTimeDir = DateUtil.getStr(new Date(), DateUtil.DATE_FORMAT_DIR);
			// 根据年月日和taskId创建文件夹
			String path = serverUploadFilePath + nowDateTimeDir + "/";
			
			
			//String realPath = request.getSession().getServletContext().getRealPath("/");
			File destFile = new File(path);
			if (!destFile.exists()) {
				destFile.mkdirs();
			}
			String fileNameNewStr = getFileNameNew();
			String fileNameNew = fileNameNewStr + "." + suffix;
			File f = new File(destFile.getAbsoluteFile() + "/" + fileNameNew);
			file.transferTo(f);
			f.createNewFile();
			
			//添加图片水印
			String fileNameNewWithLogo = fileNameNewStr + "_logo." + suffix;
			String logoPath = request.getServletContext().getRealPath("/")+"\\static\\www\\images\\logo.png";
			String targetFileWithLogoPath = destFile.getAbsoluteFile() + "/" + fileNameNewWithLogo;
			ImageMarkLogoByIcon.markImageByIcon(logoPath, f.getPath(), targetFileWithLogoPath);
			
			filePath =  path + fileNameNew;
		} catch (Exception e) {
			throw e;
		}
		return filePath;
	}
}