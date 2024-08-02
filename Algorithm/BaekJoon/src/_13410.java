import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13410 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        in.close();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int max = 0;
        for (int i = 1; i <= k; i++) {
            int x = n * i;
            max = Math.max(max, reverse(x));
        }
        System.out.println(max);


    }

    static int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            int remain = x % 10;
            x /= 10;
            sb.append(remain);
        }
        return Integer.parseInt(sb.toString());
    }
}
