import java.util.HashSet;
import java.util.Set;

public class _폰켓몬 {
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            int num = nums.length / 2;
            Set<Integer> set = new HashSet<>();
            for(int x : nums) {
                set.add(x);
            }
            return set.size() >= num ? num : set.size();
        }
    }
}
