package silver;

import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String str = "hello world";
        StringBuilder sb = new StringBuilder(str);
//        System.out.println(sb.reverse().toString());

        StringBuilder sb2 = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i--) {
            sb2.append(str.charAt(i));
        }
        System.out.println(sb2);

    }
}
