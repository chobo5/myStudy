import java.util.HashMap;
import java.util.Map;

public class _대충만든자판 {
    class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int[targets.length];
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < keymap.length; i++) {
                for (int j = 0; j < keymap[i].length(); j++) {
                    if (map.containsKey(keymap[i].charAt(j))) {
                        if (map.get(keymap[i].charAt(j)) > j + 1) {
                            map.put(keymap[i].charAt(j), j + 1);
                        }
                    } else {
                        map.put(keymap[i].charAt(j), j + 1);
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < targets.length; i++) {
                for (int j = 0; j < targets[i].length(); j++) {
                    if (!map.containsKey(targets[i].charAt(j))) {
                        int[] error = {-1};
                        return error;
                    } else {
                        count += map.get(targets[i].charAt(j));
                    }
                }
                answer[i] = count;
                count = 0;
            }
            return answer;
        }
    }
}
