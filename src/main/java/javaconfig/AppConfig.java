package javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "javaconfig")
public class AppConfig {

  @Bean(initMethod = "init")
  public MyServiceJava myService() {
    return new MyServiceJava();
  }

  @Bean
  public LoggingAspect loggingAspect() {
    return new LoggingAspect();
  }
}
