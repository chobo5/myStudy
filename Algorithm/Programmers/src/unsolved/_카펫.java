package unsolved;

public class _카펫 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int brown, int yellow) {
                int[] answer = new int[2];
                int middle = (int)Math.pow(yellow, 0.5);

                for (int i = middle; i <= yellow; i++) {
                    if (yellow % i == 0 && (i+2)*((yellow/i)+2) == yellow + brown) {
                        int width = i + 2;
                        int height = (yellow / i) + 2;
                        if (width > height) {
                            answer[0] = width;
                            answer[1] = height;
                        } else {
                            answer[0] = height;
                            answer[1] = width;
                        }
                        break;
                    }
                }
                return answer;
            }
        }
    }
}
