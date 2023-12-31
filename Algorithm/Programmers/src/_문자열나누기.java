public class _문자열나누기 {
    public static void main(String[] args) {
        class Solution {
            public int solution(String s) {
                int answer = 0;
                char x = s.charAt(0);
                int countSame = 1;
                int countDiff = 0;
                for (int i = 1; i < s.length(); i++) {
                    if(s.charAt(i) == x) {
                        countSame++;
                    } else {
                        countDiff++;
                    }

                    if (countSame == countDiff) {
                        answer++;
                        if (i + 1 < s.length()) {
                            x = s.charAt(i + 1);
                        } else {
                            answer--;
                        }

                    }
                }
                return answer + 1;
            }
        }
    }
}
