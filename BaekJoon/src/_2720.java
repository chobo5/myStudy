import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t ; i++) {
            int changes = Integer.parseInt(br.readLine());
            int quarter; //25
            int dime; //10
            int nickel; //5
            int penny; // 1
            quarter = changes / 25;
            dime = changes % 25 / 10;
            nickel = (changes - (quarter * 25) - (dime* 10)) / 5;
            penny = changes % 5 / 1;
            System.out.println(quarter + " " + dime + " " + nickel + " " + penny);
        }
        br.close();
    }
}
