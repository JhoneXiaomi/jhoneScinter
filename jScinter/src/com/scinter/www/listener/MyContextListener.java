package com.scinter.www.listener;

import java.util.Date;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MyContextListener implements ServletContextListener {

    //服务器启动时调用
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        ApplicationConstants.START_DATE = new Date();//记录启动时间
    }

    //服务停止时调用
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        //清空结果也可以保存
        ApplicationConstants.START_DATE = null;
        ApplicationConstants.MAX_ONLINE_COUNT_DATE = null;
    }
}