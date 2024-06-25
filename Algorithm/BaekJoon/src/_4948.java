import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int x = Integer.parseInt(in.readLine());
            if (x == 0) {
                in.close();
                break;
            }
            int answer = 0;
            boolean[] arr = new boolean[(2 * x) + 1]; //true - 소수x flase - 소수
            arr[0] = arr[1] = true;
            for (int i = 2; i <= Math.sqrt(2 * x); i++) {
                if (arr[i]) {
                    continue;
                }
                for (int j = i * i; j < arr.length; j += i) {
                    arr[j] = true;
                }
            }

            for (int i = x + 1; i < arr.length; i++) {
                if (!arr[i]) {
                    answer++;
                }
            }

            sb.append(answer).append("\n");

        }
        System.out.println(sb);


    }
}
