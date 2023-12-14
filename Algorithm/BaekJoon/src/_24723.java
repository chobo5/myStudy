import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _24723 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        in.close();
        System.out.println((int)Math.pow(2, n));

    }
}

