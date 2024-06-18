public class _그림확대 {
    public static void main(String[] args) {
        class Solution {
            public static String[] solution(String[] picture, int k) {
                String[] answer = new String[picture.length * k];
                for (int i = 0; i < picture.length; i++) {
                    String str = "";
                    for (int j = 0; j < picture[i].length(); j++) {
                        for (int l = 0; l < k; l++) {
                            str += picture[i].charAt(j);
                        }
                    }
                    for (int j = k * i; j < (i + 1) * k; j++) {
                        answer[j] = str;
                    }
                }
                return answer;
            }
        }
        String[] pictures = {".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...", "....x...."};
        Solution.solution(pictures, 2);
    }
}
