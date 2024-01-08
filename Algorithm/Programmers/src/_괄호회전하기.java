import java.util.*;

public class _괄호회전하기 {
    public static void main(String[] args) {
        class Solution {
            public int solution(String s) {
                int answer = 0;
                List<Character> list = new ArrayList<>();
                Stack<Character> stack;

                for (int i = 0; i < s.length(); i++) {
                    list.add(s.charAt(i));
                }

                for (int i = 0; i < list.size() - 1; i++) {
                    stack = new Stack<>();

                    for (int j = 0; j < list.size(); j++) {
                        char c = list.get(j);
                        if (stack.empty()) {
                            stack.push(c);
                        } else if (c == ']' && stack.peek() == '[') {
                            stack.pop();
                        } else if (c == '}' && stack.peek() == '{') {
                            stack.pop();
                        } else if (c == ')' && stack.peek() == '(') {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                    }

                    if (stack.empty()) {
                        answer++;
                    }
                    list.add(list.remove(0));


                }
                return answer;
            }
        }
    }
}
