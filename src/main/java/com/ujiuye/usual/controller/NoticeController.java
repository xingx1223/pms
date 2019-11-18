package com.ujiuye.usual.controller;

import com.ujiuye.comm.ResultEntity;
import com.ujiuye.usual.bean.Notice;
import com.ujiuye.usual.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResultEntity saveInfo(Notice notice){
        noticeService.saveInfo(notice);
        //ResultEntity entity=new ResultEntity();
        return ResultEntity.success();
    }

    /*@RequestMapping(value = "/jsonList",method = RequestMethod.GET)
    public ResultEntity jsonList(){
        List<Notice> list=noticeService.getNoticeJsonList();
        return ResultEntity.success().put("list",list);
    }*/
    //showAll
    @ResponseBody
    @RequestMapping(value = "/showAll",method = RequestMethod.GET)
    public List<Notice> showAll(){
        List<Notice> list=noticeService.getNoticeJsonList();
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "showMainPage",method = RequestMethod.GET)
    public List<Notice> showMainPage(){
        List<Notice> list=noticeService.showMainPage();
        return list;
    }

    //showOneInfo
    @ResponseBody
    @RequestMapping(value = "showOneInfo",method = RequestMethod.GET)
    public Notice showOneInfo(Integer nid){
        Notice notice=noticeService.showOneInfo(nid);
        return notice;
    }

    //deleteById
    @ResponseBody
    @RequestMapping(value = "deleteById",method = RequestMethod.DELETE)
    public ResultEntity deleteById(Integer nid){
        boolean row =noticeService.deleteById(nid);
        return ResultEntity.success();
    }
}
