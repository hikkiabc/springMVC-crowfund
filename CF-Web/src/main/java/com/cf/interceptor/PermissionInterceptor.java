package com.cf.interceptor;

import com.cf.beans.Permission;
import com.cf.dao.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PermissionInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Set allUrls = (Set) request.getSession().getServletContext().getAttribute("allUrls");

        String servletPath = request.getServletPath();
        HttpSession session = request.getSession();
//        if (session.getAttribute("user")==null) return true;
//        Set allUrls = (Set) permissionUrlsMap.get("allUrls");
//        if (allUrls.contains(servletPath)){
//            Map permissionUrlsMap = (Map) session.getAttribute("permissionUrlsMap");
//            Set currentUserUrls = (Set) permissionUrlsMap.get("currentUserUrls");
//
//            if (currentUserUrls.contains(servletPath)) return true;
//            else {
//                response.sendRedirect(request.getContextPath()+"/gotologin");
//                return false;
//            }
//        }
        return true;
    }
}
