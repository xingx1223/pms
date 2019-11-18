package com.ujiuye.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/echartz")
public class EchartzController {

    @ResponseBody
    @RequestMapping(value = "getDatas",method = RequestMethod.GET)
    public Map<String,Object> getDatas(){
        Map<String,Object> map= new HashMap<>();
        //"衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]

        map.put("衬衫","1000");
        map.put("羊毛衫","2000");
        map.put("雪纺衫","3000");
        map.put("裤子","2500");
        map.put("高跟鞋","1600");
        map.put("袜子","2800");
        return map;
    }
}
