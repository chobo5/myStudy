import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2386 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(in.readLine(), " ");
            String x = st.nextToken();
            if (x.equals("#")) {
                break;
            }
            sb.append(x).append(" ");
            int count = 0;
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (c == x.charAt(0) || c == Character.toUpperCase(x.charAt(0))) {
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");

        }
        System.out.println(sb);
    }
}
