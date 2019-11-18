package com.ujiuye.cus.controller;

import com.ujiuye.cus.bean.Customer;
import com.ujiuye.cus.service.CustomerService;
import com.ujiuye.utils.ExcelUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/cus")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ResponseBody
    @RequestMapping(value = "/importExcel",method = RequestMethod.POST)
    public Map<String,Object> importExcel(MultipartFile excel){
        Map<String,Object> map=new HashMap<>();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<Customer> customers = new ArrayList<Customer>();
        try {
            //文件获取
            Workbook wb= WorkbookFactory.create(excel.getInputStream());
            for (int k=0;k<wb.getNumberOfSheets();k++){
                //sheet获取
                Sheet sheet=wb.getSheetAt(k);
                if (sheet==null){
                    break;
                }
                for (int i=sheet.getFirstRowNum()+1;i<=sheet.getLastRowNum();i++){
                    //行获取
                    Row row = sheet.getRow(i);
                    Customer customer=new Customer();
                    if (row!=null){
                        String companyperson = row.getCell(1).getStringCellValue();
                        customer.setCompanyperson(companyperson);
                        String companyName = row.getCell(2).getStringCellValue();
                        customer.setComname(companyName);
                        Date stringTime = row.getCell(3).getDateCellValue();
                        String format = sdf.format(stringTime);
                        Date starttime = sdf.parse(format);
                        customer.setAddtime(stringTime);
                        double numericCellValue = row.getCell(4).getNumericCellValue();
                        BigDecimal bigDecimal = new BigDecimal(String.valueOf(numericCellValue));
                        customer.setComphone(bigDecimal.toPlainString());
                    }
                    customers.add(customer);
                }
            }
            System.out.println(customers);
           /* customerService.batchInsert(customers);*/
            map.put("statusCode",200);
            map.put("message","上传成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("出异常了");
            map.put("statusCode",500);
            map.put("message","上传失败");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    public Customer info(@PathVariable(value = "id") Integer cid){
        Customer customer = customerService.getCustomerDetail(cid);
        return  customer;
    }

    @ResponseBody
    @RequestMapping(value = "/jsonList",method = RequestMethod.GET)
    public List<Customer> getCustomerJsonList(){
        List<Customer> list = customerService.getCustomerList();
        return list;
    }

    //添加客户信息
    @RequestMapping(value = "/addInfo",method = RequestMethod.POST)
    public String insert(Customer customer){
        customerService.insert(customer);
        return "redirect:/cus/list";
        //return "redirect:customer.jsp";
    }


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView getCustomerList(){
        ModelAndView mv=new ModelAndView("customer");
        List<Customer> list = customerService.getCustomerList();
        mv.addObject("list",list);
        return mv;
    }

    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public String detail(@PathVariable(value = "id") Integer cid, Map<String,Object> map){
        Customer customer = customerService.getCustomerDetail(cid);
        map.put("customer",customer);
        return  "customer-look";
    }



   // selectById
   @RequestMapping(value = "/selectById/{id}",method = RequestMethod.GET)
   public String selectById(@PathVariable(value = "id") Integer cid, Map<String,Object> map){
       Customer customer = customerService.getCustomerDetail(cid);
       map.put("customer",customer);
       return  "customer-edit";
   }

   //update
   //修改客户信息
   @RequestMapping(value = "/update",method = RequestMethod.PUT)
   public String update(Customer customer){
        //System.out.println(customer);
       customerService.update(customer);
       return "redirect:/cus/list";
       //return "redirect:customer.jsp";
   }

    //前端使用ajax请求，后台传递的数据为json
    @RequestMapping(value = "/del",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> batchDel(@RequestParam("ids[]") Integer[] ids){
        //return "redirect:customer.jsp";
        /*try {
            customerService.batchDel(ids);
        }catch (Exception e){
            e.printStackTrace();
        }*/
        //System.out.println(ids);
        Map<String,Object> map=new HashMap<>();
        boolean result=customerService.batchDel(ids);
        System.out.println("result"+result);
        if (result){
            map.put("statusCode",200);
            map.put("message","删除成功");
        }else{
            map.put("statusCode",500);
            map.put("message","删除失败");
        }
        return map;
    }

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public ModelAndView search(Integer cid,String keyword,Integer orderby){
        System.out.println(cid+"--"+keyword+"--"+orderby);
        ModelAndView mv=new ModelAndView("customer");
        List<Customer> list = customerService.search(cid,keyword,orderby);
        mv.addObject("list",list);
        return mv;
    }
}
