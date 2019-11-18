package com.ujiuye.pro.controller;


import com.ujiuye.exception.ZhiFuException;
import com.ujiuye.pro.bean.Project;
import com.ujiuye.pro.service.ProjectService;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/pro")
@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    public String saveInfo(Project project){
        //System.out.println(project);
        projectService.saveInfo(project);
        return "redirect:/pro/list";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView selectProList() throws ZhiFuException {
        List<Project> list= projectService.selectProList();
        ModelAndView mv=new ModelAndView("project-base");
        mv.addObject("list",list);
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/jsonList",method = RequestMethod.GET)
    public List<Project> jsonList(){
        List<Project> list= projectService.selectProList();
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/del",method = RequestMethod.DELETE)
    public Map<String,Object> deletePro(@RequestParam(value = "ids[]") Integer[] ids){
        boolean result=projectService.deletePro(ids);
        Map<String,Object> map=new HashMap<>();
        if (result){
            map.put("statusCode",200);
            map.put("message","删除成功");
        }else{
            map.put("statusCode",500);
            map.put("message","删除失败");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/info/{pid}",method = RequestMethod.GET)
    public Project selectProInfoById(@PathVariable(value = "pid") Integer pid){
        Project project = projectService.proDetialById(pid);
        return project;
    }

    @RequestMapping(value = "/proDetialById/{pid}",method=RequestMethod.GET)
    public ModelAndView proDetialById(@PathVariable(value = "pid") Integer pid){
        ModelAndView mv=new ModelAndView("project-base-look");
        Project project = projectService.proDetialById(pid);
       // System.out.println(project);
        mv.addObject("project",project);
        return mv;
    }

    @RequestMapping(value = "selectProById/{pid}",method = RequestMethod.GET)
    public ModelAndView selectProById(@PathVariable(value = "pid") Integer pid){
        ModelAndView mv=new ModelAndView("project-base-edit");
        Project project = projectService.proDetialById(pid);
        //System.out.println(project);
        mv.addObject("project",project);
        return mv;
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public String  update(Project project){
        //System.out.println(project);
        boolean update = projectService.update(project);
        //if (update){
        return "redirect:/pro/list";
    }

    @RequestMapping(value = "search",method = RequestMethod.GET)
    public ModelAndView searchProByKey(Integer cid,String keyword,Integer orderby){
        List<Project> list= projectService.searchProByKey(cid,keyword,orderby);
        ModelAndView mv=new ModelAndView("project-base");
        mv.addObject("list",list);
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "exportExcel",method = RequestMethod.GET)
    public Map<String,Object> exportExcel(){
        Workbook wb=new HSSFWorkbook();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        //2.在表格里面创建sheet对象
        Sheet sheet1=wb.createSheet("projects");
        Row row1 = sheet1.createRow(0);
        Cell[] cells=new HSSFCell[8];
        for (int i =0;i<8;i++){
            cells[i]=row1.createCell(i);
        }
        cells[0].setCellValue("ID");
        cells[1].setCellValue("项目名称");
        cells[2].setCellValue("客户公司名称");
        cells[3].setCellValue("客户方负责人");
        cells[4].setCellValue("项目经理");
        cells[5].setCellValue("开发人数");
        cells[6].setCellValue("立项时间");
        cells[7].setCellValue("备注");

        List<Project> list = projectService.selectProList();
        for (int i = 0; i < list.size(); i++) {
            Project project = list.get(i);
            Row row2=sheet1.createRow(i+1);
            Cell[] cells1=new HSSFCell[8];
            for ( int j=0;j<8;j++){
                cells1[j]=row2.createCell(j);
            }

            cells1[0].setCellValue(project.getPid());
            cells1[1].setCellValue(project.getPname());
            cells1[2].setCellValue(project.getCustomer().getComname());
            cells1[3].setCellValue(project.getCustomer().getCompanyperson());
            cells1[4].setCellValue(project.getEmployee().getEname());
            cells1[5].setCellValue(project.getEmpcount());
            String starttime = sdf.format(project.getStarttime());
            cells1[6].setCellValue(starttime);
            cells1[7].setCellValue(project.getRemark());
        }
        FileOutputStream fos=null;
        try {
            fos=new FileOutputStream(new File("d:/Desktop/projects.xls"));
            wb.write(fos);
            //fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",200);
        map.put("message","下载成功");
        return map;
    }
}
