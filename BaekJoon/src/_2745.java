import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        br.close();
        StringTokenizer st = new StringTokenizer(line," ");
        String b = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        int result = 0;
        for (int i = b.length() - 1; i >= 0 ; i--) {
            int num = b.charAt(i) - 55;
            result += num * Math.pow(n, i);
        }
        System.out.println(result);
    }
}
