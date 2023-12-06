package exam;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ApplicationContext {
    // 1. 싱글턴 패턴 적용 - 자기 자신을 참조하는 static한 필드를 선언한다.
    private static ApplicationContext instance = new ApplicationContext();
    private Properties props;

    // 3. 1에서 만든 instance를 반환한다.
    public static ApplicationContext getInstance() {
        return instance;
    }
    private Map objectMap;

    // 2. 외부에서 생성하지 못하도록 private하게 만든다.
    private ApplicationContext() {
        props = new Properties();
        objectMap = new HashMap<String, Object>();
        try {
            props.load(new FileInputStream("src/main/resources/Beans.properties")); //Book 설정파
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String id) throws Exception {
        Object o1 = objectMap.get(id);
        if (o1 == null) {
            String className = props.getProperty(id); //id를 통해 property를 얻는다.book1 -> exam.Book
            //className문자열을 가지고 인스턴스를 생성할 수 있다.
            //Class.forName(className)은 CLASSPATH로부터 className에 해당하는 클래스를 찾은 후 해당 클래스 정보를 반환한다.
            //없으면 ClassNotFoundException 발생
            Class clazz = Class.forName(className);
//            Method[] methods = clazz.getMethods();

//        for (Method m :methods) {
//            System.out.println(m.getName());
//        }

            Object o = clazz.newInstance(); //clazz 정보를 이용해 인스턴스를 생성한다
            //Book book = new Book()과 같이 사용자가 직접 생성하지 않는 방법으로 생성할 수 있다.
            // => ClassLoader를 이용해 인스턴스를 생성한다고 한다.(아무것도 하지 않는 기본 생성자가 있어야한다.)
            objectMap.put(id, o);
            return o;
        } else {
            o1 = objectMap.get(id);
        }
        return o1;
    }


}
