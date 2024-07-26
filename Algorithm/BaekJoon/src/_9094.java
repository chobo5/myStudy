import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9094 {
    public static void main(String[] args) throws IOException {
        BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int j = 2; j < n; j++) { //b의 값
                for (int k = 1; k < j; k++) { //a의 값
                    if (calculate(k, j, m)) {
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);

    }

    static boolean calculate(int a, int b, int m) {
        return (a * a + b * b + m) % (a * b) == 0;

    }
}
