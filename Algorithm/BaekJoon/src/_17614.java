import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17614 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n + 1];
        int count = 0;

        for (int i = 1; i <= n; i++) {
            int st1 = i % 10;
            if (st1 == 3 || st1 == 6 || st1 == 9) {
                count++;
            }
            if (i > 10) {
                int st2 = (i / 10) % 10;
                if (st2 == 3 || st2 == 6 || st2 == 9) {
                    count++;
                }
            }
            if (i > 100) {
                int st2 = (i / 100) % 10;
                if (st2 == 3 || st2 == 6 || st2 == 9) {
                    count++;
                }
            }
            if (i > 1000) {
                int st2 = (i / 1000) % 10;
                if (st2 == 3 || st2 == 6 || st2 == 9) {
                    count++;
                }
            }

            if (i > 10000) {
                int st2 = (i / 10000) % 10;
                if (st2 == 3 || st2 == 6 || st2 == 9) {
                    count++;
                }
            }
            if (i > 100000) {
                int st2 = (i / 100000) % 10;
                if (st2 == 3 || st2 == 6 || st2 == 9) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
