import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14650 {
    static int n;
    static int[] arr;
    static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        in.close();
        arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        answer = 0;

        dfs(1, 1);
        dfs(1, 2);

        System.out.println(answer);


    }

    static void dfs(int depth, int sum) {
        if (depth == n) {
            if (sum % 3 == 0) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            dfs(depth + 1, sum + i);
        }
    }
}
