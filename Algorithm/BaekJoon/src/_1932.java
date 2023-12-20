import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] tri = new int[n][n + 1];
        StringTokenizer st = new StringTokenizer(in.readLine());
        tri[0][0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            String line = in.readLine();
            st = new StringTokenizer(line, " ");
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 ) {
                    int x = Integer.parseInt(st.nextToken());
                    tri[i][j] = x + tri[i - 1][0];
                } else if (j == i) {
                    int x = Integer.parseInt(st.nextToken());
                    tri[i][j] = x + tri[i - 1][j - 1];
                } else {
                    tri[i][j] = Integer.parseInt(st.nextToken()) + Math.max(tri[i-1][j-1], tri[i - 1][j]);
                }
            }
        }

        int[] lastLine = tri[n - 1];
        Arrays.sort(lastLine);
        System.out.println(lastLine[n]);








    }
}
