public class VairablesAndType {
    // 변수는 하나의 값을 저장할 수 있는 메모리 번지에 붙여진 이름이다.
    // 코드에서 프로그래머가 직접 입력한 값을 리터럴(literal)이라고 한다.
    public static void main(String[] args) {
        int x = 0b1011; //2진수
        System.out.println(x);
        x = 0206; //8진수
        System.out.println(x);
        x = 0xB3; //16진수
        System.out.println(x);
        x = 0xb3;
        System.out.println(x);
        int y = 0x2A0F;
        System.out.println(y);

        long l = 1000000000000000000L;

        char a = 'A';
        System.out.println(a);
        char a1 = 65;
        System.out.println(a1);


        //2.7 타입 변환
        //byte -> short, char -> int -> long -> float -> double 으로
        //컴파일러가 자동 형변환이 가능하다
        //하지만 byte -> char는 형변환이 불가하다 왜냐하면 char는 음수를 포함하지 않기 때문이다.

        //2.8 강제 타입변환
        //변환하고자 하는 타입의 크기만큼만 잘라 형변환이 이루어진다.
        //원본 값이 보존되지 않을 수 있다.

        //2.9 연산식에서 자동 타입변환
        byte result = 10 + 20; // 컴파일러가 10 + 20을 미리 계산하고 해당값을 result변수에 저장한다.

        byte b1 = 10;
        byte b2 = 20;
//        byte result = b1 + b2; //b1, b2가 int 타입으로 변환되어 연산되고 결과는 int type이므로 컴파일 에러가 발생
        // int타입보다 허용범위가 작은 타입은 int타입으로 변환되어 연산되지만 허용범위가 크다면 해당타입 그대로 연산된다.
        int result1 = b1 + b2;

        char c1 = 10;
        char c2 = 20;
//        char result2 = c1 + c2; //컴파일 에러

        short s1 = 10;
        short s2 = 20;
//        short result3 = s1 + s2; //컴파일 에러

        int i1 = 10;
        int i2 = 20;
        int result5 = i1 + i2;



    }
}
