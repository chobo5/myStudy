package com.example.spring01.component;

import org.springframework.stereotype.Component;

//AnnotationConfigApplicationContext가 @Component를 찾아서 인스턴스를 생성한다.(Component Scan 방식)
@Component(value = "myUtil") //id를 설정할 수도 있다
public class MyUtil {

    public MyUtil() {
        System.out.println("MyUtil 생성자"); //AnnotationConfigApplicationContext가 내부적으로 관리하면서 생성자가 호출
    }

    public void print() {
        System.out.println("MyUtil.print()");
    }
}
