package class_2024_01_09;

public class Lambda2 {
    //----------- functional interface의 자격 -----------
    //1. 추상 메서드가 2개이상이면 람다 문법으로 구현할 수 없다.
    //2. 여러개의 메서드가 있다 하더라도 추상메서드가 1개이면 람다문법 적용 가능하다.
    //3. 인터페이스가 아닌 추상클래스는 람다 구현의 대상이 아니다.

    //----------- 아규먼트에 람다 활용 -----------
    static interface Player {
        void play();
    }

    static interface Calculator {
        int compute(int a, int b);
    }

    static void testPlayer(Player player) {
        player.play();
    }

    public static void main(String[] args) {
        // 1.
        class MyPlayer implements Player {
            @Override
            public void play() {
                System.out.println("play");
            }
        }

        MyPlayer myPlayer = new MyPlayer();
        testPlayer(myPlayer);

        // 2.
        Player player = new Player() {
            @Override
            public void play() {
                System.out.println("play");
            }
        };
        testPlayer(player);

        //3.
        //객체를 한번만 사용하는 경우
        testPlayer(new Player() {
            @Override
            public void play() {
                System.out.println("play");
            }
        });

        //4.
        Player player1 = () -> System.out.println("play");
        testPlayer(player1);

        //5.
        testPlayer(() -> System.out.println("play"));


        //연습 문제
        Calculator c1 = (a, b) -> a * b;

        Calculator c2 = new Calculator() {
            @Override
            public int compute(int a, int b) {
                return a * b;
            }
        };

        class MyCalculator implements Calculator {
            @Override
            public int compute(int a, int b) {
                return a * b;
            }
        }










    }
}
