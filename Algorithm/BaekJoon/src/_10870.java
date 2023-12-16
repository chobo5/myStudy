import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10870 {

    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        System.out.println(fibonacci(n));
    }

    static int fibonacci(int num) {
        if (num > 1) {
            result += num;
            return fibonacci(num - 1) + fibonacci(num - 2);
        } else if (num == 1){
            return 1;
        } else {
            return 0;
        }
    }
}
