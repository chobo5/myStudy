package exam02;

import exam.Book;
import exam02.component.MyDao;
import exam02.component.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContextExam2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyDao myDao = context.getBean("myDao",MyDao.class);
        MyService myService = context.getBean("myService", MyService.class);
        myService.service();




    }

}
