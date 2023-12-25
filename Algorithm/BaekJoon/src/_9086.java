import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = in.readLine();
            String[] strArr = str.split("");
            sb.append(strArr[0]).append(strArr[strArr.length - 1]).append("\n");
        }

        System.out.println(sb);
    }


}