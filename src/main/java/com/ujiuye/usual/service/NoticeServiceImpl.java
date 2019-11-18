package com.ujiuye.usual.service;

import com.ujiuye.usual.bean.Notice;
import com.ujiuye.usual.bean.NoticeExample;
import com.ujiuye.usual.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public void saveInfo(Notice notice) {
        notice.setNdate(new Date());
        int insert = noticeMapper.insert(notice);
    }

    @Override
    public List<Notice> getNoticeJsonList() {
        NoticeExample example=new NoticeExample();
        List<Notice> list = noticeMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<Notice> showMainPage() {
        NoticeExample example=new NoticeExample();
        example.setOrderByClause("ndate desc limit 3");
        List<Notice> list = noticeMapper.selectByExample(example);
        return list;
    }

    @Override
    public Notice showOneInfo(Integer nid) {

        Notice notice = noticeMapper.selectByPrimaryKey(nid);
        return notice;
    }

    @Override
    public boolean deleteById(Integer nid) {
        int i = noticeMapper.deleteByPrimaryKey(nid);
        if (i > 0) {

            return true;
        }
        return  false;
    }
}
