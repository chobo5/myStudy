import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2292 {
    public static void main(String[] args) throws IOException {
        //1 1개  1
        // 2 3 4 5 6 7 6개   2
        // 8 9 10 11 12 13 14 15 16 17 18 19 12개    3
        // 20 ~ 37 18개  4
        // 38 ~ 61 24개  5
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int x = 0;
        while (n > 0) {
            n = n - (6 * x);
            System.out.println("n은" + n);
            x++;
            if (n == 1) break;
            System.out.println("x는" + x);
        }
        System.out.print(x);


    }
}
