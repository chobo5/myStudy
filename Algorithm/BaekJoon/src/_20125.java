import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();

        boolean headFlag = false;
        int[] heartPosition = {-1, -1};
        int leftArm = 0;
        int rightArm = 0;
        int leftLeg = 0;
        int rightLeg = 0;
        int waist = 0;

        for (int i = 0; i < n; i++) {
            String str = in.readLine();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == '*' && !headFlag) {
                    headFlag = true;
                    sb.append(i + 2).append(" ").append(j + 1).append("\n");
                    heartPosition[0] = i + 1;
                    heartPosition[1] = j;
                }

                if (i == heartPosition[0]) {
                    if (c == '*') {
                        if (j < heartPosition[1]) {
                            leftArm++;
                        } else if (j > heartPosition[1]) {
                            rightArm++;
                        }
                    }
                }

                if (i > heartPosition[0]) {
                    if (c == '*' && j == heartPosition[1]) {
                        waist++;
                    }

                    if (c == '*') {
                        if (j == heartPosition[1] - 1) {
                            leftLeg++;
                        }

                        if (j == heartPosition[1] + 1) {
                            rightLeg++;
                        }
                    }
                }
            }
        }

        sb.append(leftArm).append(" ").append(rightArm).append(" ").append(waist).append(" ").append(leftLeg).append(" ").append(rightLeg);
        System.out.println(sb);
    }
}
