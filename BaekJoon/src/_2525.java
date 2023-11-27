import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        StringTokenizer st = new StringTokenizer(str1, " ");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int add = Integer.parseInt(br.readLine());

        int whole = (60 * h) + m + add;
        int hour = whole / 60 % 24;
        int minute = whole % 60;
        System.out.println(hour + " " + minute);


    }
}
