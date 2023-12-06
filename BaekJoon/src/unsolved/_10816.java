package unsolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class _10816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<Integer, Integer> arrayN = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (arrayN.get(num) == null) {
                arrayN.put(num, 1);
            } else {
                int count = arrayN.get(num) + 1;
                arrayN.put(num, count);
            }

        }

        sc.nextLine();
        int m = sc.nextInt();
        int[] arrayM = new int[m];
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            arrayM[i] = sc.nextInt();

        }
        sc.close();

        for (int num : arrayM) {
            if (arrayN.get(num) == null) {
                System.out.print(0 + " ");
            } else {
                System.out.print(arrayN.get(num) + " ");
            }
        }


    }


}
