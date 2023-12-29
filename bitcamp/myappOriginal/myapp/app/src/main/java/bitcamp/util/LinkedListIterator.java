package bitcamp.util;

public class LinkedListIterator<E> implements Iterator<E>{

    LinkedList<E> linkedList;
    int cursor;

    public LinkedListIterator(LinkedList<E> linkedList) {
        this.linkedList = linkedList;
    }

    @Override
    public boolean hasNext() {
        return cursor >= 0 && cursor < linkedList.size();
    }

    @Override
    public E next() {
        return linkedList.get(cursor++);
    }
}
