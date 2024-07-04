import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('e', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('u', 1);

        while (true) {
            String password = in.readLine();
            if (password.equals("end")) {
                break;
            }
            sb.append("<").append(password).append(">");
            if (validate(password, map)) {
                sb.append(" is acceptable.").append("\n");
            } else {
                sb.append(" is not acceptable.").append("\n");
            }

        }
        System.out.println(sb);
    }

    static boolean validate(String password, Map<Character, Integer> map) {
        if (!password.contains("a") &&
                !password.contains("e") &&
                !password.contains("i") &&
                !password.contains("o") &&
                !password.contains("u")) {
            return false;
        }

        for (int i = 0; i < password.length() - 2; i++) {
            char first = password.charAt(i);
            char second = password.charAt(i + 1);
            char third = password.charAt(i + 2);

            if (first == second) {
                if (first != 'e' && first != 'o') {
                    return false;
                }
            }

            if (second == third) {
                if (second != 'e' && second != 'o') {
                    return false;
                }
            }

            if (map.getOrDefault(first, 0) == 1 && map.getOrDefault(second, 0) == 1 && map.getOrDefault(third, 0) == 1) {
                return false;
            }

            if (map.getOrDefault(first, 0) == 0 && map.getOrDefault(second, 0) == 0 && map.getOrDefault(third, 0) == 0) {
                return false;
            }
        }

        return true;
    }
}
