package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        long n = Long.parseLong(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        long constantSum = 0;

        for (int i = 1; i <= l - 1; i++) {
            constantSum += i;
        }

        long rest = n - constantSum;

        while (rest % l != 0) {
            rest -= l;
            l++;
            if (l > 100 || rest < 0) {
                System.out.println(-1);
                return;
            }
        }

        long x = rest / l;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l; i++) {
            sb.append(x + i);
            if (i < l - 1) sb.append(" ");
        }
        System.out.println(sb);
    }
}
