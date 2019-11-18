package com.ujiuye.comm;

import java.util.HashMap;
import java.util.Map;

public class ResultEntity {

    //直接new',避免null值
    public Map<String,Object> map=new HashMap<>();

    public ResultEntity put(String key,Object object){
        this.map.put(key,object);
        return this;
    }
    public static ResultEntity success(){
        ResultEntity entity=new ResultEntity();
        entity.map.put("statusCode",200);
        entity.map.put("message","响应成功");
        return entity;
    }
    public static ResultEntity error(){
        ResultEntity entity=new ResultEntity();
        entity.map.put("statusCode",500);
        entity.map.put("message","服务器异常");
        return entity;
    }
}
