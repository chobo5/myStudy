package bitcamp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@ComponentScan(value="bitcamp.app1")
public class App1Config {
    @Bean
    MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
}
