package com.ujiuye.pro.controller;

import com.ujiuye.pro.bean.Function;
import com.ujiuye.pro.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "func")
public class FunctionController {

    @Autowired
    private FunctionService functionService;

    @ResponseBody
    @RequestMapping(value = "selectFuncsById/{mid}",method = RequestMethod.GET)
    public List<Function> selectFuncsById(@PathVariable(value = "mid")Integer mid){
        List<Function> funcs=functionService.selectFuncsById(mid);
        //System.out.println(funcs);
        return funcs;
    }
}
