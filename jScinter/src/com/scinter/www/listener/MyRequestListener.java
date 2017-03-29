package com.scinter.www.listener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MyRequestListener implements ServletRequestListener{

    //销毁request时调用
    public void requestDestroyed(ServletRequestEvent arg0) {
        // TODO Auto-generated method stub
       
    }

    //创建request时调用
    public void requestInitialized(ServletRequestEvent requestEvent) {
        // TODO Auto-generated method stub
        HttpServletRequest request = (HttpServletRequest)requestEvent.getServletRequest();
        HttpSession session = request.getSession(true);
        session.setAttribute("ip",request.getRemoteAddr());
        String uri =  request.getRequestURI();
        String [] prefix = {".html",".do" ,".jsp",".action",""};
       
        for(int i=0;i<prefix.length;i++){
            if(uri.endsWith(prefix[i])){//如果是制定的后缀
                break;
            }
            if(i==prefix.length-1){
                return;
            }
        }
        Integer activityTimes = (Integer)session.getAttribute("activityTimes");
        if(activityTimes==null){
            activityTimes=0;
        }
        session.setAttribute("activityTimes", activityTimes+1);//更新访问次数
    }

}
