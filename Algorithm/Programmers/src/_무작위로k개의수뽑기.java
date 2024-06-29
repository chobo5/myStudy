import java.util.HashSet;
import java.util.Set;

public class _무작위로k개의수뽑기 {
    class Solution {
        public int[] solution(int[] arr, int k) {
            int[] answer = new int[k];
            Set<Integer> set = new HashSet<>();
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                if (set.size() >= k) {
                    break;
                }
                int num = arr[i];
                if (set.contains(num)) {
                    continue;
                }
                answer[index] = num;
                set.add(num);
                index++;

            }
            if (set.size() < k) {
                for (int i = index; i < answer.length; i++) {
                    answer[i] = -1;
                }
            }
            return answer;
        }
    }
}
