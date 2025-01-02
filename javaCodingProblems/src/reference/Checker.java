package reference;

import java.util.Optional;

public class Checker {
    public static void checkObj(Object obj) {
        Optional.ofNullable(obj)
                .orElseThrow(() -> new NullPointerException("object is null"));

    }

    public static void main(String[] args) {
        String hello = "Hello, world";
        Object nullValue = null;
        Checker.checkObj(hello);
        Checker.checkObj(nullValue);
    }
}
