import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2743 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String word = in.readLine();
        in.close();
        System.out.println(word.length());
    }
}
