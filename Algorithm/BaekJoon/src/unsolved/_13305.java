package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cities = Integer.parseInt(in.readLine());
        long[] pathLengths = new long[cities - 1];
        long[] oilPrices = new long[cities];
        StringTokenizer st;
        String line2 = in.readLine();
        st = new StringTokenizer(line2, " ");
        for (int i = 0; i < pathLengths.length ; i++) {
            pathLengths[i] = Long.parseLong(st.nextToken());
        }

        long minPrice = 1000000000;
        long location = 0;
        String line3 = in.readLine();
        st = new StringTokenizer(line3, " ");
        for (int i = 0; i < oilPrices.length ; i++) {
            oilPrices[i] = Long.parseLong(st.nextToken());
            if (oilPrices[i] < minPrice) {
                minPrice = oilPrices[i];
                location = i;
            }
        }
        System.out.println(minPrice + " " + location);

        in.close();
        long currentPrice = oilPrices[0];
        long sum = oilPrices[0] * pathLengths[0];
        for (int i = 1; i < cities - 1; i++) {
            if (currentPrice < oilPrices[i] && location > i) { //다음 도시 오일가격이 더 비싸고 아직 최저값에 도착안했을떄
                sum += currentPrice * pathLengths[i];
            } else if (currentPrice > oilPrices[i] && location > i) { //다음 도시 오일가격이 더 싸고 아직 최저값에 도착안했을떄
                currentPrice = oilPrices[i];
                sum += currentPrice * pathLengths[i];
            } else if (i >= location) {
                sum += minPrice * pathLengths[i];
            }
        }
        System.out.println(sum);






    }
}
