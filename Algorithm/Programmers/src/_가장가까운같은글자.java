public class _가장가까운같은글자 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;
        for (int i = 1; i < s.length() ; i++) {
            char c = s.charAt(i);
            int temp = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(j) == c) {
                    temp = i - j;
                    break;
                } else {
                    temp = -1;
                }
            }
            answer[i] = temp;
        }
        return answer;
    }
}
