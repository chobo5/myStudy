package unsolved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _명예의전당1 {

    static int[] arr = {10, 100, 20, 150, 1, 100, 200};
    public static void main(String[] args) {
        int[] result = solution(3, arr);
        for(int x : result) {
            System.out.print(x + " ");
        }
    }
    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> rank = new ArrayList<>();
        rank.add(score[0]);
        answer[0] = score[0];
        for (int i = 1; i < score.length; i++) {
            if (i < k) {
                rank.add(score[i]);
                Collections.sort(rank);
                answer[i] = rank.get(0);
            } else {
                if (rank.get(0) > score[i]) {
                    answer[i] = rank.get(0);
                } else {
                    rank.set(0, score[i]);
                    Collections.sort(rank);
                    answer[i] = rank.get(0);
                }
            }
        }
        return answer;
    }

}
