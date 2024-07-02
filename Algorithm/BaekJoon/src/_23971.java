import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _23971 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int a = 1;
        int countA = 0;
        int b = 1;
        int countB = 0;
        while (a <= h) {
            a += (n + 1);
            countA++;
        }

        while (b <= w) {
            b += (m + 1);
            countB++;
        }

        System.out.println(countA * countB);
    }
}
