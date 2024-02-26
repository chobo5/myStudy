package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 영문소문자의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String str = in.readLine();
        in.close();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 97 && c <= 122) {
                if (map.get(c) == null) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c) + 1);
                }
            } else {
                if (c != 32) {
                    break;
                }
            }
        }
        int count = 0;
        for (int i = 97; i <= 122; i++) {
            char a = (char) i;
            if (map.get(a) != null) {
                System.out.println(a + " : " + map.get(a));
                count++;
            }
            if (count > map.size()) {
                break;
            }

        }

    }
}
