import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> wordAndCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = in.readLine();
            if (word.length() < m) {
                continue;
            }
            int count = wordAndCount.get(word) == null ? 1 : wordAndCount.get(word) + 1;

            wordAndCount.put(word, count);
        }

        List<Map.Entry<String, Integer>> words = new ArrayList<>(wordAndCount.entrySet());

        words.sort(((o1, o2) -> {
            if (o1.getValue() != o2.getValue()) {
                return o2.getValue() - o1.getValue();
            }

            if (o1.getKey().length() != o2.getKey().length()) {
                return o2.getKey().length() - o1.getKey().length();
            }

            return o1.getKey().compareTo(o2.getKey());

        }));

        StringBuilder sb = new StringBuilder();
        words.forEach(e -> sb.append(e.getKey()).append("\n"));

        System.out.println(sb);




    }


}
