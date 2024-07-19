import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(in.readLine());
        long F = Long.parseLong(in.readLine());
        in.close();

        long initN = (N / 100) * 100;
        for (int i = 0; i <= 99; i++) {
            if ((initN + i) % F == 0) {
                String answer = i < 10 ? "0"+i : String.valueOf(i);
                System.out.println(answer);
                break;
            }
        }
    }
}
