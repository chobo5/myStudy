public class _N개의최소공배수 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[] arr) {
                int answer = arr[0];
                if (arr.length == 1) {
                    return arr[0];
                }

                for (int i = 0; i < arr.length - 1; i++) {
                    answer = lcm(answer, arr[i + 1]);
                }
                return answer;
            }

            int gcd(int a, int b) {
                int r = a % b;
                if (r == 0) {
                    return b;
                } else {
                    return gcd(b, r);
                }
            }

            int lcm(int a, int b) {
                return a * b /gcd(a, b);
            }
        }
        int[] test = {1, 2, 3};
        System.out.println(new Solution().solution(test));
    }
}
