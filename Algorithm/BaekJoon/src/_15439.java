import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        System.out.println(n * n - n);
    }
}
