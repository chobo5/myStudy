package bitcamp.util;

public class Stack<E> extends LinkedList<E> {
    public boolean empty() {
       return this.size() == 0;
    }

    public E peek() {
        return this.get(this.size() - 1);
    }

    public E push(E item) {
        add(item);
        return this.get(this.size() - 1);
    }

    public E pop() {
        return this.remove(size() - 1);
    }
}
