package com.ujiuye.compare.mapper;

import com.ujiuye.compare.bean.Benchmarking;

import java.util.List;

public interface BenchmarkingMapper {
    void saveInfo(Benchmarking benchmarking);

    List<Benchmarking> getList(Integer year);
}
