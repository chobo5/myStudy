import java.util.HashMap;
import java.util.Map;

public class _대충만든자판 {
    public static void main(String[] args) {
        class Solution {
            public static int[] solution(String[] keymap, String[] targets) {
                int[] answer = new int[targets.length];
                Map<String, Integer> map = new HashMap<>();

                for (int i = 0; i < keymap.length; i++) {
                    for (int j = 0; j < keymap[i].length(); j++) {
                        String s = String.valueOf(keymap[i].charAt(j));
                        if (map.get(s) != null) {
                            map.put(s, Math.min(j + 1, map.get(s)));
                            continue;
                        }
                        map.put(s, j + 1);
                    }
                }

                for (int i = 0; i < targets.length; i++) {
                    int result = 0;
                    for (int j = 0; j < targets[i].length(); j++) {
                        String s = String.valueOf(targets[i].charAt(j));
                        int temp = map.get(s) == null ? -1 : map.get(s);
                        if (temp == -1) {
                            result = -1;
                            break;
                        }
                        result += temp;
                    }
                    answer[i] = result;
                }
                return answer;
            }
        }
        String[] keymap = {"ABACD", "BCEFD"};
        String[] target = {"ABCD", "AABB"};
        System.out.println(Solution.solution(keymap, target));
    }
}
