package com.example.spring01;

import com.example.spring01.component.MyDao;
import com.example.spring01.component.MyService;
import com.example.spring01.component.MyUtil;
import exam.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplicationContextExam03 {
    public static void main(String[] args) {
        //AnnotationConfigApplicationContext의 생성자에는 보통 기본 package가 들어간다.
        ApplicationContext context = new AnnotationConfigApplicationContext("com.example.spring01");
        Book book1 = context.getBean("book1", Book.class);
        book1.setTitle("AnnotationConfigApplicationContext 학습");
        book1.setPrice(4000);

        System.out.println(book1.getTitle() + " " + book1.getPrice());

        Book book11 = context.getBean("book1", Book.class);
        System.out.println(book11.getTitle() + " " + book11.getPrice()); //기본적으로 singleton

        Book book22 = context.getBean("book2", Book.class);
        System.out.println(book22.getTitle() + " " + book22.getPrice());

        MyDao myDao = context.getBean("myDao", MyDao.class);
        myDao.get();

        MyService myService = context.getBean("myService2", MyService.class);
        myService.service(); //NullPointerException

//        MyUtil myUtil = context.getBean("myUtility", MyUtil.class);
//        myUtil.print();
        MyUtil myUtil = context.getBean("myUtil", MyUtil.class); //@Component로 생성된 Bean을 해당 class type으로 가져온다.
        myUtil.print();

    }
}
