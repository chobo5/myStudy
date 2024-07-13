import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = in.readLine();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }

        int n = Integer.parseInt(in.readLine());
        int cursor = sb.length();
        for (int i = 0; i < n; i++) {
            String[] line = in.readLine().split(" ");
            if (line[0].equals("L")) {
                if (cursor != 0) {
                    cursor--;
                }
            } else if (line[0].equals("D")) {
                if (cursor != sb.length()) {
                    cursor++;
                }
            } else if (line[0].equals("B")) {
                if (cursor != 0) {
                    sb.deleteCharAt(cursor - 1);
                    cursor--;
                }
            } else {
                sb.insert(cursor, line[1]);
                cursor++;
            }
        }
        System.out.println(sb);
    }
}
