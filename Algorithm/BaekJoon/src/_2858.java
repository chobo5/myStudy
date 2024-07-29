import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2858 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int red = Integer.parseInt(st.nextToken());
        int brown = Integer.parseInt(st.nextToken());
        int total = red + brown;
        int start = (int) Math.ceil(Math.sqrt(total));
        int L = 0;
        int W = 0;
        for (int i = start; i <= total; i++) {
            if (total % i == 0) {
                L = Math.max(i, total / i);
                W = total / L;
                if ((L - 2) * (W - 2) == brown) {
                    System.out.println(L + " " + W);
                    return;
                }
            }
        }
    }
}
