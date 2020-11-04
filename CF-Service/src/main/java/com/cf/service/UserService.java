package com.cf.service;

import com.cf.beans.Page;
import com.cf.beans.Permission;
import com.cf.beans.Role;
import com.cf.beans.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User login(Map<String, Object> map);

//    Page queryUserPages(Integer pageNum, Integer pageSize);

//    void saveUser();

    Page queryUserPages(Map<String, Object> map);

    int insert(User user) throws Exception;

    User queryById(String id);

    int edit(User user);

    int deleteUser(Integer id);

    int deleteBatchUsers(Integer[] id);

    List<Integer> queryUserRoleIdByUserId(Integer id);

    List<Role> queryAllRoles();

    int insertBatch(Map map);

    int deleteRoles(Map map);

    List<Permission> queryPermissionsByUserId(Integer id);

    Map<String, Object> queryPermissionsUrls(Integer user);
}
