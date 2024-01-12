package lambda;

public class Lambda {
  //람다식: (매개변수...) -> { 처리 내용 }
  //자바 컴파일러는 람다식을 익명 구현 객체로 변환한다.

  interface Calculable {
    void calculate(int x, int y);
  }

  interface Calculable2 {
    double calculate(double x, double y);
  }

  public static void main(String[] args) {
    //--------------------람다식을 변수에 대입--------------------
    Calculable c1 = new Calculable() {

      @Override
      public void calculate(int x, int y) {
        System.out.println("x + y = " + (x + y));
      }
    };


    //실행문이 하나이므로 중괄호 생략 가능하다.
    Calculable c2 = (x, y) -> System.out.println("x + y = " + (x + y));


    //--------------------람다식을 매개변수에 대입--------------------
    action((x, y) -> {
      int result = x + y;
      System.out.println(result);
    });
    //아래의 코드가 매개변수 이다. 즉, parameter로 x, y를 받아 연산을 하는 익명 구현 객체 람다식을 넣어주었다.
//        (x, y) -> {
//            int result = x + y;
//            System.out.println(result);
//        }

    //--------------------매개변수가 없는 람다식--------------------
    Person person = new Person();

    person.action(() -> {
      System.out.println("출근합니다.");
      System.out.println("일하는 중");
    });

    person.action(() -> System.out.println("퇴근합니다."));

    Button okButton = new Button();
    okButton.setClickListener(() -> System.out.println("okButton Clicked"));
    okButton.click();


    //--------------------매개변수가 있는 람다식--------------------
    Person2 person2 = new Person2();
    person2.action(((name, job) -> System.out.println(name + "의 직업은 " + job + "입니다.")));
    person2.action2((content) -> System.out.println(content + " 말을한다."));


    //--------------------리턴값이 있는 람다식--------------------
    //return문 하나만 있을 경우 return키워드를 생략할 수 있다.
    person2.action3((x, y) -> x + y);

    //--------------------메소드 참조--------------------
    Person3 person3 = new Person3();
    person3.ordering(String::compareToIgnoreCase);

    Member m1 = person3.getMember1(Member::new);

    Member m2 = person3.getMember1(Member::new);


  }

  static void action(Calculable cal) {
    int x = 10;
    int y = 4;
    cal.calculate(x, y);
  }


}
