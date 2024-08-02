import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2666 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int[] board = new int[n]; //0 - 닫힘, 1 - 열림
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;
        board[a - 1] = 1;
        board[b - 1] = 1;

        int t = Integer.parseInt(in.readLine());
        for (int i = 0; i < t; i++) {
            int x = Integer.parseInt(in.readLine()) - 1;
        }

    }
}
