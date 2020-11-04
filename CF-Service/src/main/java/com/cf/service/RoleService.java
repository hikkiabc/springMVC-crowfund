package com.cf.service;

import com.cf.beans.Page;

import java.util.Map;

public interface RoleService {
    Page queryRolesByPage(Map<String, Object> map);

    Integer updateRolePermissionByRoleId(Map map);
}
