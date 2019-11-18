package com.ujiuye.usual.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.usual.bean.Task;
import com.ujiuye.usual.bean.TaskExample;
import com.ujiuye.usual.mapper.TaskMapper;
import com.ujiuye.utils.ParseParamerMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class TaskServiceImpl implements TaskService {

    @Resource
    private TaskMapper taskMapper;

    @Override
    public boolean addTask(Task task) {
        task.setStatus(0);
        int insert = taskMapper.insert(task);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    @Override
    public PageInfo<Task> getList(Integer pageNum, Map<String, Object> parameterMap) {

        TaskExample example=new TaskExample();
        TaskExample.Criteria criteria = example.createCriteria();

        Map<String, String> MybatisMap = ParseParamerMap.parseParamerMapToMyBatismap(parameterMap);
        String status = MybatisMap.get("status");
       // criteria.andIdEqualTo(Integer.parseInt(status));
        if (status != null && status != ""){
            criteria.andStatusEqualTo(Integer.parseInt(status));
            System.out.println("status:"+status);
        }
        String keyword = MybatisMap.get("keyword");
        System.out.println("keyword 0"+keyword);
        //System.out.println("keyword1："+keyword);
        String type = MybatisMap.get("type");
        //System.out.println("tye:"+type);
        if (keyword!=null && !keyword.equals("%%") ){
                System.out.println("keyword 1"+keyword);
                if (type != null && type != ""){
                    if (type.equals("0")){
                        criteria.andTasktitleLike(keyword);
                        //System.out.println("type0:"+keyword);
                    }else if(type.equals("1")){
                        criteria.andEnameLike(keyword);
                        //System.out.println("type1"+keyword);
                    }
                }else {
                    criteria.andTasktitleLike(keyword);
                    TaskExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andEnameLike(keyword);
                    example.or(criteria1);
                }
        }
        String orderby = MybatisMap.get("orderby");
        if (orderby!=null && orderby!= ""){
            if (orderby.equals("0")){
                example.setOrderByClause("starttime asc");
            }
            if (orderby.equals("1")){
                example.setOrderByClause("endtime desc");
            }
        }
        PageHelper.startPage(pageNum,2);

        List<Task> tasks = taskMapper.selectTaskList(example);
        PageInfo<Task> page=new PageInfo<>(tasks,3);
        return page;
    }
}
