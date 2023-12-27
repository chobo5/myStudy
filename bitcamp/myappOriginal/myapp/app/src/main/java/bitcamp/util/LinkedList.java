package bitcamp.util;

public class LinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public int size() {
        return size;
    }

    private Node<E> findNode(int index) {
        int cursor = 0;
        Node<E> node = first;
        while (cursor++ < index) {
            node = node.next;
        }
        return node;
    }

//    private int findNode(E value) {
//
//    }

    public void add(E value) {
        Node<E> node = new Node<>();
        node.value = value;
        if (last == null) { //node가 한개도 만들어지지 않음
            first = last = node;
        } else {
            //기존에 노드 객체가 있을 때
            //마지막 노드의 다음 노드로 새로 만든 노드를 가리키게 한다.
            last.next = node;
            last = node;
        }
        size++;
    }

    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("유효하지 않은 인덱스");
        }
        Node<E> node = new Node<>();
        node.value = value;

        if (size == 0) {
            first = node;
            last = node;
        } else if (index == 0) {
            node.next = first;
            first = node;
        } else if (index == size) {
            last.next = node;
            last = node;
        } else {
            //해당 인덱스의 이전 노드를 찾는다.
            Node<E> prevNode = findNode(index - 1);
            node.next = prevNode.next;
            prevNode.next = node;
        }

        size++;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node<E> node = first;
        int index = 0;
        while (node != null) {
            arr[index] = node.value;
            node = node.next;
            index++;
        }
        return arr;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("유효하지 않은 인덱스");
        }
        Node<E> node = findNode(index);
        return node.value;
    }

    public E set(int index, E object) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("유효하지 않은 인덱스");
        }
        Node<E> node = findNode(index);
        E oldValue = node.value;
        node.value = object;
        return oldValue;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("유효하지 않은 인덱스");
        }
        Node<E> node = first;
        E deleted;
        if (size == 1) {
            deleted = first.value;
            first = last = null;
        } else if (index == 0) {
            deleted = first.value;
            first = first.next;
        } else if (index == size - 1) {
            deleted = last.value;
            //index의 이전노드를 찾는다.
            node = findNode(index - 1);
            node.next = null;
            last = node;
        } else {
            //index의 이전노드를 찾는다
            node = findNode(index - 1);
            deleted = node.next.value;
            //이전노드의 다음노드는 다음다음 노드이다.
            node.next = node.next.next;
        }
        size--;
        return deleted;
    }

    public boolean remove(E value) {
        Node<E> prevNode = null;
        Node<E> node = null;
        Node<E> cursor = first;

        while (cursor != null) {
            if (cursor.value.equals(value)) {
                node = cursor;
                break;
            }
            prevNode = cursor;
            cursor = cursor.next;
        }

        if (node == null) {
            return false;
        }

        if (node == first) {
            first = first.next;
            if (first == null) { //first == null 인건 first.next가 null이었으니 사이즈가 1일떄를 의미한다.
                last = null;
            }
        } else {
            prevNode.next = node.next;
        }

        //찾고자하는 노드의 이전노드는 찾고자하는 노드의 다음노드이다.
        size--;
        return true;
    }


    private static class Node<E> {
        E value;
        Node<E> next; //
    }
}
