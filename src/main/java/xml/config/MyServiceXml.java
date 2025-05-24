package xml.config;

import interfaces.ServiceInterface;

public class MyServiceXml implements ServiceInterface {
    private String msg;

    public MyServiceXml(String msg) {
        this.msg = msg;
    }

    @Override
    public void getReply() {
        System.out.println("[XML-Config] MyService replied with: \"" + msg+"\"");
    }

    public void init(){
        System.out.println("[XML-Config] MyService init");
    }
}
