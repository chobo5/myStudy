public class _ExpectedListofMatches {
    public static void main(String[] args) {
        class Solution {
            public int solution(int n, int a, int b) {
                int answer = 0;
                while (true) {
                    answer++;
                    a = calc(a);
                    b = calc(b);
                    if (a == b) {
                        break;
                    }
                }
                return answer;
            }

            public int calc(int x) {
                if (x % 2 == 0) {
                    return x / 2;
                } else {
                    return (x / 2) + 1;
                }
            }
        }

        Solution solution = new Solution();
        System.out.println(solution.solution(8, 4, 7));

    }
}
