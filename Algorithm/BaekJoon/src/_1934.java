import java.util.Scanner;

public class _1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            array[i] = a * b / gcd(a, b);
            sc.nextLine();
        }
        sc.close();

        for (int num : array) {
            System.out.println(num);
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
