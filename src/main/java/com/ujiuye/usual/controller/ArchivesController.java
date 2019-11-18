package com.ujiuye.usual.controller;

import com.ujiuye.pro.service.AnalysisService;
import com.ujiuye.usual.bean.Archives;
import com.ujiuye.usual.service.ArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "archives")
public class ArchivesController {

    @Autowired
    private ArchivesService archivesService;

    @RequestMapping(value = "selectAllArchives",method = RequestMethod.GET)
    public ModelAndView selectAllArchives(){
        ModelAndView mv=new ModelAndView("archives");
        List<Archives> list=archivesService.selectAllArchives();
        mv.addObject("list",list);
        return mv;
    }

    //selectById
    @RequestMapping(value = "selectById/{dnum}",method = RequestMethod.GET)
    public String selectById(@PathVariable(value = "dnum") String dnum, Map<String,Object> map){
        Archives archives=archivesService.selectById(dnum);
        System.out.println(archives);
        map.put("arch",archives);
        return "myarchives";
    }
}
