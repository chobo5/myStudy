public class _옹알이 {
    public static void main(String[] args) {
        class Solution {
            public int solution(String[] babbling) {
                int answer = 0;
                String[] able = {"aya", "ye", "woo", "ma"};
                for (int i = 0; i < babbling.length; i++) {
                    for (int j = 0; j < able.length; j++) {
                        babbling[i] = babbling[i].replace(able[j], " ");
                    }
                    if (babbling[i].trim().length() == 0) {
                        answer++;
                    }
                }
                return answer;
            }
        }
    }
}
