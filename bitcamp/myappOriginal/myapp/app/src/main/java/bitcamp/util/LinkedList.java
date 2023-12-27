package bitcamp.util;

public class LinkedList {
    private Node first;
    private Node last;
    private int size = 0;

    private Node findNode(int index) {
        int cursor = 0;
        Node node = first;
        while(cursor++ < index) {
            node = node.next;
        }
        return node;
    }

    public void add(Object value) {
        Node node = new Node();
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

    public void add(int index, Object value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("유효하지 않은 인덱스");
        }
        Node node = new Node();
        node.value = value;

        if(size == 0) {
            first = node;
            last = node;
        } else if (index == 0) {
            node.next = first;
            first = node;
        } else if (index == size) {
            last.next = node;
            last = node;
        } else {
            int cursor = 0;
            //해당 인덱스의 이전 노드를 찾는다.
            Node prevNode = findNode(index - 1);
            node.next = prevNode.next;
            prevNode.next = node;
        }

        size++;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node node = first;
        int index = 0;
        while (node != null) {
            arr[index] = node.value;
            node = node.next;
            index++;
        }
        return arr;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("유효하지 않은 인덱스");
        }
        Node node = findNode(index);
        return node.value;
    }

    public Object set(int index, Object object) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("유효하지 않은 인덱스");
        }
        Node node = findNode(index);
        Object oldValue = node.value;
        node.value = object;
        return oldValue;
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("유효하지 않은 인덱스");
        }
        Node node = first;
        Object deleted;
        if (size == 1) {
            deleted = first.value;
            first = last = null;
        } else if(index == 0) {
            deleted = first.value;
            first = first.next;
        }else if (index == size - 1) {
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


    private static class Node {
        Object value;
        Node next; //
    }
}
