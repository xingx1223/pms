package com.ujiuye.usual.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.ujiuye.sys.bean.Employee;
import com.ujiuye.usual.bean.BaoXiao;
import com.ujiuye.usual.service.BaoXiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value = "/bx")
public class BaoXiaoController {

    @Autowired
    private BaoXiaoService baoXiaoService;

    @RequestMapping(value = "saveInfo",method = RequestMethod.POST)
    public String saveInfo(BaoXiao baoXiao, HttpSession session){
        Employee employee = (Employee)session.getAttribute("loginUser");
        baoXiao.setEmpFk(employee.getEid());
        boolean result=baoXiaoService.saveInfo(baoXiao);
        return "redirect:/mybaoxiao-base.jsp";
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ModelAndView getMyBxList(HttpServletRequest request, HttpSession session, @RequestParam(value = "pageNum",defaultValue ="1") Integer pageNum){

        //map的key是浏览器传过来的参数的键去掉指定前綴之后剩下的那部分
        //map的value是浏览器传过来的参数的值
        Map<String, Object> paremeterMap = WebUtils.getParametersStartingWith(request, "search_");
        //System.out.println(paremeterMap);
        //解析map
        String queryStr=parseParameterMapToString(paremeterMap);

        Employee loginUser = (Employee)session.getAttribute("loginUser");
        Integer eid = loginUser.getEid();

        String requestURI = request.getRequestURI();
        //StringBuffer requestURL = request.getRequestURL();
        /*System.out.println("uri"+requestURI);///pms/bx/list
        System.out.println("url"+requestURL);////localhost:8080/pms/bx/list*/

        //System.out.println("eid"+eid);
        //PageInfo:
        PageInfo<BaoXiao> page=baoXiaoService.getMyBxList(eid,pageNum,paremeterMap);
        ModelAndView mv=new ModelAndView("mybaoxiao-base");
        mv.addObject("page",page);
        mv.addObject("requestURI",requestURI);
        mv.addObject("queryStr",queryStr);
        return mv;
    }

    private String parseParameterMapToString(Map<String, Object> paremeterMap) {
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
