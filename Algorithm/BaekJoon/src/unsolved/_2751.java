package unsolved;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _2751 {
    //counting sort

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] array = new int[n];
        List<Integer> sameValues = new ArrayList<Integer>();
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j +1] = temp;
                }
                if (array[j] == array[j + 1]) {
                    sameValues.add(j);
                }

            }
        }
        List<Integer> newArray = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (!sameValues.contains(i)) {
                newArray.add(array[i]);
            }
        }

        for (int x : newArray) {
            System.out.println(x);
        }
    }
}
