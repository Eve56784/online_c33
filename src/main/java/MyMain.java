import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyMain {
    public static void main(String[] args) {
        ApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext.xml");
        XMLConfigBean xmlBean = context1.getBean(XMLConfigBean.class);
        ApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class);
        JavaConfigBean javaBean = context2.getBean(JavaConfigBean.class);
        xmlBean.greet();
        javaBean.greet();
        ((ClassPathXmlApplicationContext) context1).close();
        ((AnnotationConfigApplicationContext) context2).close();
    }
}
