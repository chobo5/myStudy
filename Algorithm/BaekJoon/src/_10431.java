import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            String num = st.nextToken();
            sb.append(num).append(" ");
            for (int j = 0; j < 20; j++) {
                int height = Integer.parseInt(st.nextToken());
            }
        }

    }
}
