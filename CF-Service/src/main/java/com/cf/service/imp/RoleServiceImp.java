package com.cf.service.imp;

import com.cf.beans.Page;
import com.cf.beans.Role;
import com.cf.dao.RoleMapper;
import com.cf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImp  implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public Page queryRolesByPage(Map<String, Object> map) {
        Integer pageNum= (Integer) map.get("pageNum");
        Integer pageSize= (Integer) map.get("pageSize");
        Integer skip=(pageNum-1)*pageSize;
        map.replace("pageNum",skip);
        List<Role> resList=roleMapper.queryRolesByPageAndKeywords(map);

        Integer totalCount=roleMapper.queryTotalCount(map);
        Integer totalPages=(totalCount%pageSize)==0?(totalCount/pageSize):(totalCount/pageSize+1);


        return         new Page(pageNum,pageSize,totalCount,totalPages,resList);
    }

    @Override
    public Integer updateRolePermissionByRoleId(Map map) {
//        int roleId = roleMapper.deleteByPrimaryKey(1);
        int roleId = roleMapper.deleteRolePermissionsByRoleId((Integer) map.get("roleId"));

//        System.out.println(roleId);
        return roleMapper.updateRolePermissionByRoleId(map);
    }
}
