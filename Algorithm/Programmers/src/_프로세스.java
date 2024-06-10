import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _프로세스 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[] priorities, int location) {
                int answer = 0;
                int pri = 0;
                Queue<int[]> queue = new LinkedList<>();
                for (int i = 0; i < priorities.length; i++) {
                    //[우선순위, 위치];
                    int priority = priorities[i];
                    pri = Math.max(pri, priority);
                    int[] element = {priority, i};
                    queue.add(element);
                }

                int order = 1;
                Arrays.sort(priorities);
                while (true) {
                    if (queue.peek()[0] == priorities[priorities.length - order]) {
                        if (queue.peek()[1] == location) {
                            return order;
                        }
                        queue.remove();
                        order++;
                    } else {
                        queue.add(queue.poll());
                    }
                }
            }
        }
    }
}
