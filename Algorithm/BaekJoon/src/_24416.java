import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _24416 {
    static int count1 = 0;
    static int count2 = 0;
    static int[] f = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        fib(n);
        fibonacci(n);

        System.out.println(count1 + " " + count2);


    }

    static int fib(int num) {

        if (num == 1 || num == 2) {
            count1 += 1;
            return 1;
        } else {
            return fib(num -1) + fib(num -2);
        }
    }

    static int fibonacci(int num) {
        f[1] = 1;
        f[2] = 1;
        for (int i = 3; i <= num; i++) {
            f[i] = f[i - 1] + f[i - 2];
            count2 += 1;
        }
        return f[num];
    }


}
