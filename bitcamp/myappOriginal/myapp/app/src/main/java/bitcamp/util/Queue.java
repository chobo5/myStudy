package bitcamp.util;

public class Queue<E> extends LinkedList<E> {
    public boolean offer(E e) {
        int preSize = this.size();
        this.add(e);
        int size = this.size();
        return preSize + 1 == size;
    }

    public E peek() {
        return this.get(0);
    }

    public E poll() {
        if (this.size() == 0) {
            return null;
        } else {
            return this.remove(0);
        }
    }
}
