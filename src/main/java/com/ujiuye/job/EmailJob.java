package com.ujiuye.job;

import com.ujiuye.info.bean.Email;
import org.quartz.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

public class EmailJob  implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {

        System.out.println("ddd");
        JobDataMap dataMap = context.getMergedJobDataMap();
        Email email =(Email) dataMap.get("email");
        JavaMailSenderImpl javaMailSender =(JavaMailSenderImpl) dataMap.get("JavaMailSenderImpl");//javaMailSender
        System.out.println(javaMailSender);
        Scheduler sched = (Scheduler)dataMap.get("sched");

        try {
            //邮件对象
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"utf-8");

            helper.setFrom("xx915685642@163.com");
            helper.setTo(email.getEname());
            helper.setSubject(email.getTitle());
            helper.setText(email.getContent(),true);
            //发送邮件
            javaMailSender.send(mimeMessage);

            System.out.println("pass");

            sched.shutdown(true);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
