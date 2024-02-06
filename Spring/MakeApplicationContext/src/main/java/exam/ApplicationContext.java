package exam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ApplicationContext {
    private Map container;
    private Properties props;

    //1. 싱글턴 패턴 적용 - 자기 자신을 참조하는 인스턴스를 반환한다.
    public static ApplicationContext getInstance() {
        return new ApplicationContext();
    }

    //2. 외부에서 인스턴스를 생성할 수 없도록 생성자의 접근 범위를 private으로 설정한다.
    private ApplicationContext() {
        container = new HashMap<String, Object>();
        props = new Properties();
        try {
            props.load(new FileInputStream("src/main/resources/Beans.properties"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public Object getBean(String id) {
        Object o = container.get(id);
        if (o == null) {
            try {
                //className문자열을 가지고 인스턴스를 생성할 수 있다.
                //Class.forName(className)은 CLASSPATH로부터 className에 해당하는 클래스를 찾은 후 해당 클래스 정보를 반환한다.
                //없으면 ClassNotFoundException 발생
                String className = props.getProperty(id);
                Class clazz = Class.forName(className);
                Constructor<?> constructor = clazz.getConstructor();

//                Method[] methods = clazz.getMethods();
//                for (Method method : methods) {
//                    System.out.println(method.getName());
//                }

                o = constructor.newInstance(); //clazz 정보를 이용해 얻은 생성자를 통해 인스턴스를 생성한다
                //Book book = new Book()과 같이 사용자가 직접 생성하지 않는 방법으로 생성할 수 있다.
                // => ClassLoader를 이용해 인스턴스를 생성한다고 한다.(아무것도 하지 않는 기본 생성자가 있어야한다.)
                container.put(id, o);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return o;
    }
}
