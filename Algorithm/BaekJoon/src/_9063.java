import java.util.Arrays;
import java.util.Scanner;

public class _9063 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        if (n == 1) {
            System.out.println(0);
            return;
        }

        int[] xPoints = new int[n];
        int[] yPoints = new int[n];

        for (int i = 0; i < n; i++) {
            xPoints[i] = sc.nextInt();
            yPoints[i] = sc.nextInt();
            sc.nextLine();
        }
        Arrays.sort(xPoints);
        Arrays.sort(yPoints);

        System.out.println((xPoints[n - 1] - xPoints[0]) * (yPoints[n - 1] - yPoints[0]));

    }

}
