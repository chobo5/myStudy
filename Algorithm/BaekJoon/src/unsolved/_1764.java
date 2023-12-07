package unsolved;

import java.util.Scanner;

public class _1764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] arrayN = new String[n];
        String[] arrayM = new String[m];

        for (int i = 0; i < n; i++) {
            arrayN[i] = sc.nextLine();
        }

        for (int i = 0; i < m; i++) {
            arrayM[i] = sc.nextLine();
        }
        sc.close();
    }

    static void binarySearch(String str, String[] array) {
        int left = 0;
        int right = array.length - 1;
        int middle = (left + right) >> 1;
//        while (left < right) {
//            if (array[middle] >)
//        }
    }


}
