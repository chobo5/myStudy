import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String strN = in.readLine();
        in.close();
        int strLength = strN.length();
        int n = Integer.parseInt(strN);

        for (int i = n - (strLength * 9); i < n; i++) {
            int tempI = i;
            int sum = 0;
            while (tempI > 0) {
                sum += tempI % 10;
                tempI /= 10;
            }
            if (sum + i == n) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);


    }
}

