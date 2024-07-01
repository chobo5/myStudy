import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;


public class _k진수에서소수개수구하기 {
    class Solution {
        public static int solution(int n, int k) {
            int answer = 0;
            String number = makeNumber(n, k);
            String[] numbers = number.split("0");

            for (String strNum : numbers) {
                if (strNum.equals("")) {
                    continue;
                }
                if (isPrime(Long.parseLong(strNum))) {
                    answer++;
                }
            }

            return answer;
        }

        public static String makeNumber(int n, int k) {
            StringBuilder sb = new StringBuilder();
            Stack<Integer> stack = new Stack<>();
            while (n > k) {
                stack.add(n % k);
                n /= k;
            }
            sb.append(n);
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.toString();
        }

        public static boolean isPrime(long num) {
            if (num == 1) {
                return false;
            }

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }


}
