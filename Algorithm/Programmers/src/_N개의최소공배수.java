public class _N개의최소공배수 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[] arr) {
                int answer = 1;
                for (int i = 0; i < arr.length - 1; i++) {
                    int min = gcd(arr[i], arr[i + 1]);
                    answer *= min;
                }
                return answer;
            }

            int gcd(int a, int b) {
                int r = a % b;
                if(r == 0) {
                    return b;
                } else {
                    return gcd(b, r);
                }
            }
        }
        int[] test = {1, 2, 3};
        System.out.println(new Solution().solution(test));
    }
}
