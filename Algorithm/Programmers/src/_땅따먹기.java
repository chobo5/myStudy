import java.util.Stack;

public class _주식가격 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int[] prices) {
                int[] answer = new int[prices.length];
                Stack<Integer> stack = new Stack<>();
                int time = 0;
                for (int i = 0; i < prices.length; i++) {
                    if (!stack.isEmpty()) {
                        if (stack.peek() <= prices[i]) {
                            stack.pop()
                        }
                    }
                    time++;
                }
                return answer;
            }
        }


    }
}
