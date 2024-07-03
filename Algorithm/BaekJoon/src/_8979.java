import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][4];

        int[] targetNation = new int[4];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); //nation
            arr[i][1] = Integer.parseInt(st.nextToken()); //gold
            arr[i][2] = Integer.parseInt(st.nextToken()); //silver
            arr[i][3] = Integer.parseInt(st.nextToken()); //bronze

            if (arr[i][0] == target) {
                for (int j = 0; j <= 3; j++) {
                    targetNation[j] = arr[i][j];
                }
            }
        }

        int rank = 1;

        for (int i = 0; i < n; i++) {
            if (targetNation[0] == arr[i][0]) {
                continue;
            }

            if (targetNation[1] < arr[i][1]) { // 금메달수 적음
                rank++;
            } else if (targetNation[1] == arr[i][1]){ //금메달 수 같음
                if (targetNation[2] < arr[i][2]) { //은메달 수 적음
                    rank++;
                } else if (targetNation[2] == arr[i][2]) { //은메달 수 같음
                    if (targetNation[3] < arr[i][3]) {
                        rank++;
                    }
                }
            }
        }

        System.out.println(rank);

    }

}
