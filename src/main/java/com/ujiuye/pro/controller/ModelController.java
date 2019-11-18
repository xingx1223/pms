package com.ujiuye.pro.controller;

import com.ujiuye.pro.bean.Model;
import com.ujiuye.pro.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "model")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @ResponseBody
    @RequestMapping(value = "selectModelsById/{aid}",method = RequestMethod.GET)
    public List<Model> selectModelsById(@PathVariable(value = "aid") Integer aid){
        List<Model> models=modelService.selectModelsById(aid);
        return models;
    }

}
