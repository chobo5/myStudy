import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class _1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        in.close();
        String[] strArr = str.split("");

        Map<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = strArr[i].toUpperCase();
            if (hashMap.containsKey(strArr[i])) {
                hashMap.replace(strArr[i], hashMap.get(strArr[i]) + 1);
            } else {
                hashMap.put(strArr[i], 1);
            }
        }

        String max1 = "";
        String max2 = "";
        int count1 = 0;
        int count2 = 0;
        for (Entry<String, Integer> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value > count1) {
                max1 = key;
                count1 = value;
            } else if (value == count1) {
                max2 = key;
                count2 = value;
            }
        }

        if(count1 == count2) {
            System.out.println("?");
        } else {
            if (count1 > count2) {
                System.out.println(max1);
            } else {
                System.out.println(max2);
            }
        }





    }
}
