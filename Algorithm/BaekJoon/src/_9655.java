import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        in.close();
        String answer = n % 2 == 0 ? "CY" : "SK";
        System.out.println(answer);
    }
}
