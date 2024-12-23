import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Boolean[][] chessBoard = new Boolean[n][m];
        List<Integer> whiteCounts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = in.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'W') {
                    chessBoard[i][j] = true;
                } else {
                    chessBoard[i][j] = false;
                }
            }
        }

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                int whites = 0;
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if (chessBoard[k][l] == true) {
                            whites++;
                        }
                    }
                }
                if (whites == 32) {
                    System.out.println(0);
                    return;
                } else if (whites > 32) {
                    whiteCounts.add(whites);
                }
            }
        }

        whiteCounts.sort(((o1, o2) -> o2.compareTo(o1)));
        System.out.println(whiteCounts.get(0) - 32);



    }
}
