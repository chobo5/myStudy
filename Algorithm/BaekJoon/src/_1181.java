import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        String[] words = new String[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            words[i] = in.readLine();
        }

        Arrays.sort(words, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) == o2.charAt(i)) {
                        continue;
                    }
                    return o1.charAt(i) - o2.charAt(i);
                }
            }
            return o1.length() - o2.length();
        });

        for (int i = 0; i < n; i++) {
            if (i > 0 && words[i].equals(words[i - 1])) {
                continue;
            }
            sb.append(words[i]).append("\n");
        }

        System.out.println(sb);
    }
}
