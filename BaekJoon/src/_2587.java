import java.util.Scanner;

public class _2587 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[5];
        for (int i = 0; i < 5 ; i++) {
            array[i] = sc.nextInt();
            sc.nextLine();
        }
        sc.close();
        int sum = 0;
        for(int x : array) {
            sum += x;
        }
        System.out.println(sum / 5);

        //정렬
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        //중앙값
        System.out.println(array[2]);
    }
}
