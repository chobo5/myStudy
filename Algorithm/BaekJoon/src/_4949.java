import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean run = true;
        while (run) {
            String str = br.readLine();
            if (str.equals(".")) {
                run = false;
            } else {
                sb.append(solution(str)).append("\n");
            }

        }
        System.out.println(sb);
    }

    static String solution(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length() - 1; i++) {
            char s = str.charAt(i);
            switch (s) {
                case '(':
                    stack.push(s);
                    break;
                case ')':
                    char pop;
                    if (stack.isEmpty()) {
                        return "no";
                    } else {
                        pop = stack.pop();
                    }

                    if (pop != '(') {
                        return "no";
                    } else {
                        break;
                    }
                case '[':
                    stack.push(s);
                    break;
                case ']':
                    char pop2;
                    if (stack.isEmpty()) {
                        return "no";
                    } else {
                        pop2 = stack.pop();
                    }

                    if (pop2 != '[') {
                        return "no";
                    } else {
                        break;
                    }
                default:
                    break;
            }
        }
        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}
