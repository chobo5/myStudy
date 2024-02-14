public class _완주하지못한선수 {
    public static void main(String[] args) {
        class Solution {
            public String solution(String[] participant, String[] completion) {
                String answer = "";
                for (int i = 0; i < participant.length; i++) {
                    String p = participant[i];
                    boolean isChanged = false;
                    for (int j = 0; j < completion.length; j++) {
                        if (p.equals(completion[j])) {
                            completion[j] = completion[j].replace(completion[j], "");
                            isChanged = true;
                            break;
                        }
                    }
                    if (isChanged == false) {
                        answer = participant[i];
                        break;
                    }
                }
                return answer;
            }
        }
        String[] p = {"mislav", "stanko", "mislav", "ana"};
        String[] c = {"stanko", "ana", "mislav"};
        System.out.println(new Solution().solution(p, c));
    }
}
