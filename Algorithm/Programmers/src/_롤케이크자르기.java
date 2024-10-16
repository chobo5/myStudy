import java.util.HashMap;
import java.util.Map;

public class _롤케이크자르기 {
    class Solution {
        public int solution(int[] topping) {
            int answer = 0;

            Map<Integer, Integer> leftMap = new HashMap();
            Map<Integer, Integer> rightMap = new HashMap();

            leftMap.put(topping[0], 1);
            for (int i = 1; i < topping.length; i++) {
                rightMap.put(topping[i], rightMap.getOrDefault(topping[i], 0) + 1);
            }

            if (leftMap.size() == rightMap.size()) {
                answer++;
            }

            for (int i = 1; i < topping.length; i++) {
                leftMap.put(topping[i], leftMap.getOrDefault(topping[i], 0) + 1);
                Integer value = rightMap.get(topping[i]);
                if (value == 1) {
                    rightMap.remove(topping[i]);
                } else {
                    rightMap.put(topping[i], value - 1);
                }

                if (leftMap.size() == rightMap.size()) {
                    answer++;
                }

            }



            return answer;
        }
    }
}
