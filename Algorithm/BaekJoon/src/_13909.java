import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13909 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(in.readLine());
        in.close();
        System.out.println((int) Math.floor(Math.sqrt(n)));

        //닫힘 - false, 열림 - true


        /*
        1 - 1개
        2 - 1개
        3 - 1개
        4 - 1001 2개
        5 - 10010 2개
        6 - 100100 2개
        7 - 1001000 2개
        8 - 10010000 2개
        9 - 100100001 3개
         */
    }
}
