package com.ujiuye.compare.controller;

import com.ujiuye.compare.bean.Benchmarking;
import com.ujiuye.compare.service.BenchmarkingService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/benchmarking")
public class BenchmarkingController {

    @Autowired
    private BenchmarkingService benchmarkingService;

    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    public String saveInfo(Benchmarking benchmarking){
        benchmarkingService.saveInfo(benchmarking);
        return "redirect:/indexvalue-base.jsp";
    }

    @ResponseBody
    @RequestMapping(value = "list/{year}",method = RequestMethod.GET)
    public List<Benchmarking> getList(@PathVariable(value = "year") Integer year){
        return benchmarkingService.getList(year);
    }
}
