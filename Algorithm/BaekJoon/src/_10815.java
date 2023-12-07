import java.util.Arrays;
import java.util.Scanner;

public class _10815 {
    //이분/이진 탐색
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.nextLine();

        //a배열 정렬
        Arrays.sort(a);

        int m = sc.nextInt();
        sc.nextLine();
        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            result[i] = binarySearch(sc.nextInt(), a);
        }
        sc.close();

        for (int x : result) {
            System.out.println(x);
        }
    }

    //num: 찾아야하는 수
    public static int binarySearch(int num, int[] array) {
        int left = 0;
        int right = array.length -1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (num > array[middle]) {
                left = middle + 1;
            } else if (num < array[middle]) {
                right = middle - 1;
            } else {
                return 1;
            }
        }
        return 0;

    }
}
