package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Board;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class AbstractDao<T> implements BasicDao<T> {
    protected ArrayList<T> list;

    private String filepath;

    public AbstractDao(String filepath) {
        this.filepath = filepath;
        loadData();
    }

    protected void loadData() {
        System.out.println("test...");


        try (BufferedReader in = new BufferedReader(new FileReader(filepath))) {
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = in.readLine()) != null) {
                sb.append(str);
            }

            //이 클래스가 다루는 데이터의 클래스 정보를 알아낸다.
            Class<?> dataType = (Class) ((ParameterizedType) this.getClass() //이 메서드를 호출한 클래스의 정보를 알아낸다.
                    .getGenericSuperclass())
                    .getActualTypeArguments()[0];

            //버퍼에 저장된 JSON 문자열을 가지고 컬렉션 객체를 생성한다.
            //이 타입파라미터 T가 가리키는 클래스가 무엇인지 알아낸다.
            list = (ArrayList<T>) new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(sb.toString(),
                    TypeToken.getParameterized(ArrayList.class, dataType));

        } catch (Exception e) {
            list = new ArrayList<>();
            throw new DaoException("데이터 로딩 오류", e);
        }
    }

    protected void saveData() {

        try (BufferedWriter out = new BufferedWriter(new FileWriter(filepath))) {
            out.write(new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list));
        } catch (Exception e) {
            throw new DaoException("데이터 저장 오류");
        }
    }


}
