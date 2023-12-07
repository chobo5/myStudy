import java.io.IOException;
import java.util.Scanner;

public class _1193 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int up = 1;
        int down = 1;
        int temp = 1;

        while (true) {
            if (n <= temp) break;
            n -= temp;
            temp++;
        }

        if (temp % 2 == 0) {
            up = n;
            down = temp + 1 - n;
        } else {
            up = temp + 1 - n;
            down = n;
        }
        System.out.print(up + "/" + down);
        /*
        1/1

        1/2
        2/1

        3/1
        2/2
        1/3

        1/4
        2/3
        3/2
        4/1

        5/1
        4/2
        3/3
        2/4
        1/5
         */

    }
}
