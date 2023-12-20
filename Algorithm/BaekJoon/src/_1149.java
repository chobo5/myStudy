import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] array = new int[n][3];
        StringTokenizer st;
        int red = 0;
        int green = 1;
        int blue = 2;
        for (int i = 0; i < n; i++) {
            String line = in.readLine();
            st = new StringTokenizer(line, " ");
            array[i][red] = Integer.parseInt(st.nextToken());
            array[i][green] = Integer.parseInt(st.nextToken());
            array[i][blue] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            array[i][red] += Math.min(array[i - 1][green], array[i - 1][blue]);
            array[i][green] += Math.min(array[i - 1][red], array[i - 1][blue]);
            array[i][blue] += Math.min(array[i - 1][green], array[i - 1][red]);
        }
        int min = Math.min(array[n-1][red], array[n-1][green]);
        System.out.println(Math.min(min, array[n-1][blue]));
    }
}
