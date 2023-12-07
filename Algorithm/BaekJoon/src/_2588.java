import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        br.close();


        int b1 = b % 10 * a;
        int b2 =    b / 10 % 10 * a;
        int b3 = b / 100 * a;
        int result = a * b;
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(result);
    }
}
