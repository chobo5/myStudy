import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11170 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(countZero(n, m)).append("\n");
        }
        System.out.println(sb);



    }

    static int countZero(int n, int m) {
        int count = 0;
        for (int i = n; i <= m; i++) {
            int num = i;
            while (num > 0) {
                if (num % 10 == 0) {
                    count++;
                }
                num /= 10;
            }
        }
        if (n == 0) {
            count++;
        }
        return count;
    }
}
/*
1005
1005 % 10 = 5
1005/10 = 100%10 = 0

 */
