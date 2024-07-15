import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        in.close();
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int e = 1;
        int s = 1;
        int m = 1;

        int answer = 1;

        while(true) {
            if (e == E && s == S && m == M) {
                break;
            }
            e = (e + 1) % 16 == 0 ? 1 : (e + 1) % 16;
            s = (s + 1) % 29 == 0 ? 1 : (s + 1) % 29;
            m = (m + 1) % 20 == 0 ? 1 : (m + 1) % 20;
            answer++;
        }
        System.out.println(answer);
    }
}
