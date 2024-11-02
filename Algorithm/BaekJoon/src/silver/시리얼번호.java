package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 시리얼번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.readLine();
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                int a = 0;
                int b = 0;
                for (int i = 0; i < o1.length(); i++) {
                    int num1 = o1.charAt(i) - '0';
                    int num2 = o2.charAt(i) - '0';
                    if (num1 > 0 && num1 < 10) {
                        a += num1;
                    }
                    if (num2 > 0 && num2 < 10) {
                        b += num2;
                    }
                }
                if (a == b) {
                    return o1.compareToIgnoreCase(o2);
                }
                return a - b;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }


}
