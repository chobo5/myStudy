package com.example.spring01.config;

import com.example.spring01.component.MyDao;
import com.example.spring01.component.MyService;
import com.example.spring01.component.MyUtil;
import exam.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //Java Config 설정을 AnnotationConfigApplicationContext가 읽어들인다.
public class ApplicationConfig {
    public ApplicationConfig() {
        System.out.println("ApplicationConfig 생성");
    }

    @Bean
    public Book book1() { //메서드 이름 = id
        return new Book(); //리턴 받은 객체를 SpringContainer가 내부적으로 관리한다.
    }

    @Bean
    public Book book2() {
        Book book = new Book();
        book.setTitle("book의 새로운 instance");
        book.setPrice(7000);
        return book;
    }

    @Bean(name = "myService2") //bean id가 된다. 안넣어주면 method의 이름이 id
    public MyService myService(MyDao myDao) { //Spring Container가 id가 myDao인 MyDao를 먼저 생성하고 parameter로 넘겨준다
        MyService myService = new MyService();
        myService.setMyDao(myDao);
        return myService;
    }

    @Bean
    public MyDao myDao() {
        return new MyDao();
    }


//    @Bean(name = "myUtility")
//    public MyUtil myUtil() {
//        return new MyUtil();
//    }
    //이렇게 따로 설정파일 내부에서 설정할 수도 있지만 해당 파일에서 직접 annotation을 이용해 설정할 수도 있다.
    //MyUtil.java 파일로 이동

}
