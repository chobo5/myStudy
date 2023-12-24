import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a < x) {
                sb.append(a).append(" ");
            }
        }

        System.out.println(sb);
    }
}
