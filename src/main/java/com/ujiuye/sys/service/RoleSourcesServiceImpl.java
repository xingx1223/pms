package com.ujiuye.sys.service;

import com.ujiuye.sys.mapper.RoleSourcesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleSourcesServiceImpl implements RoleSourcesService {


    @Autowired
    private RoleSourcesMapper roleSourcesMapper;

    @Override
    public void saveInfo(Integer roleid, String ids) {
        String[] idArr = ids.split(",");
        for (String s : idArr) {
            roleSourcesMapper.insert(roleid, Integer.parseInt(s));
        }
    }
}
