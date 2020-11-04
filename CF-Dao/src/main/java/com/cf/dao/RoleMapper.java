package com.cf.dao;

import com.cf.beans.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
    int deleteByPrimaryKey( Integer roleId);

    int insert(Role record);

    Role selectByPrimaryKey(Integer roleId);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    List<Role> queryRolesByPageAndKeywords(Map<String, Object> map);

    Integer queryTotalCount(Map<String, Object> map);

    Integer updateRolePermissionByRoleId(Map map);

    int deleteRolePermissionsByRoleId(Integer roleId);
}