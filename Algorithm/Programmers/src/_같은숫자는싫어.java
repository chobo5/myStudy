    import java.util.Deque;
    import java.util.LinkedList;

public class _같은숫자는싫어 {
    public class Solution {
        public static int[] solution(int []arr) {

            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < arr.length; i++) {
                if (!deque.isEmpty() && deque.peekLast() == arr[i]) {
                    continue;
                }
                deque.add(arr[i]);
            }

            int[] answer = new int[deque.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = deque.poll();
            }


            return answer;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        Solution.solution(arr);
    }
}
