import java.util.Scanner;

public class _2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int count = 0;
        if (n % 5 == 0) {
            count = n /5;
        } else {
            while (n > 0) {
                n -= 3;
                count += 1;
                if (n % 5 == 0) {
                    count += n / 5;
                    n = 0;
                }
            }
            if (n < 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(count);

    }
}
