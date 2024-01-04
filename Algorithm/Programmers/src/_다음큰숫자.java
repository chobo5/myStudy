public class _다음큰숫자 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int n) {
                int answer = 0;
                String bina = Integer.toBinaryString(n);
                int count = 0;
                for (int i = 0; i < bina.length(); i++) {
                    if (bina.charAt(i) == '1') {
                        count++;
                    }
                }
                int x = n;
                while (true) {
                    int count2 = 0;
                    x++;
                    String bi = Integer.toBinaryString(x);
                    for (int i = 0; i < bi.length(); i++) {
                        if (bi.charAt(i) == '1') {
                            count2++;
                        }
                    }
                    if (count2 == count) {
                        answer = x;
                        break;
                    }


                }
                return answer;
            }
        }
    }
}
