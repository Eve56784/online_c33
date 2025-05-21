import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  @Bean(initMethod = "init", destroyMethod = "preDestroy")
    public JavaConfigBean javaConfigBean() {
      return new JavaConfigBean();
  }
}
