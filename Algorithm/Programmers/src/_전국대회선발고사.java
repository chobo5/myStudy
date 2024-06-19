import java.util.*;

public class _전국대회선발고사 {
    class Solution {
        public int solution(int[] rank, boolean[] attendance) {
            int answer = 0;
            Map<Integer, String> hashMap = new HashMap<>();
            for (int i = 0; i < rank.length; i++) {
                hashMap.put(rank[i], i + " " + attendance[i]);
            }

            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= rank.length; i++) {
                if (list.size() == 3) {
                    break;
                }
                String numAndAttend = hashMap.get(i);
                StringTokenizer st;
                if (numAndAttend.contains("true")) {
                    st = new StringTokenizer(numAndAttend, " ");
                    list.add(Integer.parseInt(st.nextToken()));
                }

            }
            return 10000 * list.get(0) + 100 * list.get(1) + list.get(2);
        }
    }
}
