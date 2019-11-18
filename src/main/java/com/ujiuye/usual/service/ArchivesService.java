package com.ujiuye.usual.service;

import com.ujiuye.usual.bean.Archives;

import java.util.List;

public interface ArchivesService {

    List<Archives> selectAllArchives();

    Archives selectById(String dnum);
}
