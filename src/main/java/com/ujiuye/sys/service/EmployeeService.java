package com.ujiuye.sys.service;


import com.ujiuye.sys.bean.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getManagerList();

    Employee selectEmpByEid(Integer empFk);

    Employee login(Employee employee);

    List<Employee> getEnameList();

    List<Employee> getOthers(Integer eid);

    Integer saveInfo(Employee employee);
}
