import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2154 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        in.close();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        String strN = String.valueOf(n);
        String str = sb.toString();
        for (int i = 0; i < str.length() - strN.length() + 1; i++) {
            boolean flag = true;
            for (int j = i; j < i + strN.length(); j++) {
                if (str.charAt(j) != strN.charAt(j - i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i + 1);
                return;
            }
        }

    }
}
