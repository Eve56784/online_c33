import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class JavaConfigBean {
    @PostConstruct
    public void init(){
        System.out.println("Java config bean was initialized");
    }
    public void greet(){
        System.out.println("Hello (JavaConfigBean)!");
    }
    @PreDestroy
    public void preDestroy(){
        System.out.println("Java config bean's gonna be destroyed");
    }
}
