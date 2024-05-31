import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int current = 666;
        int count =  1;
        while (count != n) {
            current++;
            if (String.valueOf(current).contains("666")) {
                count++;
            }
        }

        System.out.println(current);

    }


}


/*
1 666
2 1666
3 2666
4 3666
5 4666
6 5666
7 6666
8 6660
9 6661
10 6662
11 6663
 .
 .
17 6669
18 7666
19 8666
20 9666
21 10666
22 11666
27 16660

 */