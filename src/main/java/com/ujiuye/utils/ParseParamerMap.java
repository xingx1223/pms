package com.ujiuye.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ParseParamerMap {
    public static Map<String, String> parseParamerMapToMyBatismap(Map<String, Object> paremeterMap) {

        Map<String,String> resultMap=new HashMap<>();

        Set<Map.Entry<String, Object>> entries = paremeterMap.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            String value =(String) entry.getValue();

            //是模糊查询走这个
            if (key.contains("like")){
                //模糊查询
                key=key.substring(key.indexOf("_")+1);
                //System.out.println("k:::::::::::::::"+key);
                value="%"+value+"%";
            }
            //不是直接添加
            resultMap.put(key,value);
        }

        return resultMap;
    }

    public static String parseParameterMapToString(Map<String, Object> paremeterMap) {
        Set<Map.Entry<String, Object>> entries = paremeterMap.entrySet();
        String str="";
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            String value =(String) entry.getValue();
            str=str+"&"+"search_"+key+"="+value;
        }
        return str;
    }
}
