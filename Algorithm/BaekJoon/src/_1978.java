import java.util.Scanner;

public class _1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int temp = 0;

            for (int j = 1; j <= x; j++) {
                if (x % j == 0) temp += 1;
            }

            if (temp == 2) count += 1;
        }
        sc.close();
        System.out.print(count);
    }
}
