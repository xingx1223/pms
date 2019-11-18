package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Analysis;
import com.ujiuye.usual.bean.Archives;

import java.util.List;

public interface AnalysisService {
    boolean addAnalysis(Analysis analysis);

    Analysis selectAnalById(Integer pid);

    List<Analysis> selectAllAnalysis();

    boolean saveInfo(Analysis analysis);

}
