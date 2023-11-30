package practice;

public class CallByReference {
    static class MyObject {
        int a;
        int b;
    }

    static MyObject swap(int a, int b) {
        MyObject ref = new MyObject();
        ref.a = b;
        ref.b = a;
        return ref;
    }

    public static void main(String[] args) {
        int a = 100;
        int b = 200;

        MyObject ref = swap(a, b);

        System.out.printf("main(): ref.a=%d, ref.b=%d\n", ref.a, ref.b);
    }
}
