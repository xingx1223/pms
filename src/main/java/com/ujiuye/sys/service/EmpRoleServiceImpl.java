package com.ujiuye.sys.service;

import com.ujiuye.sys.mapper.EmpRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpRoleServiceImpl implements EmpRoleService {

    @Autowired
    private EmpRoleMapper empRoleMapper;

    @Override
    public Integer saveInfo(Integer eid, String roleid) {
       int i= empRoleMapper.saveInfo(eid,roleid);
        return i;
    }
}
