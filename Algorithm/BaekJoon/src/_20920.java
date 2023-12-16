import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            String word = in.readLine();
            if (word.length() >= 4) {
                if (hashMap.containsKey(word)) {
                    int num = hashMap.get(word);
                    hashMap.replace(word, num + 1);
                } else {
                    hashMap.put(word, 1);
                }
            }
        }
//        Collections.sort();
        Iterator iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
           String key = (String) iterator.next();
        }

    }
}
