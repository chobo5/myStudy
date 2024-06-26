package unsolved;

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
            List<Integer> filteredNumbers = Arrays.stream(numbers)
                    .filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .sorted()
                    .collect(Collectors.toList());
            boolean[] primes = getPrimes(filteredNumbers.get(filteredNumbers.size() - 1));

            for (int i = 0; i < filteredNumbers.size(); i++) {
                if (!primes[filteredNumbers.get(i)]) {
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

        public static boolean[] getPrimes(int num) {
            boolean[] primes = new boolean[num + 1];
            primes[0] = primes[1] = true; //true - 소수x, flase - 소수
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (primes[i]) {
                    continue;
                }
                for (int j = i * i; j < primes.length; j += i) {
                    primes[j] = true;
                }
            }
            return primes;
        }
    }


}
