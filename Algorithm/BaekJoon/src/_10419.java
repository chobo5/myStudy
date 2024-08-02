import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10419 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int d = Integer.parseInt(in.readLine());
            sb.append(calculate(d)).append("\n");
        }
        System.out.println(sb);


    }

    static int calculate(int d) {
        int t = 0;
        while (d - t - (t*t) >= 0) {
            t++;
        }
        return t - 1;
    }
}
