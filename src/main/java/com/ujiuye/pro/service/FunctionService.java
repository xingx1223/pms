package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Function;

import java.util.List;

public interface FunctionService {
    List<Function> selectFuncsById(Integer mid);
}
