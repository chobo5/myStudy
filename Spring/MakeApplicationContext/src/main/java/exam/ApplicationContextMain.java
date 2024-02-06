package exam;

public class ApplicationContextMain {
    public static void main(String[] args) {
        ApplicationContext context = ApplicationContext.getInstance();
        Book book1 = (Book) context.getBean("book1");
        book1.setTitle("이것이 자바다");
        book1.setPrice(30000);
        System.out.println("book1");
        System.out.println(book1);


        Book book2 = (Book) context.getBean("book1");
        System.out.println("book2");
        System.out.println(book2);

        if (book1 == book2) {
            System.out.println("book1과 book2는 같은 인스턴스");
        }

        //스프링은 같은 인스턴스가 나온다.
        //어떻게 할까?
        //=> key(id) value(object)로 저장하며 중복을 제거하는 HashMap에 담아 사용한다.
        //=> 메모리에 1개만 생성된다 -> Singleton 패턴

        //또한 객체를 관리해주는 ApplicationContext가 메모리에 하나만 올라오도록 해야한다.

    }
}
