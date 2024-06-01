import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] arr = new int[n][2];
        int[][] original = new int[n][2];
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        in.close();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i][0] = num;
            original[i][0] = num;
        }


        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        int count = 0;
        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i][0] == arr[i - 1][0]) {
                continue;
            }
            result.put(arr[i][0], count);
            count++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result.get(original[i][0])).append(" ");
        }


        System.out.println(sb);

    }
}
