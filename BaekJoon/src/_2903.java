import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int x = 2;
        for (int i = 0; i < n; i++) {
            x += Math.pow(2, i);
        }
        System.out.println((int)Math.pow(x, 2));
    }
}
