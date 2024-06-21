import java.util.ArrayList;
import java.util.List;

public class _저주의숫자3 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            List<Integer> list = new ArrayList<>();
            int num = 1;
            while (list.size() < n) {
                if (num % 3 != 0) {
                    String str = String.valueOf(num);
                    if (!str.contains("3")) {
                        list.add(num);
                    }
                }
                num++;
            }
            return list.get(list.size() - 1);
        }
    }
}
