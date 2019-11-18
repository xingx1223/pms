package com.ujiuye.usual.controller;

import com.github.pagehelper.PageInfo;
import com.ujiuye.usual.bean.Task;
import com.ujiuye.usual.service.TaskService;
import com.ujiuye.utils.ParseParamerMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/addTask",method = RequestMethod.POST)
    public String  addTask(Task task){
       boolean result= taskService.addTask(task);
       return "redirect:/task.jsp";
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ModelAndView getList(HttpServletRequest request, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){

        Map<String, Object> parameterMap = WebUtils.getParametersStartingWith(request, "search_");
        String queryStr= ParseParamerMap.parseParameterMapToString(parameterMap);

        PageInfo<Task> pageInfo=taskService.getList(pageNum,parameterMap);

        String requestURI = request.getRequestURI();
        ModelAndView mv=new ModelAndView("task");
        mv.addObject("page",pageInfo);
        mv.addObject("requestURI",requestURI);
        mv.addObject("queryStr",queryStr);
        return mv;
    }

}
