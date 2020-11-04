package com.cf.controller;

import com.cf.beans.Page;
import com.cf.beans.Permission;
import com.cf.service.PermissionService;
import com.cf.service.RoleService;
import com.cf.service.UserService;
import com.cf.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService   permissionService;
    @RequestMapping("/toRoleIndex")
    public String toRoleIndex(){
        return "/role/index";
    }
    @RequestMapping("/queryRolesByPage")
    @ResponseBody
    public Object queryRolesByPage(@RequestParam(value = "pageSize",required = false,defaultValue = "4") Integer pageSize,
                                  @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                   String keywords){
        Map<String , Object> map = new HashMap<>();

        map.put("pageSize",pageSize);
        map.put("pageNum",pageNum);
        if(!Utils.isEmpty(keywords)) {
            if (keywords.contains("%")) keywords= keywords.replaceAll("%", "\\\\%");
            map.put("keywords",keywords);

        }
        try {
          Page page=roleService.queryRolesByPage(map);
          map.put("res",page);

        } catch (Exception e) {
            map.put("res","fail");
            e.printStackTrace();
        }
            return map;
    }
    @RequestMapping("/toAssignPermission")
    public String   toAssignPermission(){
        return "/role/assignPermission";
    }
    @RequestMapping("/queryPermissions")
    @ResponseBody
    public Object queryPermissions(Integer roleId){
        Map map = Utils.resMap();
        try {
            List<Permission> permissionList = permissionService.queryPermissionsWithRoleId(roleId);
            map.put("res",permissionList);
            return permissionList;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("res","fail");
        }
        return map;
    }
    @RequestMapping("/updatePermission")
    @ResponseBody
    public Object updatePermission(@RequestBody Map map){
        Map resMap = Utils.resMap();
        try {
           Integer res= roleService.updateRolePermissionByRoleId(map);
            resMap.put("res",res);

        } catch (Exception e) {
            e.printStackTrace();
            resMap.put("res","fail");
        }

        return resMap;
    }
}
