
import java.util.HashMap;
import java.util.Map;

public class _모음사전 {
    class Solution {
        static int index;
        static int answer;
        static char[] dictionary;
        static Map<String, Integer> map;
        public static int solution(String word) {

            dictionary = new char[]{'A', 'E', 'I', 'O', 'U'};
            index = 1;
            answer = 0;
            map = new HashMap<>();
            for (int i = 0; i < dictionary.length; i++) {
                dfs(1, String.valueOf(dictionary[i]));
            }

            return map.get(word);
        }

        static void dfs(int depth, String base) {
            map.put(base, index++);
            if (depth == 5) {
                return;
            }
            for (int i = 0; i < 5; i++) {
                dfs(depth + 1, base + dictionary[i]);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(Solution.solution("AAAAE"));
    }
}
