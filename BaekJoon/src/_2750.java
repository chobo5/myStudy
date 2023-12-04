import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sc.nextLine();
        }
        sc.close();

        //bubble sort
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i ; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int x : arr) {
            System.out.println(x);
        }



    }
}
