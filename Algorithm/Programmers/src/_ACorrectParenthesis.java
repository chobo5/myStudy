import java.util.Stack;

public class _ACorrectParenthesis {
    public static void main(String[] args) {
        class Solution {
            boolean solution(String s) {
                Stack<Character> stack = new Stack<>();
                if (s.charAt(0) != '(' || s.charAt(s.length() - 1) != ')') {
                    return false;
                }
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (c == '(') {
                        stack.push(c);
                    }
                    if (c == ')' && !stack.empty()) {
                        stack.pop();
                    }
                }
                if (stack.empty()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}
