package exam02;

import exam.Book;
import exam02.component.MyService;
import exam02.component.MyUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplicationContextExam3 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("exam02");

        Book book = context.getBean("book3", Book.class);
        book.setTitle("자바 코딩 문제집");
        book.setPrice(35000);
        System.out.println(book);

        Book book2 = context.getBean("book3", Book.class);
        System.out.println(book2);

        MyService myService = context.getBean("service", MyService.class);
        myService.service();

        MyUtil myUtil = context.getBean(MyUtil.class);
        myUtil.print();
    }
}
