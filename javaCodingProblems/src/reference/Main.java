package reference;

import javax.swing.JCheckBox;

public class Main {
    public static void main(String[] args) {
        String hello = "Hello, world";
        Object nullValue = null;
        Checker.checkObj(hello);
        Checker.checkObj(nullValue);
    }
}
