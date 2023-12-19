import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9461 {
    static long[] pArray = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();

        pArray[1] = 1;
        pArray[2] = 1;
        pArray[3] = 1;
        pArray[4] = 2;
        pArray[5] = 2;
        pArray[6] = 3;
        pArray[7] = 4;
        pArray[8] = 5;
        pArray[9] = 7;
        pArray[10] = 9;

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(in.readLine());
            sb.append(P(n)).append("\n");
        }

        System.out.println(sb);
    }

    static long P(int n) {
        if (pArray[n] != 0) {
            return pArray[n];
        } else {
            for (int i = 11; i <= n; i++) {
                pArray[i] = pArray[i - 1] + pArray[i - 5];
            }
            return pArray[n];
        }
    }
}
