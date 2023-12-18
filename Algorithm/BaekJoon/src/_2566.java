import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int temp = 0;
        String position = "";
        StringTokenizer st;
        for (int i = 1; i < 10 ; i++) {
            String line = in.readLine();
            st = new StringTokenizer(line, " ");
            for (int j = 1; j < 10 ; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x >= temp) {
                    temp = x;
                    position = i + " " + j;
                }
            }
        }
        System.out.println(temp);
        System.out.println(position);
    }
}
