package com.ujiuye.comm;

import com.ujiuye.exception.ZhiFuException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@ControllerAdvice
public class ExceptionHandlerClass {
//全局异常处理类,
    // 1.无论后台有无异常，在后台都返回给前端页面一个正常的json响应数据
    //2. 支付宝、平台类公司，

    @ExceptionHandler(value = SQLException.class)
    @ResponseBody
    public ResultEntity handlerSqlException(){
        return ResultEntity.error();
    }

    //支付异常
    @ExceptionHandler(value = {ZhiFuException.class})
    @ResponseBody
    public ResultEntity handleZhiFuException(){
        // 1.开发人员和运维人员、发短信、发邮件
        return ResultEntity.error();
    }
}
