package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] buildings = new int[n];
        int[] see = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < n; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int now = buildings[i];
            int count = 0;
            if (i == 0) {
                for (int j = 1; j < buildings.length; j++) {
                    if (buildings[j] < now) {
                        count++;
                    } else {
                        see[i] = count + 1;
                        break;
                    }
                }
            } else if (i == buildings.length - 1) {
                for (int j = buildings.length - 2; j >= 0; j--) {
                    if (buildings[j] < now) {
                        count++;
                    } else {
                        see[i] = count + 1;
                        break;
                    }
                }
            } else {
                for (int j = i + 1; j < buildings.length; j++) {
                    if (buildings[j] < now) {
                        count++;
                    } else {
                        count++;
                        break;
                    }
                }

                for (int j = i - 1; j >= 0; j--) {
                    if (buildings[j] < now) {
                        count++;
                    } else {
                        see[i] = count + 1;
                        break;
                    }
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
