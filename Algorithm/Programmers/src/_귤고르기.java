import java.util.*;

public class _귤고르기 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int k, int[] tangerine) {
                int answer = 0;
                int sum = 0;
                Map<Integer, Integer> hashmap = new HashMap<>();
                for (int i = 0; i < tangerine.length; i++) {
                    hashmap.put(tangerine[i], hashmap.getOrDefault(tangerine[i], 0) + 1);
                }
                ArrayList<Integer> values = new ArrayList<>(hashmap.values());
                Collections.sort(values);
                for (int i = values.size() - 1; i >= 0; i--) {
                    sum += values.get(i);
                    answer++;
                    if (sum >= k) {
                        break;
                    }

                }

                return answer;
            }
        }
        int[] test = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(new Solution().solution(6, test));
    }
}
