import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _24265 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        in.close();

        long count = 0;

        for (int i = 1; i < n; i++) { //n-1개
            count += i;
        }
        System.out.println(count);
        System.out.println(2);
    }
}
