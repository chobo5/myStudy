package exam02.config;

import exam.Book;
import exam02.component.MyDao;
import exam02.component.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    public ApplicationConfig() {
        System.out.println("ApplicationConfig()");
    }

    @Bean
    public Book book3() {
        return new Book();
    }

    @Bean(name = "service")
    public MyService myService(MyDao myDao) {
        MyService myService = new MyService();
        myService.setMyDao(myDao);
        return myService;
    }

    @Bean
    public MyDao myDao() {
        return new MyDao();
    }
}
