package com.ujiuye.pro.controller;

import com.ujiuye.pro.bean.Attachment;
import com.ujiuye.pro.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping(value = "attachment")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    @ResponseBody
    @RequestMapping(value = "addAttach",method = RequestMethod.POST)
    public Map<String, Object> addAttach(Attachment atta, MultipartFile attachment, HttpSession session){
        ServletContext context = session.getServletContext();
        String realPath = context.getRealPath("/upload");
        File file=new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }
        //保存附件
        String originalFilename = attachment.getOriginalFilename();
        System.out.println(originalFilename);
        String realName=UUID.randomUUID().toString().replaceAll("-","")+originalFilename;
        try {
            //上传到本地
            attachment.transferTo(new File(realPath+"/"+realName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // multipartFile.getInputStream();
        atta.setPath(realPath+"/"+realName);
        boolean result= attachmentService.addAttach(atta);
        Map<String,Object> map=new HashMap<>();
        map.put("statusCode",200);

        return map;
    }
}
