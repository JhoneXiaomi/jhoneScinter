package com.scinter.www.util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;

import org.apache.log4j.Logger;

import com.scinter.www.model.Role;

public class ImageMarkLogoByIcon {
	
	Logger logger = Logger.getLogger(ImageMarkLogoByIcon.class);
	/**
	 * @param args
	 */
	public static void main(String[] args,HttpSession session) {
		
		
		
//		获取分公司的信息
		Role currentRole= (Role)session.getAttribute("Role");
		String branchCompany = currentRole.getBranchCompany();
		String branchStr = branchCompany.substring(branchCompany.length()-2,branchCompany.length());
		String srcImgPath = "E:\\upload\\2016\\07\\05\\RdrSzO2d.jpg";
		String iconPath = null;
		String targerPath = "E:\\upload\\2016\\07\\05\\img_mark_icon.jpg";
		String targerPath2 = "E:\\upload\\2016\\07\\05\\img_mark_icon_rotate.jpg";
		
		if(branchStr=="sc"){
			iconPath = "E:\\upload\\2016\\07\\05\\scinter_logo.png";
		}else if(branchCompany == "xz"){
			iconPath = "E:\\upload\\2016\\07\\05\\xzzs_logo.png";
		}else if(branchCompany == "rbw"){
			iconPath = "E:\\upload\\2016\\07\\05\\rbwzs_logo.png";
		}
		// 给图片添加水印
		ImageMarkLogoByIcon.markImageByIcon(iconPath, srcImgPath, targerPath);
		// 给图片添加水印,水印旋转-45
		ImageMarkLogoByIcon.markImageByIcon(iconPath, srcImgPath, targerPath2,
				-45);

	}

	/**
	 * 给图片添加水印
	 * 
	 * @param iconPath
	 *            水印图片路径
	 * @param srcImgPath
	 *            源图片路径
	 * @param targerPath
	 *            目标图片路径
	 */
	public static void markImageByIcon(String iconPath, String srcImgPath,
			String targerPath) {
		markImageByIcon(iconPath, srcImgPath, targerPath, null);
	}

	/**
	 * 给图片添加水印、可设置水印图片旋转角度
	 * 
	 * @param iconPath
	 *            水印图片路径
	 * @param srcImgPath
	 *            源图片路径
	 * @param targerPath
	 *            目标图片路径
	 * @param degree
	 *            水印图片旋转角度
	 */
	public static void markImageByIcon(String iconPath, String srcImgPath,
			String targerPath, Integer degree) {
		OutputStream os = null;
		try {
			Image srcImg = ImageIO.read(new File(srcImgPath));

			BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),
					srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);

			// 得到画笔对象
			// Graphics g= buffImg.getGraphics();
			Graphics2D g = buffImg.createGraphics();

			// 设置对线段的锯齿状边缘处理
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
					RenderingHints.VALUE_INTERPOLATION_BILINEAR);

			g.drawImage(
					srcImg.getScaledInstance(srcImg.getWidth(null),
							srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0,
					null);

			if (null != degree) {
				// 设置水印旋转
				g.rotate(Math.toRadians(degree),
						(double) buffImg.getWidth() / 2,
						(double) buffImg.getHeight() /1.5);
			}

			// 水印图象的路径 水印一般为gif或者png的，这样可设置透明度
			ImageIcon imgIcon = new ImageIcon(iconPath);

			// 得到Image对象。
			Image img = imgIcon.getImage();
			Integer imgIconWidth = imgIcon.getIconWidth();
			Integer imgIconHeight = imgIcon.getIconHeight();
			System.out.println("the width of iconImg is:"+imgIconWidth+"the height of iconImg is:"+imgIconHeight);
			float alpha = 0.7f; // 透明度
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
					alpha));

			// 表示水印图片的位置
			g.drawImage(img, buffImg.getWidth()-imgIconWidth, buffImg.getHeight()-imgIconHeight, null);
			// g.drawImage(img, buffImg.getWidth() / 2, buffImg.getHeight() / 2, null);

			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));

			g.dispose();

			os = new FileOutputStream(targerPath);

			// 生成带水印logo的图片
			ImageIO.write(buffImg, "JPG", os);

			//System.out.println("图片完成添加Icon印章。。。。。。");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != os)
					os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
