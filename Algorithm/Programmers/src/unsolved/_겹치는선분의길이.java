package unsolved;

import java.util.*;

public class _겹치는선분의길이 {
    public static void main(String[] args) {
        class Solution {
            public static int solution(int[][] lines) {
                List<Integer> list = new ArrayList<>();
                Deque<Integer> dequeue = new ArrayDeque<>();
                for (int i = 0; i < lines.length; i++) {
                    for (int j = lines[i][0]; j <=lines[i][1] ; j++) {
                        list.add(j);
                    }
                }

                list.sort(((o1, o2) -> o1 - o2));

                for (int i = 0; i < list.size() - 1; i++) {
                    if (list.get(i) == list.get(i + 1)) {
                        if (dequeue.isEmpty()) {
                            dequeue.addLast(list.get(i));
                        } else {
                            if (dequeue.peekLast() != list.get(i)) {
                                dequeue.addLast(list.get(i));
                            }
                        }
                    }
                }

                if (dequeue.isEmpty()) {
                    return 0;
                }

                int count = 0;
                int before = dequeue.poll();

                while (!dequeue.isEmpty()) {
                    int now = dequeue.poll();
                    if (before + 1 == now) {
                        count++;
                    }
                    before = now;
                }
                return count;
            }
        }
        int[][] lines = {{0, 1}, {2, 5}, {3, 9}};
        Solution.solution(lines);
    }
}
