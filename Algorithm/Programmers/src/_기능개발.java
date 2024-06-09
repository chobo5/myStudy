import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _기능개발 {
    public static void main(String[] args) {
        class Solution {
            public static int[] solution(int[] progresses, int[] speeds) {
                List<Integer> list = new ArrayList<>();
                Queue<Integer> queue = new LinkedList<>();
                for (int i = 0; i < progresses.length; i++) {
                    int remain = 100 - progresses[i];
                    int speed = speeds[i];
                    if (remain % speed == 0) {
                        queue.add(remain / speed);
                    } else {
                        queue.add((remain / speed) + 1);
                    }
                }

                while (!queue.isEmpty()) {
                    int day = queue.peek();
                    int count = 1;
                    queue.remove();
                    while (!queue.isEmpty() && day >= queue.peek()) {
                        queue.remove();
                        count++;
                    }
                    list.add(count);
                }
                int[] answer = new int[list.size()];
                for (int i = 0; i < answer.length; i++) {
                    answer[i] = list.get(i);
                }
                return answer;
            }
        }

        int[] progress = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Solution.solution(progress, speeds));
    }
}
