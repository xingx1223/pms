package com.ujiuye.usual.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.usual.bean.BaoXiao;
import com.ujiuye.usual.bean.BaoXiaoExample;
import com.ujiuye.usual.mapper.BaoXiaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BaoXiaoServiceImpl implements BaoXiaoService {

    @Autowired
    private BaoXiaoMapper baoXiaoMapper;
    @Override
    public boolean saveInfo(BaoXiao baoXiao) {
        String bxid = UUID.randomUUID().toString().replaceAll("-","");
        baoXiao.setBxid(bxid);
        baoXiao.setBxstatus(0);
        int insert=baoXiaoMapper.insert(baoXiao);
        if (insert>0){
            return true;
        }
        return false;
    }

    @Override
    public PageInfo<BaoXiao> getMyBxList(Integer eid, Integer pageNum, Map<String, Object> paremeterMap) {
        BaoXiaoExample example=new BaoXiaoExample();
        BaoXiaoExample.Criteria criteria = example.createCriteria();
        criteria.andEmpFkEqualTo(eid);

        //解析map:封装成一个方法，不论多少查询键值对都可以获取
        Map<String,String> MybatisMap=parseParamerMapToMyBatismap(paremeterMap);
        //第一次点没有搜索条件，先做判断
        String status = MybatisMap.get("status");
        if (status != null && status != ""){
            criteria.andBxstatusEqualTo(Integer.parseInt(status));
        }
        String keyword = MybatisMap.get("keyword");
        //System.out.println("key"+keyword);
        if (keyword != null && keyword != ""){
            criteria.andBxremarkLike(keyword);
            //System.out.println("000000"+keyword);
        }
        //设置每页数量，和查询的哪页
        PageHelper.startPage(pageNum,2);

        //待条件的exmple
        List<BaoXiao> baoXiaos = baoXiaoMapper.selectByExample(example);

        /*System.out.println(baoXiaos);
        System.out.println("pageNum"+pageNum);
        System.out.println("eid"+eid);*/
        PageInfo<BaoXiao> pageInfo=new PageInfo<>(baoXiaos,3);

        return  pageInfo;
    }

    private Map<String, String> parseParamerMapToMyBatismap(Map<String, Object> paremeterMap) {

        Map<String,String> resultMap=new HashMap<>();

        Set<Map.Entry<String, Object>> entries = paremeterMap.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            String value =(String) entry.getValue();

            //是模糊查询走这个
            if (key.contains("like")){
                //模糊查询
                key=key.substring(key.indexOf("_")+1);
                System.out.println("k:::::::::::::::"+key);
                value="%"+value+"%";
            }
            //不是直接添加
            resultMap.put(key,value);
        }

        return resultMap;
    }
}
