package com.ujiuye.sys.controller;

import com.ujiuye.comm.ResultEntity;
import com.ujiuye.sys.bean.Sources;
import com.ujiuye.sys.service.SourcesService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/sources")
public class SourcesController {

    @Autowired
    private SourcesService sourcesService;

    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Sources> showAllSources(){
        List<Sources> list = sourcesService.getSourcesByPid(0);
        queryChildren(list.get(0));
        return list;
    }

    //完成递归查询
    private void queryChildren(Sources sources) {
        Integer id = sources.getId();
        List<Sources> sourcesById = sourcesService.getSourcesByPid(id);
        //递归的结束条件：sourcesById为null
        for (Sources sources1 : sourcesById) {
            queryChildren(sources1);
        }
        sources.setChildren(sourcesById);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addSources(Sources sources){
        boolean result=sourcesService.addSources(sources);
        return "redirect:/pm.jsp";
    }

    @RequestMapping(value = "/getOneById/{id}",method = RequestMethod.GET)
    public ModelAndView getOneById(@PathVariable(value = "id")Integer id){
        ModelAndView mv=new ModelAndView("pm-edit");
        Sources oneById = sourcesService.getOneById(id);
        mv.addObject("onesource",oneById);
        return mv;
    }
    //updateInfo
    @RequestMapping(value = "/updateInfo",method = RequestMethod.PUT)
    public String updateInfo(Sources sources){
        boolean result=sourcesService.updateInfo(sources);
       // mv.addObject("onesource",oneById);
        return "redirect:/pm.jsp";
    }


    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public ResultEntity deleteInfo(@RequestParam(value = "id")Integer id){
        boolean result=sourcesService.deleteInfo(id);
        return ResultEntity.success();
    }
}
