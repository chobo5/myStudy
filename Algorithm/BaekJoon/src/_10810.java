import java.util.Scanner;

public class _10810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] basket = new int[n];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            sc.nextLine();
            for (int j = a-1; j <= b-1; j++) {
                basket[j] = c;
            }
        }

        for (int x : basket) {
            System.out.print(x + " ");
        }
    }
}
