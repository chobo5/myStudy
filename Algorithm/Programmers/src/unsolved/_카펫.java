package unsolved;

public class _카펫 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int brown, int yellow) {
                int[] answer = new int[2];
                int width = brown + yellow;
                int middle = (int)Math.pow(width, 0.5);

                for (int i = middle; i <= width; i++) {
                    if (width % middle == 0) {
                        if (middle >= width/ middle) {
                            answer[0] = middle;
                            answer[1] = width / middle;
                        } else {
                            answer[1] = middle;
                            answer[0] = width / middle;
                        }

                        break;
                    }
                }
                return answer;
            }
        }
    }
}
