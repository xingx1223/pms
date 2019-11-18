package com.ujiuye.usual.service;

import com.ujiuye.usual.bean.Archives;
import com.ujiuye.usual.bean.ArchivesExample;
import com.ujiuye.usual.mapper.ArchivesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchivesServiceImpl implements ArchivesService {

    @Autowired
    private ArchivesMapper archivesMapper;

    @Override
    public List<Archives> selectAllArchives() {

        List<Archives> list = archivesMapper.selectAllArchives();
        return list;
    }

    @Override
    public Archives selectById(String dnum) {
        Archives archives = archivesMapper.selectById(dnum);
        return archives;
    }
}
