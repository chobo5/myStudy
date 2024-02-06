package exam02;

import exam.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContextExam {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book = context.getBean("book2", Book.class);
        book.setTitle("헤드퍼스트 디자인패턴");
        book.setPrice(35000);

        Book otherBook = context.getBean("book3", Book.class);
        if (book == otherBook) {
            System.out.println("같은 인스턴스");
        } else {
            System.out.println("다른 인스턴스");
        }


    }

}
