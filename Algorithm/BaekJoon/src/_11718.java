import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11718 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String line;
        while((line = in.readLine()) != null) {
            sb.append(line).append("\n");
        }
        in.close();
        System.out.println(sb);
    }
}
