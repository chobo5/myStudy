package string;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringFinder {
    public static String findFirstUnrepeated(String str) {
        Map<Character, Integer> lhm = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            lhm.put(c, lhm.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : lhm.entrySet()) {
            if (entry.getValue() == 1) {
                return String.valueOf(entry.getKey());
            }
        }
        return null;
    }
}
