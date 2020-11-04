package com.cf.controller;

import com.cf.beans.Page;
import com.cf.beans.Role;
import com.cf.beans.User;
import com.cf.service.UserService;
import com.cf.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    UserService userService;
    @ResponseBody
    @RequestMapping("/queryUserPages")
    public Object queryUserPages(@RequestParam(value = "pageNum",required = false,defaultValue = "1")
                                             Integer pageNum,@RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,String keywords){

        Map<String, Object> resMap = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);

            if(!Utils.isEmpty(keywords))
            {
                if (keywords.contains("%")) keywords= keywords.replaceAll("%", "\\\\%");
                map.put("keywords",keywords);
            }

        try {
            resMap.put("msg","before");
           Page page = userService.queryUserPages(map);
            resMap.put("sucess",true);
            resMap.put("res",page);
        } catch (Exception e) {
            e.printStackTrace();
            resMap.put("sucess",false);
        }
//        resMap.put("res",map1);
        return resMap;
    }
    @RequestMapping("/goUserIndex")
    public String goUserIndex(){
        return "user/index";
    }
    @RequestMapping("/toUpdate")
    public String toUpdate(){
        return "/user/update";
    }
    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(User user){
        HashMap<String, Object> map = new HashMap<>();
        try {
            int insert = userService.insert(user);
            map.put("success",insert==1);
        } catch (Exception e) {
            map.put("msg","fail");
            e.printStackTrace();
        }
        return map;
    }
    @RequestMapping("/toEdit")
    public String edit(String id,Map map){
        User user = userService.queryById(id);
        map.put("user", user);
        return "user/edit";
    }
    @ResponseBody
    @RequestMapping("/edit")
    public Object edit(User user){
        HashMap<String, Object> map = new HashMap<>();
        try {
            int edit = userService.edit(user);
            map.put("success",edit==1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","edit failed");
        }
        return  map;
    }
    @ResponseBody
    @RequestMapping("/deleteUser")
    public Object deleteUser(Integer id){
        Map resMap = Utils.resMap();
        try {
            int i = userService.deleteUser(id);
            resMap.put("success",i==1);
        } catch (Exception e) {
            e.printStackTrace();
            resMap.put("msg","delete failed");
        }
        return resMap;
    }
    @RequestMapping("/deleteBatchUser")
    @ResponseBody
    public Object deleteBatchUser(Integer[] id){

        Map map = Utils.resMap();
        try {
            int i = userService.deleteBatchUsers(id);

            map.put("res",i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
    @RequestMapping("/roleAssign")
    public String roleAssign(Integer id,Map map){

       List<Integer> roleIds= userService.queryUserRoleIdByUserId(id);
      List<Role> roles= userService.queryAllRoles();
        List<Role> notHaveRoles = new ArrayList<>();

        List<Role> haveRoles = new ArrayList<>();

        for (Role role : roles) {
            if(roleIds.contains(role.getRoleId())){
                haveRoles.add(role);
            }else notHaveRoles.add(role);
        }
        map.put("notHave",notHaveRoles);
        map.put("have",haveRoles);
        map.put("userId",id);
        return "user/role_assign";
    }
    @ResponseBody
    @RequestMapping("/confirmAssign")
    public Object confirmAssign(@RequestBody Map map){
        Map resMap = Utils.resMap();

        try {
            int res= userService.insertBatch(map);

            resMap.put("res",res);
        } catch (Exception e) {
            e.printStackTrace();

            resMap.put("res","fails");
        }

        return resMap;
    }
    @ResponseBody
    @RequestMapping("deleteRoles")
    public Object deleteRoles(@RequestBody Map map){
        Map resMap = Utils.resMap();

        try {
            int res=  userService.deleteRoles(map);

            resMap.put("res",res);
        } catch (Exception e) {
            e.printStackTrace();
     
            resMap.put("res","fail");
        }
        return resMap;
    }
}
