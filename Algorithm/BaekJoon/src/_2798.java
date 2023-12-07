import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] array = new int[n];
        int combination = n * (n-1) * (n-2) / 6;
        ArrayList<Integer> sumArray = new ArrayList<Integer>();

        for (int i = 0; i < n ; i++) {
            array[i] = sc.nextInt();
        }
        sc.close();

        loop:
        for (int i = 0; i < n-2 ; i++) {
            int temp1 = array[i];
            for (int j = i + 1; j < n - 1 ; j++) {
                int temp2 = array[j];
                for (int k = j + 1; k < n ; k++) {
                    int temp3 = array[k];
                    int sum = temp1 + temp2 + temp3;
                    if (sum > m) {

                    } else {
                        sumArray.add(sum);
                    }
                }
            }
        }
        System.out.println(Collections.max(sumArray));
    }
}
