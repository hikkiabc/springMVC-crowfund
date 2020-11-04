package com.cf.service.imp;

import com.cf.beans.Permission;
import com.cf.dao.PermissionMapper;
import com.cf.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
//    public PermissionServiceImpl() {
//    }

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> queryPermissions() {

        List<Permission> permissionList = permissionMapper.queryPermissions();
//                queryPermissions(permissionList);
//        List<Permission> resList = queryPermissions(permissionList);
        List<Permission> resList = getResList(permissionList,null);


        return resList;
    }

    @Override
    public int insert(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public Permission queryPermissionById(Integer id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Permission permission) {
        return permissionMapper.updateByPrimaryKey(permission);
    }

    @Override
    public List<Permission> queryPermissionsWithRoleId(Integer roleId) {
        List<Permission> permissionList = permissionMapper.queryPermissions();

       List<Integer> permissionIds= permissionMapper.queryPermissionIdByRoleId(roleId);
        List<Permission> resList = getResList(permissionList,permissionIds);


        return resList;
    }

    // method 4: sql 1 time， 循环size+size ，good efficiency
    public List<Permission> getResList(List<Permission> permissionList, List<Integer> permissionIds) {
        HashMap<Integer, Permission> map = new HashMap<>();
        ArrayList<Permission> list = new ArrayList<>();
        for (Permission permission : permissionList) {
            if(permissionIds!=null){
                if (permissionIds.contains(permission.getId())){
                    permission.setChecked(true);
                }
            }
            map.put(permission.getId(), permission);
        }
        for (Permission permission : permissionList) {
            if (permission.getPid() != null) {
                if (map.get(permission.getPid()).getChildren() == null) {
                    map.get(permission.getPid()).setChildren(new ArrayList<Permission>());
                }
                map.get(permission.getPid()).getChildren().add(permission);
            }else {
                list.add(permission);
            }
        }
        return list;
    }
}

//method1(get all data one time): 循环size*size low efficiency
//    private List<Permission> getResList(List<Permission> permissionList) {
//        for (Permission permission : permissionList) {
////            ArrayList<Permission> tempList = new ArrayList<>();
//            for (Permission permission1 : permissionList) {
//                if(permission1.getPid()==permission.getId()){
//                    if(permission.getChildren()==null){
//                        permission.setChildren(new ArrayList<Permission>());
//                    }
//                    permission.getChildren().add(permission1);
//                        break;
//                }
//            }
//        }
//        ArrayList<Permission> list = new ArrayList<>();
//        for (Permission permission : permissionList) {
////
//            if(permission.getPid()==null) list.add(permission);
//        }
//        return list;
//    }
// method 2(get data multi times)递归1 low efficiency
    //    private List<Permission> queryPermissions(List<Permission> list) {
//        for (Permission permission : list) {
//            List<Permission> permissionList = permissionMapper.queryPermissions(permission.getId());
//            if(permissionList.size()!=0){
//                queryPermissions(permissionList);
//                permission.setChildren(permissionList);
//            }
//
//        }
//            return list;
//    }
 //method 3(get data multi times) 递归2 low efficiency
//private void queryPermissions(List<Permission> list){
//    for (Permission permission : list) {
//                    List<Permission> permissionList = permissionMapper.queryPermissions(permission.getId());
//                    if (permissionList.size()!=0) {
//                        permission.setChildren(permissionList);
//                        queryPermissions(permissionList);
//                    }
//    }
//}
//}
