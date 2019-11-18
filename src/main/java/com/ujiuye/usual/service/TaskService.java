package com.ujiuye.usual.service;

import com.github.pagehelper.PageInfo;
import com.ujiuye.usual.bean.Task;

import java.util.Map;

public interface TaskService {
    boolean addTask(Task task);

    PageInfo<Task> getList(Integer pageNum, Map<String, Object> parameterMap);
}
