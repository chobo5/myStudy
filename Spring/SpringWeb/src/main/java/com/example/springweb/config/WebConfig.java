package com.example.springweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration //Spring Java Config
@EnableWebMvc //xml에서는 <mvc:annotation-drive />

//com.example패키지 이하에서 @Controller가 붙어있는 클래스를 모두 Bean으로 등록해라(Spring Container가 관리하겠다)
@ComponentScan(basePackages = { "com.example" },
    includeFilters = { @ComponentScan.Filter(Controller.class)})
public class WebConfig implements WebMvcConfigurer {

    public WebConfig() {
        System.out.println("WebConfig가 실행됩니다.");
    }

    //WebMvcConfigurer는 아무것도 구현되어있지 않은 interface로 구현해줘야 한다.

    //Tomcat에 내장되어있는 서블릿(+정적자원)을 사용하도록 설정
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        System.out.println("configureDefaultServletHandling이 실행됩니다.");
        //WebMvcConfigurer를 구현했다면 Spring Container가 모두 실행시켜준다.
        configurer.enable(); //디폴트 서블릿을 사용하도록한다.
    }

    //Spring은 ViewResolver를 설정하라.
    //JSP를 사용하려면 InternalResourceViewResolver가 필요하다.
    //InternalResourceViewResolver를 Bean으로 등록해라
    //WEB-INF/view/ + "hello" + "jsp"로 포워딩 하
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
        //jsp는 url을 통해 직접 접근할 수 없다.
        //Controller를 통해서만 접근할 수 있도록 한다.
    }
}
