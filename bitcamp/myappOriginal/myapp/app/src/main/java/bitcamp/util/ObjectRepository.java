package bitcamp.util;

import java.lang.Object;

public class ObjectRepository {
    private Object[] objects = new java.lang.Object[3];
    private int length = 0;

    public void add(java.lang.Object object) {
        if (this.objects.length == this.length) {
            int oldSize = this.length;
            int newSize = oldSize + (oldSize >> 1);

            java.lang.Object[] arr = new java.lang.Object[newSize];
            for (int i = 0; i < oldSize; i++) {
                arr[i] = this.objects[i];
            }

            this.objects = arr;
        }

        this.objects[this.length++] = object;
    }

    public Object remove(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        Object deleted = (Object) objects[index];
        for (int i = index; i < (this.length - 1); i++) {
            this.objects[i] = this.objects[i + 1];
        }
        this.objects[--this.length] = null;
        return deleted;
    }

    public Object[] toArray() {
        if (length == 0) {
            return null;
        }
        Object[] newArray = new Object[length];
        for (int i = 0; i < length; i++) {
            newArray[i] = objects[i];
        }

        return newArray;
    }

    public Object get(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        return objects[index];

    }

    public Object set(int index, Object object) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        objects[index] = object;
        return objects[index];
    }
}
