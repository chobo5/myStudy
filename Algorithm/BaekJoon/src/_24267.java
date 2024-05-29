import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _24267 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(in.readLine());
        in.close();
        long count = 0;
        for (int i = 1; i <= n - 2 ; i++) {
            count += i * (n - 1 - i);
        }
        System.out.println(count);
        System.out.println(3);

    }
}
