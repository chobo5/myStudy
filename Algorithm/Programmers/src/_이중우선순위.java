import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _이중우선순위 {
    class Solution {
        public int[] solution(String[] operations) {
            int[] answer = {0, 0};
            PriorityQueue<Integer> pq1 = new PriorityQueue<>(1, (o1, o2) -> o2 - o1); //최댓값 순
            PriorityQueue<Integer> pq2 = new PriorityQueue<>(1, ((o1, o2) -> o1 - o2)); //최솟값순
            StringTokenizer st;
            for (int i = 0; i < operations.length; i++) {
                st = new StringTokenizer(operations[i], " ");
                String marker = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (marker.startsWith("I")) {
                     pq1.add(num);
                     pq2.add(num);
                } else {
                    if (pq1.isEmpty() && pq2.isEmpty()) {
                        continue;
                    }

                    if (num == 1) {
                        int x = pq1.poll();
                        pq2.remove(x);
                    } else {
                        int x = pq2.poll();
                        pq1.remove(x);
                    }
                }
            }

            if (!pq1.isEmpty() && !pq2.isEmpty()) {
                answer[0] = pq1.poll();
                answer[1] = pq2.poll();
            }
            return answer;
        }
    }
}
