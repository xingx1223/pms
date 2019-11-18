package com.ujiuye.sys.service;

import com.ujiuye.sys.bean.Sources;

import java.util.List;

public interface SourcesService {
    List<Sources> getSourcesByPid(int i);

    boolean addSources(Sources sources);

    Sources getOneById(Integer id);

    boolean updateInfo(Sources sources);

    boolean deleteInfo(Integer id);

    List<Sources> selectSourceList(Integer eid);
}
