package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        double sum = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(in.readLine());
            sum += x;
            list.add(x);
            hashMap.put(x, hashMap.getOrDefault(x,0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append((int) Math.round(sum / n)).append("\n");

        list.sort((o1, o2) -> o1 - o2);

        sb.append(list.get((n + 1) / 2)).append("\n");

        int max;
        List<Map.Entry<Integer, Integer>> list2 = new ArrayList<>(hashMap.entrySet());

        list2.sort((o1, o2) -> {
            if (Objects.equals(o1.getValue(), o2.getValue())) {
                return o1.getKey() - o2.getKey();
            }
            return o2.getValue() - o1.getValue();
        });

        int highestValue = list2.get(n - 1).getValue();
        List<Integer> keysWithHighestValue = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : list2) {
            if (entry.getValue() == highestValue) {
                keysWithHighestValue.add(entry.getKey());
            } else {
                break;
            }
        }

        if (keysWithHighestValue.size() >= 2) {
            Collections.sort(keysWithHighestValue); // key 오름차순 정렬
            sb.append(keysWithHighestValue.get(1)).append("\n");
        } else {
            sb.append(keysWithHighestValue.get(0)).append("\n");
        }

        sb.append(list.get(n - 1) - list.get(0)).append("\n");

        System.out.println(sb);
    }
}
