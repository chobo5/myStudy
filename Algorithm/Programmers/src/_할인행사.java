import java.util.HashMap;
import java.util.Map;

public class _할인행사 {
    public static void main(String[] args) {
        class Solution {
            public static int solution(String[] want, int[] number, String[] discount) {
                int answer = 0;
                int total = 0;
                Map<String, Integer> wish = new HashMap<>();
                Map<String, Integer> copyMap = new HashMap<>();
                for (int i = 0; i < number.length; i++) {
                    wish.put(want[i], number[i]);
                    total += number[i];
                }

                for (int i = 0; i <= discount.length - total; i++) {
                    copyMap.putAll(wish);
                    for (int j = i; j < i + total; j++) {
                        String mer = discount[j];
                        if (copyMap.get(mer) == null) {
                            continue;
                        }

                        if (copyMap.get(mer) == 1) {
                            copyMap.remove(mer);
                            continue;
                        }

                        copyMap.put(mer, copyMap.get(mer) - 1);

                    }

                    if (copyMap.isEmpty()) {
                        answer++;
                    }

                }
                return answer;
            }

        }
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(Solution.solution(want, number, discount));
    }
}
