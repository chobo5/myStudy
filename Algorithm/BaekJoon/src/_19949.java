import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _19949 {

    static int[] answer;
    static int[] temp;
    static boolean[] check;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        in.close();
        answer = new int[10];
        temp = new int[10];
        check = new boolean[10];
        n = 0;
        for (int i = 0; i < 10; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(n);
    }

    static void dfs(int depth) {
        if (depth == 10) {
            int score = 0;
            for (int i = 0; i < 10; i++) {
                if (answer[i] == temp[i]) {
                    score++;
                }
            }
            if (score >= 5) {
                n++;
            }
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (depth >= 2 && temp[depth - 2] == temp[depth - 1] && temp[depth - 1] == i) {
                continue;
            }
            temp[depth] = i;
            dfs(depth + 1);
        }
    }
}
