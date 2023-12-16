package com.example.springweb.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

//Web과 과련된 설정
public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //Spring 3.2부터
    //WebApplicationInitializer 인터페이스를 구현하고있는 AbstractAnnotationConfigDispatcherServletInitializer를 제공해준다.

//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        System.out.println("WebApplicationInitializer의 onStartup 실행");
//
//        //Load Spring web application configuration
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(WebConfig.class);
//
//        //Create and register the DispatcherServlet
//        DispatcherServlet servlet = new DispatcherServlet(context);
//        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcherServlet", servlet);
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/");
//
//    }


    //한글이 깨지지 않도록 설정
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        return new Filter[] {encodingFilter};
    }

    //Spring Container가 비즈니스 로직(트렌잭션, DB프로그래밍 - getRootConfigClasses)과 관련된 설정
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class };
    }


    //Spring Container가 웹과 관련된 설정(Spring MVC - getServletConfigClasses)
    @Override
    protected Class<?>[] getServletConfigClasses() {
        //Spring이 내부적으로 getServletConfigClasses가 리턴해주는 클래스를 스프링의 설정으로 사용
        return new Class[]{ WebConfig.class };
    }


    //getServletMappings overriding이 DispatcherServlet을 설정하는것을 포함한다.
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/"};
    }
}
