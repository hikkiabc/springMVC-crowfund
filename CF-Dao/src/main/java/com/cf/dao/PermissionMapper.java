package com.cf.dao;

import com.cf.beans.Permission;
import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Integer id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);

    List<Permission> queryPermissions();

//    List<Permission> queryPermissions(Integer pid);

    List<Integer> queryPermissionIdByRoleId(Integer roleId);
}