package lambda;

public class Person2 {
    public void action(Workable2  workable2) {
        workable2.work("홍길동", "프로그래머");
    }

    public void action2(Speakable  speakable) {
        speakable.speak("아아아아");
    }

    public void action3(Lambda.Calculable2 calculable2) {
        double result = calculable2.calculate(10, 4);
        System.out.println("결과: " + result);
    }

}
