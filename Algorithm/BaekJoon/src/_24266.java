import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _24266 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(in.readLine());
        in.close();
        System.out.println(n * n * n);
        System.out.println(3);
    }
}
