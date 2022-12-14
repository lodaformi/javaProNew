package com.loda.onlinePerson;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author loda
 * @Date 2022/10/31 8:56
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@WebListener
public class ListenOnline implements HttpSessionListener {
    private Integer onlineNum = 0;
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ++onlineNum;
        httpSessionEvent.getSession().getServletContext().setAttribute("onlineNum", onlineNum);
//        httpSessionEvent.getSession().setAttribute("onlineNum", onlineNum);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        --onlineNum;
        httpSessionEvent.getSession().getServletContext().setAttribute("onlineNum", onlineNum);
//        httpSessionEvent.getSession().setAttribute("onlineNum", onlineNum);
    }
}
