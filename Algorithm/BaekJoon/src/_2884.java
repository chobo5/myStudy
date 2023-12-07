import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();
        StringTokenizer st = new StringTokenizer(str, " ");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        if (minute - 45 >= 0) {
            System.out.println(hour + " " + (minute - 45));
        } else if (hour == 0){
            System.out.println((23 + " " + (60 + minute - 45)));
        } else if (hour != 0){
            System.out.println(hour - 1 + " " + (60 + minute - 45));
        }
    }
}
