package com.ujiuye.sys.controller;

import com.ujiuye.comm.ResultEntity;
import com.ujiuye.sys.bean.Role;
import com.ujiuye.sys.bean.RoleSources;
import com.ujiuye.sys.service.RoleService;
import com.ujiuye.sys.service.RoleSourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleSourcesService roleSourcesService;

    @ResponseBody
    @RequestMapping(value = "/jsonList",method = RequestMethod.GET)
    public List<Role> getJsonList(){
        return roleService.getJsonList();
    }

    @ResponseBody
    @RequestMapping(value = "saveInfo",method = RequestMethod.POST)
    public ResultEntity saveInfo(Role role,String ids){
        //向角色表中添加数据，返回该角色的id
        Integer roleid=roleService.saveInfo(role);
        System.out.println(roleid);
        //2.将角色和权限对应的关系添加到中间表中
        roleSourcesService.saveInfo(roleid,ids);
        return  ResultEntity.success();
    }
}
