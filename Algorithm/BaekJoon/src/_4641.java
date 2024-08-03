import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _4641 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int count = 0;
            st = new StringTokenizer(in.readLine(), " ");
            int length = st.countTokens() - 1;
            if (length == 0) {
                break;
            }
            Map<Integer, Integer> map = new HashMap<>();
            int index = 0;
            while (index < length) {
                map.put(Integer.parseInt(st.nextToken()), 1);
                index++;
            }
            for (Map.Entry e : map.entrySet()) {
                if (map.getOrDefault((((int) e.getKey()) * 2), 0) == 1) {
                    count++;
                }
            }
            sb.append(count).append("\n");


        }
        System.out.println(sb);
    }

}
