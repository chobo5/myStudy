package com.example.spring01;

import exam.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContextExam {
    public static void main(String[] args) {
        //인스턴스를 인터페이스 타입으로 참조할 수 있다.
        //interface 타입으로 참조된 인스턴스를 구현 클래스 타입으로 형변환하여 사용한다.
        //CLASSPATH에서 xml 설정파일을 읽어들여 동작한다.
        //resources안에 만들어져 있어야한다.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); //xml 설정파일 넣어주도록 되어있다.
        Book book1 = (Book) context.getBean("book1"); //직접 형변환
        book1.setTitle("Spring 배우기");
        book1.setPrice(5000);

        System.out.println(book1.getTitle() + " " + book1.getPrice());

//        Book book2 = (Book) context.getBean("book1");
        Book book2 = context.getBean("book1", Book.class); //class 타입 명사
        System.out.println(book2.getTitle() + " " + book2.getPrice());

        Book book3 = context.getBean("book2", Book.class);
        //id가 다르고 같은 클래스를 참조하면 다른 인스턴스를 만들어준다.
        System.out.println(book3.getTitle() + " " + book3.getPrice());


    }
}
