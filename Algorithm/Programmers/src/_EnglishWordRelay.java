import java.util.ArrayList;
import java.util.List;

public class _EnglishWordRelay {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int n, String[] words) {
                int[] answer = new int[2];
                int point = 0;
                List<String> list = new ArrayList<>();
                for (int i = 0; i < words.length - 1; i++) {
                    String word = words[i];
                    list.add(word);
                    String nextWord = words[i + 1];
                    if (word.charAt(word.length() - 1) != nextWord.charAt(0) || list.contains(nextWord)) {
                        point = i + 1;
                        break;
                    }
                    if (i == words.length - 2) {
                        answer[0] = 0;
                        answer[1] = 0;
                        return answer;
                    }
                }
                answer[0] = (point + 1) % n != 0 ? (point + 1) % n : n;
                answer[1] = (point + 1) % n != 0 ? ((point + 1) / n) + 1 : (point + 1) / n;

                return answer;
            }
        }
    }
}
