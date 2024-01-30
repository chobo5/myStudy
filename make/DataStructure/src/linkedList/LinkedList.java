package linkedList;

public class LinkedList<E> {
    private static class Node<T> {
        private T value;
        private Node<T> next;

    }

    private Node<E> first;
    private Node<E> last;

    private int size = 0;

    public int size() {
        return size;
    }

    public void add(E object) {
        Node<E> node = new Node<>();
        node.value = object;
        if (size == 0) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public void add(int index, E object) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index가 범위를 벗어났습니다");
        }
        Node<E> node = new Node<>();
        node.value = object;
        if (index == 0) {
            node.next = first;
            first = node;
        } else if (index == size) {
            last.next = node;
            last = node;
        } else {
            Node<E> prevNode = findNode(index - 1);
            node.next = prevNode.next;
            prevNode.next = node;
        }
        size++;
    }


    public E get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("LinkedList 범위를 벗어났습니다");
        }

        return findNode(index).value;
    }

    public E set(int index, E object) {
        if (index < 0 || index > size -1) {
            throw new IndexOutOfBoundsException("index가 범위를 벗어났습니다");
        }
        Node<E> node = findNode(index);
        E old = node.value;
        node.value = object;
        return old;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            arr[i] = node.value;
            node = node.next;
        }
        return arr;
    }

    public E remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index가 범위를 벗어났습니다");
        }
        E deleted;
        if (size == 1) {
            deleted = first.value;
            first = last = null;
        } else if (index == 0) {
            deleted = first.value;
            first = first.next;
        } else if (index == size - 1) {
            deleted = last.value;
            Node<E> prevNode = findNode(index - 1);
            last = prevNode;
        } else {
            Node<E> prevNode = findNode(index - 1);
            deleted = prevNode.next.value;
            prevNode.next = prevNode.next.next;
        }

        size--;
        return deleted;
    }

    public boolean remove(E object) {
        Node<E> prevNode = null;
        Node<E> node = null;
        Node<E> currentNode = first;

        //노드의 값이 찾으려는 값과 같은지 검사한다.
        while (currentNode != null) {
            if (currentNode.value.equals(object)) {
                node = currentNode; //있다면 추가하고 반복문을 빠져나간다.
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.next; //없다면 다음 노드로 넘어건다.
        }
        //노드가 비어있다면
        if (node == null) {
            return false;
        }

        //노드가 있다면 삭제한다.
        if (size == 1) {
            first = last = null;
        } else if (node == first) {
            first = first.next;
        } else if (node == last) {
            prevNode.next = null;
            last = prevNode;
        } else {
            prevNode.next = currentNode.next;
        }
        size--;
        return true;

    }

    private Node<E> findNode(int index) {
        int current = 0;
        Node<E> node = first;
        while (current++ < index) {
            node = node.next;
        }
        return node;
    }


}
