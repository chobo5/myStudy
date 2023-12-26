import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0.0F;
        double sum2 = 0.0F;
        StringTokenizer st;

        for (int i = 0; i < 20; i++) {
            String line = in.readLine();
            st = new StringTokenizer(line, " ");
            st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            double score = trans(grade);

            if (score != -1.0) {
                sum += credit;
                sum2 += score * credit;
            }
        }

        System.out.println(sum2 / sum);



    }

    static double trans(String grade) {
        switch (grade) {
            case "A+":
                return 4.5F;
            case "A0":
                return 4.0F;
            case "B+":
                return 3.5F;
            case "B0":
                return 3.0F;
            case "C+":
                return 2.5F;
            case "C0":
                return 2.0F;
            case "D+":
                return 1.5F;
            case "D0":
                return 1.0F;
            case "F":
                return 0.0F;
            default:
                return -1.0F;
        }
    }
}
