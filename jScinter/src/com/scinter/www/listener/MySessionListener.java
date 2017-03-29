package com.scinter.www.listener;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class MySessionListener implements HttpSessionListener,
        HttpSessionAttributeListener {

    //session创建的时候调用
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        // TODO Auto-generated method stub
        //新创建的session
        HttpSession session = (HttpSession)sessionEvent.getSession();
       
        //保存session
        ApplicationConstants.SESSION_MAP.put(session.getId(),session);
        //历史访问人数++
        ApplicationConstants.TOTAL_HISTORY_COUNT++;
        
        //如果超过最大在线人数 更新 更新时间
        if(ApplicationConstants.SESSION_MAP.size()>
            ApplicationConstants.MAX_ONLINE_COUNT){
            //更新最大在线人数
            ApplicationConstants.MAX_ONLINE_COUNT = ApplicationConstants.SESSION_MAP.size();
            //更新日期
            ApplicationConstants.MAX_ONLINE_COUNT_DATE = new Date();
        }
    }

    //session销毁的时候调用
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        // TODO Auto-generated method stub
        //即将被销毁的session
        HttpSession session = sessionEvent.getSession();
        //从map中将sesion的索引删除
        ApplicationConstants.SESSION_MAP.remove(session.getId());
    }

    //添加属性的时候被调用
    public void attributeAdded(HttpSessionBindingEvent event) {
        //如果是user
        if(event.getName().equals("UserInfo")){
            //当前在线人数++
            ApplicationConstants.CURRENT_LOGIN_COUNT++;
            //得到session
            HttpSession session = event.getSession();
           
            //查询该账户有没有在别的机器上登录
            for(HttpSession sess:ApplicationConstants.SESSION_MAP.values()){
               
                if(event.getValue().equals(sess.getAttribute("UserInfo"))
                        &&sess.getId()!=session.getId()){
                    sess.invalidate();//销毁session
                }
            }
        }
    }

    //移除属性是被调用
    public void attributeRemoved(HttpSessionBindingEvent event) {
        // TODO Auto-generated method stub
        if(event.getName().equals("UserInfo")){
            ApplicationConstants.CURRENT_LOGIN_COUNT--;//当前用户总数--
           
        }
    }

    //修改的时候调用
    public void attributeReplaced(HttpSessionBindingEvent event) {
        // TODO Auto-generated method stub
        if(event.getName().equals("UserInfo"))
        {
            HttpSession session = event.getSession();
            //重新登录session
            for(HttpSession sess:ApplicationConstants.SESSION_MAP.values()){
               
                //如果新账号在其他机器上登录过，则一切的登录失效
                if(event.getValue().equals(sess.getAttribute("UserInfo"))
                        &&sess.getId()!=session.getId()){
                    sess.invalidate();
                }
            }
        }
    }
}
