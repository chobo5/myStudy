package class_2024_01_16.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Exam0121 {
    public static void main(String[] args) {

        Class<?>[] interfaceTypes = new Class<?>[] {B.class, B.class, C.class}; //class는 built in인 static변수이다
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("====> " + method.getName());
                return null;
            }
        };

        // newProxyInstance가 리턴한 객체는 A, B, C 인터페이스를 모두 구현한 객체이다.
        Object obj = Proxy.newProxyInstance(Exam0121.class.getClassLoader(),
                new Class<?>[] {B.class, B.class, C.class},
               (proxy, method , params) -> {
                        System.out.println("====> " + method.getName());
                        return null;
                });
        ((A) obj).m1();
        ((B) obj).m2();
        ((C) obj).m3();

    }
}
