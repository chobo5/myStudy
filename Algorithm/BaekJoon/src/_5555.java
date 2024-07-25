import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5555 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        int n = Integer.parseInt(in.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            String ring = in.readLine();
            for (int j = 0; j < ring.length(); j++) {
                boolean contains = true;
                for (int k = j; k < j + str.length(); k++) {
                    int index = k % 10;
                    if (ring.charAt(index) != str.charAt(k - j)) {
                        contains = false;
                        break;
                    }
                }
                if (contains) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
        in.close();



    }
}
