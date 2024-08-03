import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15667 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        in.close();
        int k = 1;
        while(true) {
            int temp = 1 + k + (int) Math.pow(k, 2);
            if (temp == n) {
                System.out.println(k);
                return;
            } else {
                k++;
            }
        }
    }
}
