import java.util.Scanner;

public class _19532 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();
        sc.close();
        int y = (d * c - a * f) / (b * d - a * e);
        int x = ((c*e- b*f) / (a*e - b*d));
        System.out.print(x + " " + y);
    }
}
