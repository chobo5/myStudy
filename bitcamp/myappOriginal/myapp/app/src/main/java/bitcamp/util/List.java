package bitcamp.util;

import java.util.Arrays;

public interface List<E> {

  public void add(E object);

  public E remove(int index);

  public boolean remove(E object);

  public Object[] toArray();

  public E[] toArray(E[] arr);

  public E get(int index);

  public E set(int index, E object);

  public int size();
}
