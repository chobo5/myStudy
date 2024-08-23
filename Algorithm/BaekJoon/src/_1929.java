import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        in.close();

        boolean[] arr = new boolean[m + 1]; //false - 소수, true - 소수 x
        arr[0] = arr[1] = true;


        for (int i = 2; i*i <= m; i++) { //2, 3, 4
            //false이면(소수라면)
            if (!arr[i]) {
                for (int j = i*i; j <= m; j+= i) {
                    arr[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = n; i <= m; i++) {
            if (!arr[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);

    }

}
