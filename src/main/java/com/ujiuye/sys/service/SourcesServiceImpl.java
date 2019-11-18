package com.ujiuye.sys.service;

import com.alibaba.fastjson.JSON;
import com.ujiuye.sys.bean.Sources;
import com.ujiuye.sys.bean.SourcesExample;
import com.ujiuye.sys.mapper.SourcesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@Service
public class SourcesServiceImpl implements SourcesService {

    @Autowired
    private SourcesMapper sourcesMapper;
    @Autowired
    private JedisPool jedisPool;

    //有层级的查询
    @Override
    public List<Sources> getSourcesByPid(int i) {

        SourcesExample example=new SourcesExample();
        SourcesExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(i);
        return  sourcesMapper.selectByExample(example);
    }

    @Override
    public boolean addSources(Sources sources) {

        int i = sourcesMapper.insertSelective(sources);
        if (i>0) {
            return true;
        }
        return false;
    }

    @Override
    public Sources getOneById(Integer id) {
        Sources sources = sourcesMapper.selectByPrimaryKey(id);
        return sources;
    }

    @Override
    public boolean updateInfo(Sources sources) {
        int update = sourcesMapper.updateByPrimaryKeySelective(sources);
        if (update>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteInfo(Integer id) {
        int i = sourcesMapper.deleteByPrimaryKey(id);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Sources> selectSourceList(Integer eid) {
        //先去缓存中查
        /*Jedis jedis = jedisPool.getResource();
        String s = jedis.get(eid + "");
        List<Sources> sources1 = JSON.parseArray(s, Sources.class);
        //缓存中没有再去数据库查
        if (sources1==null || sources1.size()==0){
            //return sourcesMapper.selectSourceList(eid);
            sources1=sourcesMapper.getSourcesListByEid(eid,1);
            for (Sources source : sources1) {
                Integer id = source.getId();
                List<Sources> list = sourcesMapper.getSourcesListByEid(eid, id);
                source.setChildren(list);
            }
            //设置在redis缓存中
            jedis.set(eid+"",JSON.toJSONString(sources1));
        }
        //关闭缓存
        jedis.close();
        return sources1;*/

        //return sourcesMapper.selectSourceList(eid);
        List<Sources> sources=sourcesMapper.getSourcesListByEid(eid,1);
        for (Sources source : sources) {
            Integer id = source.getId();
            List<Sources> list = sourcesMapper.getSourcesListByEid(eid, id);
            source.setChildren(list);
        }
        return sources;
    }
}
