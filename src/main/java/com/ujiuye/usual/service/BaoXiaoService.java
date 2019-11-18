package com.ujiuye.usual.service;

import com.github.pagehelper.PageInfo;
import com.ujiuye.usual.bean.BaoXiao;

import java.util.Map;

public interface BaoXiaoService {
    boolean saveInfo(BaoXiao baoXiao);

    PageInfo<BaoXiao> getMyBxList(Integer eid, Integer pageNum, Map<String, Object> paremeterMap);
}
