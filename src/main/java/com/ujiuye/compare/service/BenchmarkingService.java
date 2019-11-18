package com.ujiuye.compare.service;

import com.ujiuye.compare.bean.Benchmarking;

import java.util.List;

public interface BenchmarkingService {
    void saveInfo(Benchmarking benchmarking);

    List<Benchmarking> getList(Integer year);
}
