package app.dao;

import java.util.List;

public interface Dao<T> {
    void add(T t);
    List<T> find(String input);

    List<T> findAll();
    T update(T t);
    int delete();

}
