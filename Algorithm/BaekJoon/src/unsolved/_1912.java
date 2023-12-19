package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
//        List<Integer> sumList = new ArrayList<>();
        int first = Integer.parseInt(st.nextToken());
//        sumList.add(first);
        int[] array = new int[n];
        array[0] = first;

        for (int i = 1; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            array[i] = array[i - 1] + x;
        }
        in.close();
//        System.out.println(Collections.max(sumList));

        System.out.println(array[n - 1]);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}
