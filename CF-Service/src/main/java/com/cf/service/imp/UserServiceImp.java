package com.cf.service.imp;

import com.cf.beans.Page;
import com.cf.beans.Permission;
import com.cf.beans.Role;
import com.cf.beans.User;
import com.cf.dao.PermissionMapper;
import com.cf.dao.UserMapper;
import com.cf.exception.LoginFailException;
import com.cf.service.UserService;
import com.cf.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper usermapper;
    @Autowired
PermissionMapper permissionMapper;
  PermissionServiceImpl permissionServiceImp= new PermissionServiceImpl();


    @Override
    public User login(Map<String, Object> map) {
        User user = usermapper.login(map);

        if(user==null){
            throw new LoginFailException("Username and Password don't Match");
        }

        return user;
    }

    @Override
    public int insert(User user) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-YYYY HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        user.setCreatetime(date);
        user.setPassword(Md5.md52("2"));
        int res = usermapper.insert(user);
        return res;
    }

    @Override
    public User queryById(String id) {
        Integer integer = Integer.valueOf(id);
        User user = usermapper.selectByPrimaryKey(integer);
        return user;
    }

    @Override
    public int edit(User user) {
        int i = usermapper.updateByPrimaryKey(user);
        return i;
    }

    @Override
    public int deleteUser(Integer id) {
        int i = usermapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int deleteBatchUsers(Integer[] id) {
        int i = usermapper.deleteGroupById(id);

        return i;
    }

    @Override
    public List<Integer> queryUserRoleIdByUserId(Integer id) {

        return   usermapper.queryUserRoleIdByUserId(id);
    }

    @Override
    public List<Role> queryAllRoles() {
        return usermapper.queryAllRoles();
    }

    @Override
    public int insertBatch(Map map) {


        return  usermapper.insertBatch(map);
    }

    @Override
    public int deleteRoles(Map map) {

        int i = usermapper.deleteRoles(map);

        return i;
    }

    @Override
    public List<Permission> queryPermissionsByUserId(Integer id) {
       List<Permission> allPermissions=usermapper.queryPermissionsByUserId(id);
        List<Permission> resList = permissionServiceImp.getResList(allPermissions, null);
        return resList;
    }

    @Override
    public Map<String, Object> queryPermissionsUrls(Integer userId) {
        List<Permission> permissionList = permissionMapper.queryPermissions();
        List<Permission> permissionListForCurrentUser = usermapper.queryPermissionsByUserId(userId);
        HashMap<String, Object> map = new HashMap<>();
        HashSet<String> allUrls = new HashSet<>();
        HashSet<String> currentUserUrls = new HashSet<>();
        for (Permission permission : permissionList) {
            if (permission.getUrl()!=null) allUrls.add(permission.getUrl());
        }
        for (Permission permission : permissionListForCurrentUser) {
            if(permission.getUrl()!=null) currentUserUrls.add(permission.getUrl());
        }
        map.put("allUrls", allUrls);
        map.put("currentUserUrls",currentUserUrls);
        return map;
    }

    @Override
    public Page queryUserPages(Map map) {
        Integer currentPageNum= (Integer) map.get("pageNum");
       Integer pageSize= (Integer) map.get("pageSize");
       Integer pageNum= (Integer) map.get("pageNum");
        pageNum=pageSize*(pageNum-1);
        map.replace("pageNum",pageNum);
       List data= usermapper.queryUserPages(map);

       Integer totalCount =usermapper.queryTotalUser(map);

        Integer totalPage=((totalCount%pageSize)==0?(totalCount/pageSize):(totalCount/pageSize+1));
        if(pageSize>totalCount) pageSize=totalCount;
        Page page = new Page(currentPageNum, pageSize, totalCount, totalPage, data);

        return page;
    }

//    @Override
//    public void saveUser() {
//
//    }
}
