import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Map<Integer, Integer> hashMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (hashMap.containsKey(x)) {
                hashMap.put(x, hashMap.get(x) + 1);
                continue;
            }
            hashMap.put(x, 1);
        }

        int m = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine(), " ");
        in.close();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            int num = hashMap.get(x) == null ? 0 : hashMap.get(x);
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }



}
