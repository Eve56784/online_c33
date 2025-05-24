package main;

import interfaces.ServiceInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javaconfig.AppConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml.config.MyServiceXml;

public class MyMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ServiceInterface service = context.getBean("myServiceJava", ServiceInterface.class);
        service.getReply();
        context.close();
        System.out.println("------------------------");
        ClassPathXmlApplicationContext context1 =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        ServiceInterface service1 = context1.getBean("myServiceXml", ServiceInterface.class);
        service1.getReply();
    }
}
