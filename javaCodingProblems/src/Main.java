import string.StringCounter;
import string.StringFinder;

public class Main {
    public static void main(String[] args) {
        //문자 개수 세기
        String str = "banana";
        int countMethodOne = StringCounter.countMethodOne(str);
        int countMethodTwo = StringCounter.countMethodTwo(str);
        System.out.println(countMethodOne);
        System.out.println(countMethodTwo);

        //반복되지 않는 첫번째 문자 찾기
        String repeatedString = "smnaklbvsaiefwafndjklsfnldafdsy";
        String firstUnrepeated = StringFinder.findFirstUnrepeated(repeatedString);
        System.out.println(firstUnrepeated);
    }
}