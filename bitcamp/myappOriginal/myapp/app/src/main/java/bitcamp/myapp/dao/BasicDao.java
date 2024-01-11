package bitcamp.myapp.dao;

import java.util.List;

public interface BasicDao<T> {

    public void add(T value);

    public int delete(int no);

    public List<T> findAll();

    public T findBy(int no);

    public int update(T value);

}
