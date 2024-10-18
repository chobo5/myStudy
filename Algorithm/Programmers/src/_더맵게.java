
import java.util.PriorityQueue;

public class _더맵게 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[] scoville, int K) {
                int answer = 0;
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                for (int s : scoville) {
                    pq.add(s);
                }

                int min = pq.peek();
                while (min < K) {
                    if (pq.size() >= 2) {
                        pq.add(pq.poll() + (pq.poll() * 2));
                        min = pq.peek();
                        answer++;
                    } else {
                        return -1;
                    }
                }
                return answer;
            }
        }
    }
}
