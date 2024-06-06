public class _바탕화면정리 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(String[] wallpaper) {
                int[] answer = {51, 51, 0, 0};
                for (int i = 0; i < wallpaper.length; i++) {
                    String str  = wallpaper[i];
                    for (int j = 0; j < str.length(); j++) {
                        if (str.charAt(j) == '#') {
                            answer[0] = Math.min(i, answer[0]);
                            answer[1] = Math.min(j, answer[1]);
                            answer[2] = Math.max(i, answer[2]);
                            answer[3] = Math.max(j, answer[3]);
                        }
                    }
                }
                answer[2]++;
                answer[3]++;

                return answer;
            }
        }
    }
}
