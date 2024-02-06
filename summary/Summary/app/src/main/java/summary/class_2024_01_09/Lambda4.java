package class_2024_01_09;

import java.util.function.Predicate;

public class Lambda4 {

    public static void main(String[] args) {

        //Predicate<String> 인터페이스 구현체 준비하기


        // 1) 로컬 클래스로 인터페이스 구현체 만들기
        class MyPredicate<T> implements Predicate<T> {
            @Override
            public boolean test(T value) {
                return ((String)value).isEmpty();
            }
        }
        Predicate<String> p1 = new MyPredicate<>();
        System.out.println(p1.test(""));
        System.out.println(p1.test("Hello!"));

         //2) 익명 클래스로 인터페이스 구현체 만들기
        Predicate<String> p2 = new Predicate<>() {
            @Override
            public boolean test(String value) {
                return value.isEmpty();
            }
        };
        System.out.println(p2.test(""));
        System.out.println(p2.test("Hello!"));


        //3) 람다로 인터페이스 구현체 만들기
        Predicate<String> p3 = value -> value.isEmpty();
        System.out.println(p3.test(""));
        System.out.println(p3.test("Hello!"));

        //4) 메서드 레퍼런스를 사용하여 기존 클래스의 메서드를 인터페이스 구현체로 사용하기
        String s1 = "";
        String s2 = "Hello!";
//        Predicate<String> p4 = s1::isEmpty; //컴파일 오류


        Predicate<String> p4 = String::isEmpty;
        //이전의 방식으로 생각하면 위 코드는 다음의 코드로 변경되어야 한다.
//        Predicate<String> p5 = (String value) -> { return String.isEmpty(value); };
        //즉, 컴파일 오류가 발생해야 한다.
        //이유 1. isEmpty() 메서드 static 메서드가 아니기 때문에 static 메서드처럼 호출하면 오류가 발생해야한다.
        //이유 2. isEmpty()는 파라미터가 없기 때문에 String 값을 받을 수 없다.
        //그러나 컴파일 오류가 발생하지 않는다.

        //인터페이스의 타입 파라미터에 전달하는 클래스와 메서드 레퍼런스로 전달하는 클래스가 같을때
        //위 코드는 다음과 같이 변경된다.
        Predicate<String> p5 = (String value) -> { return value.isEmpty(); };



//        Predicate<String> p6 = My::m; //컴파일 오류
        // 1) m()는 스태틱 메서드가 아니다.
        // 2) m()는 파라미터가 없다.

//        My obj = new My();
//        Predicate<String> p7 = obj::m; //컴파일 오류
        // 1) My의 m()는 파라미터를 못받는다.

        Predicate<My> p8 = My::m; //ok
        //타입 파라미터의 클래스가 인스턴스 메서드의 클래스랑 같다면,
        //다음과 같이 람다 문법으로 변경된다.
        Predicate<My> p9 = (My my) -> { return my.m(); };
    }

    static class My {
        public boolean m() {
            return true;
        }
    }
}
