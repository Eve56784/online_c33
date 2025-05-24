package javaconfig;

import interfaces.ServiceInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyServiceJava implements ServiceInterface {
    @Value("Hello from MyService")
    private String msg;

    public void getReply(){
        System.out.println("[Java-Config] MyService replied with: \"" + msg+"\"");
    }

    public void init(){
        System.out.println("[Java-Config] MyService init");
    }
}
