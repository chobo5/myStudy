package bitcamp.myapp.menu;

public interface CRUDOperations<T> {
    public void add(T ojbect);
    public void get(int id);
    public void modify(int id, T object);

    public void delete(int id);

    public void getAll();
}
