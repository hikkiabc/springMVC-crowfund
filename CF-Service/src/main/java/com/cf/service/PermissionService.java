package com.cf.service;

import com.cf.beans.Permission;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PermissionService {
    List<Permission> queryPermissions();

    int insert(Permission permission);

    Permission queryPermissionById(Integer id);

    int update(Permission permission);

    List<Permission> queryPermissionsWithRoleId(Integer roleId);
}
