import java.util.Scanner;

public class _2869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();
        int day = 0;
        sc.close();
        int dayDistance = a - b;
        int minusLastDay = v - a;

        if (dayDistance > minusLastDay) {
            day = minusLastDay / dayDistance + 2;
        } else {
            day = minusLastDay / dayDistance + 1;
        }
        System.out.println(day);


    }
}
