import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();

        in.close();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count +=  toNumber(str.charAt(i));
        }
        System.out.println(count);
    }

    static int toNumber(char c) {
        if (c <= 'C') {
            return 3;
        } else if (c <= 'F') {
            return 4;
        } else if (c <= 'I') {
            return 5;
        } else if (c <= 'L') {
            return 6;
        } else if (c <= 'O') {
            return 7;
        } else if (c <= 'S') {
            return 8;
        } else if (c <= 'V') {
            return 9;
        } else {
            return 10;
        }
    }
}
