package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Attachment;
import com.ujiuye.pro.mapper.AttachmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachmentServiceImpl implements AttachmentService{

    @Autowired
    private AttachmentMapper attachmentMapper;
    @Override
    public boolean addAttach(Attachment attachment) {
        int insert = attachmentMapper.insert(attachment);
        if (insert > 0) {
            return true;

        }
        return false;
    }
}
