import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        in.close();
        int result = 0;
        String[] strArr = line.split("-");
        for (int i = 0; i < strArr.length; i++) {
            int temp = 0;
            String[] partSumArr = strArr[i].split("\\+");
            for(String x : partSumArr) {
                temp += Integer.parseInt(x);
            }
            if (i == 0) {
                result = temp;
            } else {
                result -= temp;
            }
        }
        System.out.println(result);
    }
}
