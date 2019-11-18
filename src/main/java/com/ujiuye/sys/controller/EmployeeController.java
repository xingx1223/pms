package com.ujiuye.sys.controller;


import com.ujiuye.sys.bean.Employee;
import com.ujiuye.sys.bean.Sources;
import com.ujiuye.sys.service.EmpRoleService;
import com.ujiuye.sys.service.EmployeeService;
import com.ujiuye.sys.service.SourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping(value = "/emp")
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmpRoleService empRoleService;
    @Autowired
    private SourcesService sourcesService;

    //
    @RequestMapping(value = "saveInfo",method = RequestMethod.POST)
    public String saveInfo(Employee employee,String roleid){
        //保存并获取主键
        Integer eid=employeeService.saveInfo(employee);
        //System.out.println(eid);
        //向员工和角色的关联表中添加数据
        empRoleService.saveInfo(eid,roleid);

        //
        return "redirect:/user.jsp";
    }

    //others
    @ResponseBody
    @RequestMapping(value = "/others",method = RequestMethod.GET)
    public List<Employee> getOthers(HttpSession session){
        Employee loginUser =(Employee) session.getAttribute("loginUser");
        Integer eid = loginUser.getEid();
        List<Employee> list = employeeService.getOthers(eid);
        //System.out.println(list);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/manager",method = RequestMethod.GET)
    public List<Employee> getManagerList(){
        List<Employee> list = employeeService.getManagerList();
        //System.out.println(list);
        return list;
    }

    /**
     * 重定向传数据：
     * @param employee
     * @param code
     * @param session
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(Employee employee, String code, HttpSession session, RedirectAttributes attributes){

        //获取设置的验证码
        String validateCode = (String) session.getAttribute("validateCode");
        //if判断是否和输入的验证码一致
        if (code.equalsIgnoreCase(validateCode)){
            session.removeAttribute("validateCode");
            //用户名和密码咋service层进性验证：在该层查询emplyee对象，
           employee= employeeService.login(employee);
           //如果返回的employee对象
            if (employee!=null){

                Integer eid = employee.getEid();
                List<Sources> sourcesList=sourcesService.selectSourceList(eid);
                session.setAttribute("sourcesList",sourcesList);

                session.setAttribute("loginUser",employee);
                return "redirect:/index.jsp";
            }else{
                attributes.addFlashAttribute("errorMsg","用户名或者密码错误");
                return "redirect:/login.jsp";
            }
        }
        attributes.addFlashAttribute("errorMsg","验证码错误");
        return "redirect:/login.jsp";
    }

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public  String  logout(HttpSession session){
        session.invalidate();//或者移除
        return "redirect:/login.jsp";
    }

    @ResponseBody
    @RequestMapping(value = "getEnameList",method = RequestMethod.GET)
    public  List<Employee>  getEnameList(){
      List<Employee> emps= employeeService.getEnameList();
      return emps;
    }
}
