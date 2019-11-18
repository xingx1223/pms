package com.ujiuye.pro.controller;

import com.ujiuye.pro.bean.Analysis;
import com.ujiuye.pro.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/analysis")
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    @RequestMapping(value = "/addAnalysis",method = RequestMethod.POST)
    public String addAnalysis(Analysis analysis){
        boolean b = analysisService.addAnalysis(analysis);
        return "project-need";
    }

    @ResponseBody
    @RequestMapping(value = "/selectAnalById/{pid}",method = RequestMethod.GET)
    public Analysis selectAnalById(@PathVariable(value = "pid") Integer pid){
        Analysis analysis = analysisService.selectAnalById(pid);
        return analysis;
    }


    @RequestMapping(value = "/selectById/{pid}",method = RequestMethod.GET)
    public String selectById(@PathVariable(value = "pid") Integer pid,Map<String,Object> map){
        Analysis analysis = analysisService.selectAnalById(pid);
        map.put("analysis",analysis);
        return "project-need-look";
    }
    //selectAnaById
    @RequestMapping(value = "/selectAnaById/{pid}",method = RequestMethod.GET)
    public String selectAnaById(@PathVariable(value = "pid") Integer pid,Map<String,Object> map){
        Analysis analysis = analysisService.selectAnalById(pid);
        map.put("analysis",analysis);
        return "project-need-edit";
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ModelAndView selectAllAnalysis(){
        ModelAndView mv=new ModelAndView("project-need");
        List<Analysis> analyses=analysisService.selectAllAnalysis();
        mv.addObject("list",analyses);
        return mv;
    }

    //saveInfo
    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    public String selectById(Analysis analysis){
        boolean result=analysisService.saveInfo(analysis);
        return "redirect:/analysis/list";
    }
}
