package class_2024_01_09;

public class Lambda {

    //메서드가 1개인 인터페이스를 functional interface라고 부른다.
    interface Player {
        void play(String name, int age);
    }

    interface  Calculator {
        int compute(int a, int b);
    }

    interface A {
        void print();
    }

    public static void main(String[] args) {

        //Player 인터페이스를 구현한 익명 클래스
//       Player p1 = new Player() { //superclass의 생성자에 해당하는 parameter를 넘겨 줄 수 있다.
           //기본 생성자가 생성되고 기본생성자가 superclass의 생성자를 호출한다.

//           @Override
//           public void play(String name) {
//               System.out.println("play");
//           }
//       };

       // 람다문법으로 인터페이스 구현하기
        // 1. interface 껍데기 제거
        // 2. new Player생략
        // 3. -> 추가
        // 4. 메서드 바로 구현
//        Player p2 = () -> System.out.println("lambda play" + x + y);
//        p2.play();
        // 컴파일러는 람다 코드를 .class파일이 아닌 메서드로
        // 컴파일러는 람다코드를 해당 클래스의 static 메서드로 정의한다.


        // 파라미터가 한개일 경우 type과 괄호가 생략 가능하다.
//        Player p3 = name -> System.out.println("player " + name);
//        p3.play("hong");


        //파라미터가 2개 일떄 - 괄호 생략 안됨
        Player p4 = ((name, age) -> System.out.println(name + age));


        ///-------------------리턴값이 있을때--------------------

        Calculator c1 = new Calculator() {
            @Override
            public int compute(int a, int b) {
                return a * b;
            }
        };
        c1.compute(100, 100);

        Calculator c2 = (int a, int b) -> {
            return a * b;
        };

        //return 생략 가능
        Calculator c3 = (a ,b) -> a * b;

















    }

    //------------익명 클래스를 사용할 수 있는 곳에는 모두 람다 사용 가능------------

    // 스태틱 필드
    static A obj1 = new A() {
        @Override
        public void print() {
            System.out.println("스태틱 필드");
        }
    };

    static A obj2 = () -> System.out.println("스태틱 필드");

    //인스턴스 필드
    A obj3 = new A() {
        @Override
        public void print() {
            System.out.println("인스턴스 필드");
        }
    };
    A obj4 = () -> System.out.println("인스턴스 필드");



    static void m2(final A obj) {
        obj.print();
    }

    static A m2() {
        // 리턴 문장
        return () -> System.out.println("리턴 문장");
    }

}
