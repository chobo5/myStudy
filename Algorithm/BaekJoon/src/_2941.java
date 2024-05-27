import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        in.close();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1 && str.charAt(i) == 'c') {
                if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                    i++;
                    count++;
                    continue;
                }
            }

            if (i < str.length() -2 && str.charAt(i) == 'd') {
                if (str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') {
                    i++;
                    i++;
                    count++;
                    continue;
                }

            }

            if (i < str.length() -1 && str.charAt(i) == 'd') {
                if (str.charAt(i + 1) == '-') {
                    i++;
                    count++;
                    continue;
                }
            }

            if (i < str.length() - 1 && str.charAt(i) == 'l') {
                if (str.charAt(i + 1) == 'j') {
                    i++;
                    count++;
                    continue;
                }
            }

            if (i < str.length() - 1 && str.charAt(i) == 'n') {
                if (str.charAt(i + 1) == 'j') {
                    i++;
                    count++;
                    continue;
                }
            }

            if (i < str.length() - 1 && str.charAt(i) == 's') {
                if (str.charAt(i + 1) == '=') {
                    i++;
                    count++;
                    continue;
                }
            }

            if (i < str.length() - 1 && str.charAt(i) == 'z') {
                if (str.charAt(i + 1) == '=') {
                    i++;
                    count++;
                    continue;
                }
            }

            count++;
        }

        System.out.println(count);
    }
}
