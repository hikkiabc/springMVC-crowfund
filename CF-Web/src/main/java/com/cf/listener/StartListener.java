package com.cf.listener;

import com.cf.beans.Permission;
import com.cf.dao.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StartListener implements ServletContextListener {
//    @Autowired
//    PermissionMapper permissionMapper;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext application = servletContextEvent.getServletContext();
        String contextPath = application.getContextPath();
        application.setAttribute("contextPath", contextPath);

        ApplicationContext ioc = WebApplicationContextUtils.getWebApplicationContext(application);
        PermissionMapper permissionMapper = ioc.getBean(PermissionMapper.class);
        List<Permission> permissionList = permissionMapper.queryPermissions();
        Set<String> allUrls = new HashSet<>();
        for (Permission permission : permissionList) {
            if (permission.getUrl() != null) allUrls.add(permission.getUrl());
        }
        application.setAttribute("allUrls", allUrls);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
