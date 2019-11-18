package com.ujiuye.sys.service;


import com.ujiuye.sys.bean.Employee;
import com.ujiuye.sys.bean.EmployeeExample;
import com.ujiuye.sys.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getManagerList() {
        EmployeeExample example=new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andPFkEqualTo(4);
        List<Employee> list = employeeMapper.selectByExample(example);
        return list;
    }

    @Override
    public Employee selectEmpByEid(Integer empFk) {
        Employee employee = employeeMapper.selectByPrimaryKey(empFk);
        return employee;
    }

    @Override
    public Employee login(Employee employee) {

        EmployeeExample example=new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(employee.getUsername());
        criteria.andPasswordEqualTo(employee.getPassword());

        List<Employee> list = employeeMapper.selectByExample(example);
        if (list!=null && list.size()!=0){
            employee = list.get(0);
            return employee;
        }
        return null;

    }

    @Override
    public List<Employee> getEnameList() {
        List<Employee> emps=employeeMapper.selectEnameList();
        return emps;
    }

    @Override
    public List<Employee> getOthers(Integer eid) {
        List<Employee> list=employeeMapper.getOthers(eid);
        return list;
    }

    @Override
    public Integer saveInfo(Employee employee) {
        employeeMapper.insertEmp(employee);
        return employee.getEid();

    }
}
