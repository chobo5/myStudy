import java.util.ArrayList;
import java.util.Scanner;

public class _11653 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        StringBuilder sb = new StringBuilder();
        int dividedN = n;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (dividedN % i == 0) {
                sb.append(i).append("\n");
                dividedN = dividedN / i;
            }
        }

        if (dividedN != 1) {
            sb.append(dividedN);
        }

        System.out.println(sb);



    }
}
