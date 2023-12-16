import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _25501 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = in.readLine();
            String[] strArr = str.split("");

            int result = isPalindrom(strArr);
            sb.append(result).append(" ").append(count).append("\n");
            count = 0;
        }
        in.close();
        System.out.println(sb);

    }

    static int recursion(String[] strArr, int l, int r) {
        count += 1;
        if(l >= r) {
            return 1;
        } else if(!strArr[l].equals(strArr[r]) ) {
            return 0;
        } else {
            return recursion(strArr, l+1, r-1);
        }

    }

    static int isPalindrom(String[] strArr) {
        return recursion(strArr, 0, strArr.length - 1);
    }
}
