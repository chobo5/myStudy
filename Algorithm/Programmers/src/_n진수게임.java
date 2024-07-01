import java.util.*;

public class _n진수게임 {
    class Solution {
        public static String solution(int n, int t, int m, int p) {
            StringBuilder sb = new StringBuilder();
            List<String> list = new ArrayList<>();
            Stack<String> stack = new Stack<>();
            list.add("0");
            list.add("1");
            int num = 2;
            while (list.size() <= p + (m * t)) {
                translate(num, n, stack);
                while (!stack.isEmpty()) {
                    list.add(stack.pop());
                }
                num++;
            }

            for (int i = 0; i < t; i++) {
                sb.append(list.get((p - 1) + (i * m)));
            }

            return sb.toString();
        }

        public static void translate(int num, int n, Stack<String> stack) {
            while (num >= n) {
                int rest = num % n;
                if (rest >= 10) {
                    stack.add(String.valueOf((char) ('A' + (rest % 10))));
                } else {
                    stack.add(String.valueOf(rest));
                }
                num /= n;
            }
            if (num >= 10) {
                stack.add(String.valueOf((char) ('A' + (num % 10))));
            } else {
                stack.add(String.valueOf(num));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.solution(2, 4, 2, 1));
    }
}
