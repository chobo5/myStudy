import java.util.Stack;

public class _EliminationbyGrouping {
    public static void main(String[] args) {
        class Solution {
            public int solution(String s) {
                Stack<Character> stack = new Stack<>();
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (!stack.empty()) {
                        if (stack.peek().equals(c)) {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                    } else {
                        stack.push(c);
                    }
                }

                if (stack.empty()) {
                    return 1;
                }else {
                    return 0;
                }
            }
        }
        System.out.println(new Solution().solution("cdcd"));
    }
}
