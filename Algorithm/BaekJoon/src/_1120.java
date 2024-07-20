import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        in.close();
        String A = st.nextToken();
        String B = st.nextToken(); //A <= B
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i <= B.length() - A.length(); i++) {
            int temp = 0;
            for (int j = i; j < A.length() + i; j++) {
                char a = A.charAt(j - i);
                char b = B.charAt(j);
                if (a != b) {
                    temp++;
                }
            }
            diff = Math.min(temp, diff);
        }
        System.out.println(diff);

    }
}
