package exam;

public class ApplicationContextMain {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = ApplicationContext.getInstance();
        Book book = (Book)context.getBean("book1");
        book.setTitle("Spring");
        book.setPrice(5000);
        System.out.println("book1 " + book.getTitle() + " " + book.getPrice());

        Book book2 = (Book)context.getBean("book1");
        System.out.println("book2 " + book2.getTitle() + " " + book.getPrice());
        //내부적으로 getBean()을 실행할때 마다 instace를 새로 생성한다.
        if (book == book2) {
            System.out.println("같은 인스턴스");
        } else {
            System.out.println("다른 인스턴스"); //이게 나옴
        }
        //스프링은 같은 인스턴스가 나온다.
        //어떻게 할까?
        //=> key(id) value(object)로 저장하며 중복을 제거하는 HashMap에 담아 사용한다.
        //=> 메모리에 1개만 생성된다 -> Singleton 패턴

        //또한 객체를 관리해주는 ApplicationContext가 메모리에 하나만 올라오도록 해야한다.



    }
}
