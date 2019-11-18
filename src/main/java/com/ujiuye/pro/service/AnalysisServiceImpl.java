package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Analysis;
import com.ujiuye.pro.bean.AnalysisExample;
import com.ujiuye.pro.mapper.AnalysisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Autowired
    private AnalysisMapper analysisMapper;

    @Override
    public boolean addAnalysis(Analysis analysis) {
        int i = analysisMapper.insert(analysis);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public Analysis selectAnalById(Integer pid) {
        Analysis analysis = analysisMapper.selectByPrimaryKey(pid);
        return analysis;
    }

    @Override
    public List<Analysis> selectAllAnalysis() {
        AnalysisExample analysisExample=new AnalysisExample();
        List<Analysis> analyses = analysisMapper.selectByExample(analysisExample);
        return analyses;
    }

    @Override
    public boolean saveInfo(Analysis analysis) {
        analysis.setUpdatetime(new Date());
        int update = analysisMapper.updateByPrimaryKey(analysis);
        if (update>0){
            return true;
        }
        return false;
    }

}
