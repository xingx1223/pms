package com.ujiuye.sys.mapper;

import org.apache.ibatis.annotations.Param;

public interface EmpRoleMapper {
    int saveInfo(@Param("eid") Integer eid, @Param("rid") String roleid);
}
