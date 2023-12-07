import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _24305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totoalPrice = Integer.parseInt(br.readLine());
        int total = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 0; i < total ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int price = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            int linePrice = price * number;
            sum += linePrice;
        }

        if (totoalPrice == sum) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        
    }

}
