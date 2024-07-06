import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(in.readLine());
        in.close();
        long minus = 1;
        int answer = 0;
        while (n >= minus) {
            n -= minus;
            minus++;
            answer++;
        }

        System.out.println(answer);
    }
}
