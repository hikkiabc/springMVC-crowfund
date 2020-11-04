package com.cf.controller;

import com.cf.beans.Permission;
import com.cf.service.PermissionService;
import com.cf.service.UserService;
import com.cf.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@RequestMapping("/permission")
@Controller
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @RequestMapping("/toIndex")
    public String toIndex(){

        return "/permission/index";
    }
    @RequestMapping("/getData")
    @ResponseBody
    public Object getData(){
        Map map = Utils.resMap();
        try {
            List<Permission> permissionList= permissionService.queryPermissions();
            map.put("res",permissionList);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("res","failed");
        }
        return map;
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "/permission/add";
    }
    @RequestMapping("/add")
    @ResponseBody
    public Object add(Permission permission){
        Map map = Utils.resMap();
        try {
            int i= permissionService.insert(permission);
            map.put("res",i==1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("res","fail");
        }
        return  map;
    }
    @RequestMapping("/toUpdate")
    public String toUpdata(Integer id,Map map){

      Permission permission=  permissionService.queryPermissionById(id);

      map.put("permission",permission);
      return "/permission/update";
    }
    @RequestMapping("/update")
    @ResponseBody
    public Object update(Permission permission){
        System.out.println(permission);
        Map map = Utils.resMap();
        try {
            int i=   permissionService.update(permission);
            map.put("res",i==1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("res","fail");
        }
        return map;
    }
}
