package bitcamp.util;

import java.lang.Object;
import java.util.Arrays;

public class ObjectRepository<E> {
    private Object[] objects = new Object[3];
    private int length = 0;

    public int size() {
        return this.length;
    }

    public void add(E object) {
        if (this.objects.length == this.length) {
            int oldSize = this.length;
            int newSize = oldSize + (oldSize >> 1);

//            Object[] arr = new Object[newSize];
//            for (int i = 0; i < oldSize; i++) {
//                arr[i] = this.objects[i];
//            }

            Object[] arr = Arrays.copyOf(objects, newSize);
            System.out.println("arr.lenght: " + arr.length);

            this.objects = arr;
        }

        this.objects[this.length++] = object;
    }

    public E remove(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        Object deleted = (Object) objects[index];
        for (int i = index; i < (this.length - 1); i++) {
            this.objects[i] = this.objects[i + 1];
        }

        this.objects[--this.length] = null;
        return (E) deleted;
    }

    public Object[] toArray() {
        if (length == 0) {
            return null;
        }
//        Object[] newArray = new Object[length];
//        for (int i = 0; i < length; i++) {
//            newArray[i] = objects[i];
//        }
//
//        return newArray;
        return Arrays.copyOf(objects, length);
    }

    public E[] toArray(E[] arr) {
        if (arr.length >= this.length) {
            System.arraycopy(this.objects, 0, arr, 0, this.length);
            return arr;
        }
//        for (int i = 0; i < this.length; i++) {
//            arr[i] = (E) this.objects[i];
//        }
        return (E[]) Arrays.copyOf(this.objects, this.length, arr.getClass());

    }

    public E get(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        return (E) objects[index];

    }

    public E set(int index, E object) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        objects[index] = object;
        return (E) objects[index];
    }
}
