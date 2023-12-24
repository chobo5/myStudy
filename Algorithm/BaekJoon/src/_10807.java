import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String line = in.readLine();
        int v = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(line, " ");

        int count = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (v == x) {
                count++;
            }
        }

        System.out.println(count);
    }
}
