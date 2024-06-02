import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n + m; i++) {
            String str = in.readLine();
            if (i >= n -1 && set.contains(str)) {
                list.add(str);
                continue;
            }
            set.add(str);
        }

        list.sort(((o1, o2) -> {
            int length = o1.length() > o2.length() ? o2.length() : o1.length();
            for (int i = 0; i < length; i++) {
                if (o1.charAt(i) == o2.charAt(i)) {
                    continue;
                }
                return o1.charAt(i) - o2.charAt(i);
            }
            return 0;
        }));

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");

        list.forEach(str -> sb.append(str).append("\n"));
        System.out.println(sb);

    }
}
