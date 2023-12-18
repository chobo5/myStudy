import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean run = true;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        while ((line=br.readLine()) != null) {
            st = new StringTokenizer(line, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a + b).append("\n");
        }
        System.out.println(sb);

    }
}
