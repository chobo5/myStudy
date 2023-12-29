package bitcamp.util;

import java.util.Arrays;

public class ArrayList<E> extends AbstractList<E>{
  private Object[] objects = new Object[3];

  public void add(E object) {
    if (this.size == this.objects.length) {
      int oldSize = this.objects.length;
      int newSize = oldSize + (oldSize >> 1);

      this.objects = Arrays.copyOf(this.objects, newSize);
    }

    this.objects[this.size++] = object;
  }

  public E remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }

    Object deleted = this.objects[index];

    System.arraycopy(this.objects, index + 1, this.objects, index, this.size - (index + 1));

    this.objects[--this.size] = null;

    return (E) deleted;
  }

  public boolean remove(E object) {
    for (int i = 0; i < size; i++) {
      if (objects[i].equals(object)) {
        this.remove(i);
        return true;
      }
    }
    return false;
  }

  public Object[] toArray() {
    return Arrays.copyOf(this.objects, this.size);
  }

  public E[] toArray(E[] arr) {
    if (arr.length >= this.size) {
      System.arraycopy(this.objects, 0, arr, 0, this.size);
      return arr;
    }
    return (E[]) Arrays.copyOf(this.objects, this.size, arr.getClass());
  }

  public E get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return (E) this.objects[index];
  }

  public E set(int index, E object) {
    if (index < 0 || index >= this.size) {
      return null;
    }

    Object old = this.objects[index];
    this.objects[index] = object;

    return (E) old;
  }

//  (1). 외부에서 구현한 패키지 맴버 클래스를 사용한 경우
//  @Override
//  public Iterator<E> iterator() {
//    return new ArrayListIterator<>(this);
//  }

//----------------------------------------------------------------------------------

//  (2). 스태틱 중첩클래스를 사용한 경우
//  @Override
//  public Iterator<E> iterator() {
//    return new IteratorImpl<>(this);
//  }

////  ArrayList 클래스안에서만 쓰일 클래스이기 떄문에 이렇게 하는것이 더 직관적이고 유지보수에 유리하다.
//  private static class IteratorImpl<E> implements Iterator<E> {
//    ArrayList<E> list;
//    int cursor;
//    public IteratorImpl(ArrayList<E> list) {
//      this.list = list;
//    }
//
//    @Override
//    public boolean hasNext() {
//      return cursor >= 0 && cursor < list.size();
//    }
//
//    @Override
//    public E next() {
//      return list.get(cursor++);
//    }
//  }

//----------------------------------------------------------------------------------

  //(4). local class
//  @Override
//  public Iterator<E> iterator() {
//    //로컬 클래스는 이 메서드 안에서만 사용할 수 있다.
//     class IteratorImpl<E> implements Iterator<E> {
//
//       //로컬 클래스도 non-static nested 클래스처럼
//       //바깥 클래스의 인스턴스 주소를 저장하는 코드가 자동으로 추가된다.
//      int cursor;
//
//      @Override
//      public boolean hasNext() {
//        return cursor >= 0 && cursor < ArrayList.this.size();
//
//      }
//
//      @Override
//      public E next() {
//        return (E) ArrayList.this.get(cursor++);
//      }
//    }
//
//    return new IteratorImpl<>();
//  }

//----------------------------------------------------------------------------------
  //(5). 익명클래스를 사용하는 경우
//  @Override
//  public Iterator<E> iterator() {
//    //익명 클래스는 이름이 없기 때문에 정의하는 즉시 인스턴스를 생성해야 한다.
//    Iterator<E> obj = new Iterator<E>() {
//      int cursor;
//
//      @Override
//      public boolean hasNext() {
//        return cursor >= 0 && cursor < ArrayList.this.size();
//
//      }
//
//      @Override
//      public E next() {
//        return (E) ArrayList.this.get(cursor++);
//      }
//    };
//    return obj;
//  }

  //----------------------------------------------------------------------------------
  //(6) 익명클래스 2 - 더 간결하게 표현하기
  @Override
  public Iterator<E> iterator() {
    //익명 클래스는 이름이 없기 때문에 정의하는 즉시 인스턴스를 생성해야 한다.
    return new Iterator<E>() {
      int cursor;

      @Override
      public boolean hasNext() {
        return cursor >= 0 && cursor < ArrayList.this.size();

      }

      @Override
      public E next() {
        return (E) ArrayList.this.get(cursor++);
      }
    };

  }


}
