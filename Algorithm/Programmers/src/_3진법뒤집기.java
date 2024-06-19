public class _3진법뒤집기 {
    class Solution {
        public static int solution(int n) {
            int answer = 0;
            String three = "";
            while (n >= 3) {
                three += n % 3;
                n /= 3;
            }
            three += n;
            String[] arr = three.split("");
            for (int i = 0; i < arr.length; i++) {
                int x = Integer.parseInt(arr[i]);
                if (i != three.length() - 1 && x == 0) {
                    continue;
                }
                answer += x * (int)Math.pow(3, arr.length - i - 1);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.solution(45));
    }
}

