package string;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StringCounter {
    public static int countMethodOne(String str) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        return charMap.size();
    }

    public static int countMethodTwo(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .size();
    }
}
