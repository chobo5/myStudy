import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10214 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int yonsei = 0;
            int korea = 0;
            for (int j = 0; j < 9; j++) {
                st = new StringTokenizer(in.readLine());
                yonsei += Integer.parseInt(st.nextToken());
                korea += Integer.parseInt(st.nextToken());
            }
            if (yonsei > korea) {
                sb.append("Yonsei").append("\n");
            } else if (yonsei == korea) {
                sb.append("Draw").append("\n");
            } else {
                sb.append("Korea").append("\n");
            }
        }
        System.out.println(sb);
    }
}
