import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2530 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int seconds = Integer.parseInt(st.nextToken());

        int time = Integer.parseInt(in.readLine());
        in.close();
        int s = time % 60;
        time /= 60;
        int m = time % 60;
        int h = time /= 60;

        hour += h;
        minute += m;
        seconds += s;

        if (seconds >= 60) {
            int overMinute = seconds / 60;
            seconds %= 60;
            minute += overMinute;
        }

        if (minute >= 60) {
            int overHour = minute / 60;
            minute %= 60;
            hour += overHour;
        }

        if (hour >= 24) {
            hour %= 24;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(hour).append(" ").append(minute).append(" ").append(seconds);
        System.out.println(sb);

    }
}
