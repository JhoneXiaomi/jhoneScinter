package com.scinter.www.util;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;

public class SendEmailUtil {
    
	private static Logger logger = Logger.getLogger(SendEmailUtil.class);
	
	public static void sendEmail(String host,int port,String username,String password,String fromEmail,String toEmail,String subject,String content) throws EmailException{
		logger.info("===============================send email start===============================");
		Email email = new SimpleEmail();
        email.setSSLOnConnect(true);
        email.setHostName(host);
        email.setSmtpPort(port);
        email.setAuthentication(username, password);
        email.setFrom(fromEmail);
        email.addTo(toEmail);
        email.setSubject(subject);
        email.setMsg(content);
        email.send();
        logger.info("===============================send email end==================================");
	}
	
    public static void main(String[] args) {
        boolean isSSL = true;
        String host = "smtp.126.com";
        int port = 25;
        String from = "sandisk_pkgwarp@126.com";
        String toEmail = "330838474@qq.com";
        String username = "sandisk_pkgwarp@126.com";
        String password = "pkgwarp";

        try {
            Email email = new SimpleEmail();
            email.setSSLOnConnect(isSSL);
            email.setHostName(host);
            email.setSmtpPort(port);
            email.setAuthentication(username, password);
            email.setFrom(from);
            email.addTo(toEmail);
            email.setSubject("主题1111111111111111111111111");
            email.setMsg("内容1111111111111111111111");
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }

        System.out.println("发送完毕！");
    }
    
    
    
}