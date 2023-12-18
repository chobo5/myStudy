import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] A = new int[n][m];
        int[][] B = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = in.readLine();
            st = new StringTokenizer(line, " ");
            for (int j = 0; j < m; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String line = in.readLine();
            st = new StringTokenizer(line, " ");
            for (int j = 0; j < m; j++) {
                B[i][j] = Integer.parseInt(st.nextToken()) + A[i][j];
                sb.append(B[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);







    }
}
