import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _1233 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] s1 = new int[a];
        int[] s2 = new int[b];
        int[] s3 = new int[c];

        for (int i = 0; i < a; i++) {
            s1[i] = i + 1;
        }
        for (int i = 0; i < b; i++) {
            s2[i] = i + 1;
        }
        for (int i = 0; i < c; i++) {
            s3[i] = i + 1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a; i++) {
            int x = s1[i];
            for (int j = 0; j < b; j++) {
                int y = s2[j];
                for (int k = 0; k < c; k++) {
                    int z = s3[k];
                    map.put(x+y+z, map.getOrDefault(x+y+z, 0) + 1);
                }
            }
        }
        Map<Integer, Integer> temp = new HashMap<>();
        int max = 0;
        int key = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                temp.clear();
                temp.put(entry.getKey(), entry.getValue());
                max = entry.getValue();
                key = entry.getKey();
            } else if (entry.getValue() == max) {
                temp.put(entry.getKey(), entry.getValue());
            }
        }

        if (temp.size() == 1) {
            System.out.println(temp.get(key));
        } else {
            int min = Integer.MAX_VALUE;
            for(Map.Entry<Integer, Integer> entry : temp.entrySet()) {
                min = Math.min(min, entry.getKey());
            }
            System.out.println(min);
        }
    }
}
