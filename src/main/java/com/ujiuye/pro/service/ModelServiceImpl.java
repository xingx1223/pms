package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Model;
import com.ujiuye.pro.mapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Model> selectModelsById(Integer aid) {

       List<Model> models= modelMapper.selectModelsById(aid);
       return models;
    }
}
