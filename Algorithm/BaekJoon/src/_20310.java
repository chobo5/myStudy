import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = in.readLine().split("");
        int zeroCount = 0;
        int oneCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("0")) {
                zeroCount++;
            } else {
                oneCount++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zeroCount; i++) {
            sb.append("0");
        }

        for (int i = 0; i < oneCount; i++) {
            sb.append("1");
        }

        System.out.println(sb);
    }
}
