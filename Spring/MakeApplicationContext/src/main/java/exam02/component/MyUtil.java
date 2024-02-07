package exam02.component;

import org.springframework.stereotype.Component;

@Component(value = "util")
public class MyUtil {
    public MyUtil() {
        System.out.println("MyUtil()");
    }

    public void print() {
        System.out.println("MyUtil의 인스턴스.print()");
    }
}
