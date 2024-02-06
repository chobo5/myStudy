package class_2024_01_09;


import java.util.*;
import java.util.function.Consumer;

public class Lambda5 {
    interface ListFactory {
        List create();
    }
    public static void main(String[] args) {
        // 인터페이스에 정의된 메서드가
        // 생성자의 형식과 일치하다면
        // 메서드 레퍼런스로 생성자를 지정할 수 있다.
        //
        // 1) 익명 클래스로 인터페이스 구현
//            ListFactory f1 = new ListFactory() {
//              public List create() {
//                return new ArrayList();
//              }
//            };

        // 2) 람다 문법으로 인터페이스 구현
//            ListFactory f1 = () -> new ArrayList();

        // 3) 메서드 레퍼런스로 인터페이스 구현
        ListFactory f1 = ArrayList::new; //생성자

        // 인터페이스의 메서드를 호출하면
        // 지정된 클래스의 인스턴스를 만든 후 생성자를 호출한다.
        List list = f1.create(); // new ArrayList();

        System.out.println(list instanceof ArrayList);
        System.out.println(list.getClass().getName());


        //반복문
        ArrayList<String> names = new ArrayList<>();
        names.add("홍길동");
        names.add("임꺽정");
        names.add("유관순");
        names.add("김구");
        names.add("안중근");

//        class MyConsumer<T> implements Consumer<T> {
//            @Override
//            public void accept(T item) {
//
//                System.out.println(item);
//
//            }
//        }


//        names.forEach(new MyConsumer<String>());

//        names.forEach(item -> System.out.println(item));
        names.forEach(System.out::println);
    }
}
