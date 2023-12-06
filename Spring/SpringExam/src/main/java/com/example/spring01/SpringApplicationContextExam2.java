package com.example.spring01;

import com.example.spring01.component.MyDao;
import com.example.spring01.component.MyService;
import exam.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContextExam2 {
    public static void main(String[] args) {
        //인스턴스를 인터페이스 타입으로 참조할 수 있다.
        //interface 타입으로 참조된 인스턴스를 구현 클래스 타입으로 형변환하여 사용한다.
        //CLASSPATH에서 xml 설정파일을 읽어들여 동작한다.
        //resources안에 만들어져 있어야한다.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); //xml 설정파일 넣어주도록 되어있다.
        MyService myService = context.getBean("myService", MyService.class);
        MyDao myDao = context.getBean("myDao", MyDao.class);

        //개발자가 직접 myDao를 myService에 주입
//        myService.setMyDao(myDao);
        //xml파일에서 선언적으로 의존성 주입했음
        myService.service();
    }
}
