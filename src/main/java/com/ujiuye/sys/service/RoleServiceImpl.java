package com.ujiuye.sys.service;

import com.ujiuye.sys.bean.Role;
import com.ujiuye.sys.bean.RoleExample;
import com.ujiuye.sys.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements  RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Integer saveInfo(Role role) {
       roleMapper.insertRole(role);
       return role.getRoleid();
    }

    @Override
    public List<Role> getJsonList() {
        RoleExample example=new RoleExample();
        return roleMapper.selectByExample(example);
    }
}
