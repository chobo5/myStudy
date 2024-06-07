import java.util.HashMap;
import java.util.Map;

public class _성격유형검사하기 {
    public static void main(String[] args) {
        class Solution {
            public static String solution(String[] survey, int[] choices) {
                String answer = "";
                Map<Character, Integer> map = new HashMap<>();
                for (int i = 0; i < survey.length; i++) {
                    int choice = choices[i];
                    String type = survey[i];
                    if (choice == 1) {
                        map.put(type.charAt(0), map.getOrDefault(type.charAt(0), 0) + 3);
                    } else if (choice == 2) {
                        map.put(type.charAt(0), map.getOrDefault(type.charAt(0), 0) + 2);
                    } else if (choice == 3) {
                        map.put(type.charAt(0), map.getOrDefault(type.charAt(0), 0) + 1);
                    } else if (choice == 5) {
                        map.put(type.charAt(1), map.getOrDefault(type.charAt(1), 0) + 1);
                    } else if (choice == 6) {
                        map.put(type.charAt(1), map.getOrDefault(type.charAt(1), 0) + 2);
                    } else if (choice == 7) {
                        map.put(type.charAt(1), map.getOrDefault(type.charAt(1), 0) + 3);
                    }
                }

                answer += map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T';
                answer += map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F';
                answer += map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M';
                answer += map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N';
                return answer;
            }
        }
    }
}
