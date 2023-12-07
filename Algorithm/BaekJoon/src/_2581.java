import java.util.List;
import java.util.Scanner;

public class _2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        int n = sc.nextInt();
        sc.close();
        int min = 0;
        int sum = 0;

        for (int i = m; i <= n; i++) {
            int temp = 0;
            if (i == 1) {
                temp += 1;
            }

            for (int j = 2; j <= (i+1) / 2 ; j++) {

                if (i % j == 0) {
                    temp += 1;
                }

            }

            if (temp == 0) {
                sum += i;
                if (min == 0) {
                    min = i;
                }
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.print(min);
        }


    }
}
