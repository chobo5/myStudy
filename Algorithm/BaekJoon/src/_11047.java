import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coinPocket = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            coinPocket[i] = Integer.parseInt(in.readLine());
        }

        for (int i = n -1; i >= 0 ; i--) {
            if (k >= coinPocket[i]) {
                count += k / coinPocket[i];
                k = k % coinPocket[i];
            }
        }

        System.out.println(count);
    }

}
