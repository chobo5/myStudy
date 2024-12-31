import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer( in.readLine(), " ");
        in.close();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

    }
}