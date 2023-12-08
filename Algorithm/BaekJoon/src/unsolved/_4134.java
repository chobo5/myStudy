package unsolved;

import java.util.Scanner;

public class _4134 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            sc.nextLine();
        }
        int[] result = new int[n];

        for(int i = 0; i < array.length - 1; i++) {
            int x = array[i];
            while (true) {
                if (gcd(array[i], x) == 1){
                    result[i] = x;
                    break;
                }
                x++;
            }
        }

        for (int x : result) {
            System.out.println(x);
        }
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
