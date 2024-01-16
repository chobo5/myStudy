package class_2024_01_16;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Exam0120 {
    public static void main(String[] args) {
        Class<?> clazz = Exam0120.class;
        ClassLoader classLoader = Exam0120.class.getClassLoader(); // 클래스를 메모리에 로딩하는 일을 할 객체

        // 자동 생성할 클래스가 구현해야 하는 인터페이스 목록
        Class<?> aType = A.class; //A 인터페이스의 정보 = A의 타입정보 = A의 타입

        Class<?>[] interfaceTypes = new Class<?>[] {aType, B.class, C.class}; //class는 built in인 static변수이다
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("====> " + method.getName());
                return null;
            }
        };

        // newProxyInstance가 리턴한 객체는 A, B, C 인터페이스를 모두 구현한 객체이다.
        Object obj = Proxy.newProxyInstance(classLoader, interfaceTypes, invocationHandler);
        ((A) obj).m1();
        ((B) obj).m2();
        ((C) obj).m3();

    }
}
