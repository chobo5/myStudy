package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        long newScore = Long.parseLong(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int rank = 1;
        List<Long> scores = new ArrayList<>();
        st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < n; i++) {
            long score = Long.parseLong(st.nextToken());
            scores.add(score);
            if (score > newScore) {
                rank++;
            }
        }
        if (scores.size() > p) {
            System.out.println(rank);
        } else if(scores.size() == p) {
            if (rank > p) {
                System.out.println(-1);
            } else if (rank == p) {
                if (scores.contains(newScore)) {
                    System.out.println(-1);
                } else {
                    System.out.println(rank);
                }
            } else {
                System.out.println(rank);
            }
        } else {
            System.out.println(rank);
        }





    }
}
