import java.util.Arrays;
import java.util.Scanner;

public class _2485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            sc.nextLine();
        }

        int[] distances = new int[n - 1];
        for (int i = 0; i < n - 1 ; i++) {
            distances[i] = array[i + 1] - array[i];
        }

        Arrays.sort(distances);
        int standard = gcd(distances[0], distances[1]);

        for (int i = 1; i < distances.length; i++) {
            standard = gcd(standard, distances[i]);
        }



        System.out.println((array[n - 1] - array[0]) / standard + 1 - n);

    }
    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
