package com.example.springweb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //Spring Java Config
@EnableWebMvc //xml에서는 <mvc:annotation-drive />

//com.example패키지 이하에서 @Controller가 붙어있는 클래스를 모두 Bean으로 등록해라(Spring Container가 관리하겠다)
@ComponentScan(basePackages = { "com.example" },
    includeFilters = { @ComponentScan.Filter(Controller.class)})
public class WebConfig implements WebMvcConfigurer {

    public WebConfig() {
        System.out.println("WebConfig가 실행됩니다.");
    }
}
