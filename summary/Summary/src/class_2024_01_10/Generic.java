package class_2024_01_10;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Generic {
    static class A {}
    static class B1 extends A {}
    static class B2 extends A {}
    static class C extends B1 {}
    /*
     *   Object
     *     |
     *     A
     *    / \
     *   B1 B2
     *   |
     *   C
     */

    static class Box<T> {
        void set(T obj) {}
    }

    public static void main(String[] args) {
        Box<? extends B1> box1;

        //    box1 = new Box<Object>(); // 컴파일 오류!
        //    box1 = new Box<A>(); // 컴파일 오류!
        box1 = new Box<B1>();
        box1 = new Box<C>();


        Box<? super B1> box2;
        box2 = new Box<A>();
        box2 = new Box<B1>();

        List<Object> list1 = new ArrayList<>();
        list1.add(new Object());
        list1.add(new String());
        list1.add(new Date());

        List<?> list2 = new ArrayList<>();
        //list2.add(new String());
        //list2.add(new Object());
        //즉 ArrayList의 타입 파라미터가 설정되어 있지 않기 때문에
        // add() 메서드의 파라미터 타입을 알 수 없다.
        // 그래서 add()를 호출할 때 어떤 타입이 유효한 문법인지 컴파일러는 알 수 없어서
        // 컴파일 오류를 발생시킨다.

        List<? extends B1> list3 = new ArrayList<>();
        //list3.add(new A());
        //list3.add(new B1());
        //list3.add(new C());
        // 파라미터로 받은 ArrayList가 구체적으로 어떤 타입의 값을 다루는 것인지
        // 결정되지 않았기 때문에 컴파일러는 다음 코드가 옳은지 검사할 수 없다.
        // 그래서 컴파일 오류가 발생한다.

        List<? super B1> list4 = new ArrayList<>();
//        list4.add(new A());
        list4.add(new B1());
        list4.add(new C());

        List<B1> list5 = new ArrayList<>();
        list5.add(new B1());
        list5.add(new C());
    }

}
