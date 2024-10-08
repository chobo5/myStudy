import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        in.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            sb.append(line.charAt(i));
            if (i % 10 == 9) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
