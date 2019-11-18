package com.ujiuye.usual.service;

import com.ujiuye.usual.bean.Notice;

import java.util.List;

public interface NoticeService {
    void saveInfo(Notice notice);

    List<Notice> getNoticeJsonList();

    List<Notice> showMainPage();

    Notice showOneInfo(Integer nid);

    boolean deleteById(Integer nid);
}
