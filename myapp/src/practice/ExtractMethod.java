package practice;
import java.util.Scanner;

public class ExtractMethod {
    static void printSapces(int spaceLen) {
        // 별 앞에 공백 출력
        int spaceCnt = 1;
        while (spaceCnt <= spaceLen) {
            System.out.print(" ");
            spaceCnt++;
        }
    }

    static void printStars(int starLen) {
        // 별 출력
        int starCnt = 1;
        while (starCnt <= starLen) {
            System.out.print("*");
            starCnt++;
        }
    }

    static int computeSpaceLength(int len, int starLen) {
        return ((len - starLen) / 2);
    }

    static int promptInt() {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("밑변의 길이? ");
        int len = keyScan.nextInt();
        keyScan.close();
        return len;
    }
    public static void main(String[] args) {
        int len = promptInt();

        for (int starLen = 1; starLen <= len; starLen += 2) {
            printSapces(computeSpaceLength(len, starLen));

            printStars(starLen);
            // 출력 줄 바꾸기
            System.out.println();
        }

    }
}
