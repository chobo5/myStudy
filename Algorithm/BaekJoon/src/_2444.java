import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        in.close();

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j >= 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                
            }
            System.out.println();
        }

    }
}

