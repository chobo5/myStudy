package class_2024_01_09;

public class Lambda3 {
    static interface Calculator {
        int compute(int a, int b);
    }

    static class MyCalculator {
        public static int plus(int a, int b) {return a + b;}
        public static int minus(int a, int b) {return a - b;}
        public static int multiple(int a, int b) {return a * b;}
        public static int divide(int a, int b) {return a / b;}

        public static int power(int a) {return 2 * a;}
    }


    public static void main(String[] args) {
        // 1.
        Calculator obj1 = new Calculator() {
            @Override
            public int compute(int a, int b) {
                return a * b;
            }
        };

        // 2.
        Calculator obj2 = (a, b) -> a * b;

        // 기존에 작성한 클래스의 스태틱 메서드를 재활용하기
        // => 인터페이스의 메서드 규격과 일치하는 메서드가 있다면,
        //    그 메서드를 람다 구현체로 대체할 수 있다.
        // => 새로 코드를 작성할 필요가 없어 매우 편리하다.
        // => 규격? 메서드의 파라미터 타입/개수/순서, 리턴 타입
        // => 문법:
        //    클래스명::메서드명
        // 3.
        Calculator obj3 = (a, b) -> MyCalculator.plus(a, b);

        // 4.
        Calculator obj4 = MyCalculator::plus;
        System.out.println(obj4.compute(1, 2));

        Calculator obj5 = MyCalculator::minus;
        Calculator obj6 = MyCalculator::multiple;
        Calculator obj7 = MyCalculator::divide;
//        Calculator obj8 = MyCalculator::power; //규격이 다르므로 에러






    }


}
