import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String dna = in.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = dna.charAt(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int a = 0;
            int t = 0;
            int g = 0;
            int c = 0;
            for (int j = 0; j < n; j++) {
                char ch = arr[j][i];
                if (ch == 'A') {
                    a++;
                } else if (ch == 'T') {
                    t++;
                } else if (ch == 'G') {
                    g++;
                } else {
                    c++;
                }
            }
            int[] temp = {a, t, g, c};
            Arrays.sort(temp);
            if (temp[3] == a) {
                sb.append("A");
            } else if(temp[3] == c) {
                sb.append("C");
            } else if (temp[3] == g) {
                sb.append("G");
            } else {
                sb.append("T");
            }

            for (int j = 0; j < 3; j++) {
                sum += temp[j];
            }

        }
        System.out.println(sb);
        System.out.println(sum);
    }
}
