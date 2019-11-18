package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Project;

import java.util.List;

public interface ProjectService {
    void saveInfo(Project project);

    List<Project> selectProList();

    boolean deletePro(Integer[] ids);

    Project proDetialById(Integer pid);

    boolean update(Project project);

    List<Project> searchProByKey(Integer cid, String keyword, Integer orderby);
}
