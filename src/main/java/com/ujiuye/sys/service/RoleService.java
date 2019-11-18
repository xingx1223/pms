package com.ujiuye.sys.service;

import com.ujiuye.sys.bean.Role;

import java.util.List;

public interface RoleService {
    Integer saveInfo(Role role);

    List<Role> getJsonList();
}
