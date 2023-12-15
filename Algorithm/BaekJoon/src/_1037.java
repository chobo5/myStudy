import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String str = in.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int[] array = new int[n];
        in.close();
        for (int i = 0; i < n ; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int min = array[0];
        int max = array[n - 1];
        System.out.println(min * max);

    }
}
