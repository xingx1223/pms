package com.ujiuye.info.controller;

import com.ujiuye.info.bean.Email;
import com.ujiuye.job.EmailJob;
import com.ujiuye.sys.bean.Employee;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping(value = "/email")
public class EmailController {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    public String saveInfo(Email email) throws SchedulerException {

        email.setSendtime(new Date());

        //创建JobDetail对象，指定对象的任务名称、组名
        JobDetail job = JobBuilder.newJob(EmailJob.class).withIdentity("job1", "group1").build();

        //从jobDetail对象中获取一个map集合，存储数据
        JobDataMap dataMap=job.getJobDataMap();
        dataMap.put("email",email);
        dataMap.put("JavaMailSenderImpl",javaMailSender);

        System.out.println(javaMailSender.createMimeMessage());
        //创建SimpleTrigger对象，指定对象名称、组名  设置任务重复执行间隔时间，重复执行次数 启动时间
        SimpleTrigger trigger = (SimpleTrigger) TriggerBuilder.newTrigger().startAt(new Date()).build();
        //创建任务管理器Scheduler对象
        Scheduler sched= StdSchedulerFactory.getDefaultScheduler();
        //存储Scheduler对象在发送完邮箱后关闭
        dataMap.put("sched",sched);
        //为scheduler对象新增JOb以及对应的SimpleTrigger
        sched.scheduleJob(job,trigger);
        //启动定时任务管理器
        sched.start();
        //关闭定时任务管理器:
       // sched.shutdown(true);
        return "redirect:/message.jsp";
    }
}
