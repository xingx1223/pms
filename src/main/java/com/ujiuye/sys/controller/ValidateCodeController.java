package com.ujiuye.sys.controller;

import com.ujiuye.comm.ValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 专门获取验证码
 */
@Controller
@RequestMapping(value = "/code")
public class ValidateCodeController {

    @RequestMapping(value="getCode")
    public void getCode(@RequestParam(value = "time") String time, HttpServletRequest request, HttpServletResponse response) {
        ValidateCode code = new ValidateCode(100, 30, 4, 30, 25, "validateCode");
        code.getCode(request, response);

    }
}
