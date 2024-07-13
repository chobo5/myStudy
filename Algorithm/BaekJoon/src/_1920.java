import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            map.put(x, 1);
        }

        int m = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int y = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(y, 0)).append("\n");
        }
        System.out.println(sb);
    }
}
