import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class _10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[][] array = new char[5][15];
        StringBuilder sb = new StringBuilder();
        int maxLength = 0;

        for (int i = 0; i < array.length; i++) {
            String line = in.readLine();
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
            for (int j = 0; j < line.length(); j++) {
                array[i][j] = line.charAt(j);
            }

        }

        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < 5; j++) {
                if (array[j][i] == '\0' || array[j][i] == ' ') {
                    continue;
                }
                sb.append(array[j][i]);

            }
        }
        System.out.println(sb);
    }
}
