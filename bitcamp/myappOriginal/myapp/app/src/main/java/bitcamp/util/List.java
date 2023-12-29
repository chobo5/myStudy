package bitcamp.util;

import java.util.Arrays;

public interface List<E> {

    void add(E object);

    E remove(int index);

    boolean remove(E object);

    Object[] toArray();

    E[] toArray(E[] arr);

    E get(int index);

    E set(int index, E object);

    int size();

    Iterator<E> iterator();
}
