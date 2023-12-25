import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String word = in.readLine();
        int index = Integer.parseInt(in.readLine());
        in.close();
        String[] strArr = word.split("");
        System.out.println(strArr[index - 1]);
    }
}
