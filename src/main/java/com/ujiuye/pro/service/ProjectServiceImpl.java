package com.ujiuye.pro.service;

import com.github.pagehelper.PageHelper;
import com.ujiuye.cus.bean.Customer;
import com.ujiuye.cus.service.CustomerService;
import com.ujiuye.pro.bean.Project;
import com.ujiuye.pro.bean.ProjectExample;
import com.ujiuye.pro.mapper.ProjectMapper;
import com.ujiuye.sys.bean.Employee;
import com.ujiuye.sys.bean.EmployeeExample;
import com.ujiuye.sys.service.EmployeeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectServiceImpl  implements ProjectService{

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void saveInfo(Project project) {
        projectMapper.insert(project);
    }

    @Override
    public List<Project> selectProList() {
        ProjectExample example=new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();

        List<Project> list = projectMapper.selectByExample(example);
        for (Project pro:list) {
            Customer customer = customerService.getCustomerDetail(pro.getComname());
            Employee employee=employeeService.selectEmpByEid(pro.getEmpFk());
            pro.setCustomer(customer);
            pro.setEmployee(employee);
            //System.out.println(pro);
        }
        return list;
    }

    @Override
    public boolean deletePro(Integer[] ids) {
        List<Integer> idList = Arrays.asList(ids);
        ProjectExample example=new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();
        criteria.andPidIn(idList);
        int i = projectMapper.deleteByExample(example);
        return ids.length==i;
    }

    @Override
    public Project proDetialById(Integer pid) {
        Project project = projectMapper.proDetialById(pid);
        return project;
    }

    @Override
    public boolean update(Project project) {
        int i = projectMapper.updateByPrimaryKeySelective(project);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Project> searchProByKey(Integer cid,String keyword,@Param(value = "orderby") Integer orderby) {
        ProjectExample example=new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();
        if (cid==0){
            criteria.andPnameLike("%"+keyword+"%");
            ProjectExample.Criteria criteria1 = example.createCriteria();

            criteria1.andEnameLike("%"+keyword+"%");
            example.or(criteria1);
        }
        else if (cid==1){
            criteria.andPnameLike("%"+keyword+"%");
        }else {
            criteria.andEnameLike("%"+keyword+"%");
        }
        if (orderby==1){
            example.setOrderByClause("pid desc");
        }

        List<Project> list=projectMapper.searchProByKey(example);
        return  list;
    }

}
