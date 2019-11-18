package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Model;

import java.util.List;

public interface ModelService {
    List<Model> selectModelsById(Integer aid);
}
