import java.util.HashMap;
import java.util.Map;

public class _롤케이크자르기 {
    class Solution {
        public int solution(int[] topping) {
            int answer = 0;

            Map<Integer, Integer> leftMap = new HashMap<>(); // 형
            Map<Integer, Integer> rightMap = new HashMap<>(); // 동생

            for (int e : topping) {
                rightMap.put(e, rightMap.getOrDefault(e, 0) + 1);
            }

            for (int e : topping) {
                leftMap.put(e, leftMap.getOrDefault(e, 0) + 1);

                if (rightMap.get(e) - 1 == 0)
                    rightMap.remove(e);
                else
                    rightMap.put(e, rightMap.get(e) - 1);

                if (leftMap.size() == rightMap.size())
                    answer++;
            }

            return answer;
        }
    }
}
