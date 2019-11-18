package com.ujiuye.compare.service;

import com.ujiuye.compare.bean.Benchmarking;
import com.ujiuye.compare.mapper.BenchmarkingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenchmarkingServiceImpl implements BenchmarkingService {

    @Autowired
    private BenchmarkingMapper benchmarkingMapper;

    @Override
    public void saveInfo(Benchmarking benchmarking) {
        benchmarkingMapper.saveInfo(benchmarking);
    }

    @Override
    public List<Benchmarking> getList(Integer year) {

        return benchmarkingMapper.getList(year);
    }
}
