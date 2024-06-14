import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class _최빈값구하기 {
    public static void main(String[] args) {
        class Solution {
            public static int solution(int[] array) {
                int answer = 0;
                Map<Integer, Integer> hashMap = new HashMap<>();
                for (int i = 0; i < array.length; i++) {
                    hashMap.put(array[i], hashMap.getOrDefault(array[i], 0) + 1);
                }
                List<Integer> keys = new ArrayList<>();
                int max = 0;

                for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                    if (entry.getValue() < max) {
                        continue;
                    }
                    int temp = Math.max(entry.getValue(), max);
                    if (temp == max) {
                        keys.add(entry.getKey());
                    } else if (temp > max) {
                        keys.clear();
                        max = temp;
                        keys.add(entry.getKey());
                    }
                }

                if (keys.size() == 1) {
                    return keys.get(0);
                } else {
                    return -1;
                }


            }
        }
        int[] array = {1, 2, 3, 3, 3, 4};
        System.out.println(Solution.solution(array));
    }
}
