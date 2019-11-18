import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;

public class Apptest {

    @Test
    public void test01() throws MessagingException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beas-email.xml");
        JavaMailSenderImpl bean = context.getBean(JavaMailSenderImpl.class);


        MimeMessage mimeMessage = bean.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"utf-8");

        FileSystemResource resource=new FileSystemResource(new File("D:\\Documents\\Downloads\\1.jpg"));
        helper.addAttachment("1.jpg",resource);

        helper.setFrom("xx915685642@163.com");
       helper.setTo("xx915685642@163.com");
       helper.setSubject("这是0708班的邮件测试02");
       helper.setText("嘿嘿嘿嘿<span class='red'>嘿嘿</span>嘿，阿哦哦阿哦好奥");
        helper.setText("<>");
       //发送邮件
        bean.send(mimeMessage);

        System.out.println("eamil pass");
    }

    @Test
    public void test02(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-quartz.xml");
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-quartz.xml");
    }
}
