package com.cf.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String servletPath = request.getServletPath();
//        StringBuffer requestURL = request.getRequestURL();
//        System.out.println(requestURL);
        HttpSession session = request.getSession();
        Set<String> whiteList = new HashSet<>();
        whiteList.add("/gotologin");
        whiteList.add("/index");
        whiteList.add("/login");
        whiteList.add("/logout");
        Object user = session.getAttribute("user");
//        System.out.println(user);
        if(whiteList.contains(servletPath)) return true;
        if(user!=null) return true;
        else {
            response.sendRedirect(request.getContextPath()+"/gotologin");
            return false;
        }
//        return super.preHandle(request, response, handler);
    }
}
