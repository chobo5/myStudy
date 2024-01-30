package arrayList;

import java.util.Arrays;

public class ArrayList<E> {
    private Object[] arrayList = new Object[3];
    private int position = 0; //새로운 참조가 들어가야할 위치 = 현재의 길이

    public int size() {
        return this.position;
    }

    public void add(E object) {
        if (arrayList.length == position) {
            int newLength = position + (position >> 1); //실제로 1.5배 정도 길어진다고함

            Object[] newArrayList = new Object[newLength];
            //배열 복사하기

            //방법 1. 반복문
//            for (int i = 0; i < position; i++) {
//                newArrayList[i] = arrayList[i];
//            }

            //방법 2. System.arrayCopy()
            //System.arrayCopy(원본, 원본에서읽을시작위치, 복사본, 복사본에저장할처음위치, 복사본에저장할길이)
            System.arraycopy(arrayList, 0, newArrayList, 0, position);

            this.arrayList = newArrayList;
        }

        arrayList[position] = object;
        position++;

    }

    public E remove(int index) {
        if (index < 0 || index >= position) {
            return null;
        }

        E removed = (E)arrayList[index];
        //배열 당기기
        //방법 1.반복문
//        for (int i = index; i < position - 1 ; i++) {
//            arrayList[i] = arrayList[i + 1];
//        }

        //방법 2.카피
        System.arraycopy(arrayList, index + 1, arrayList, index, (position - index -1));

        arrayList[--position] = 0;
        return removed;
    }

    public E get(int index) {
        return (E) arrayList[index];
    }

    public E set(int index, E object) {
        arrayList[index] = object;
        return (E)arrayList[index];
    }

    //어떤 배열을 parameter를 받아서 호출하는 경우
    //제네릭 타입의 배열의 크기가 크다면 받은 배열에 담아서 다시 보내주지만
    //배열의 크기가 작다면 새로운 배열을 만들어 리턴해준다
    //제네릭 타입으로 받을수 있다.
    public E[] toArray(E[] arr) {
        if (arr.length > this.position) {
            System.arraycopy(arrayList, 0, arr, 0, this.position);
            return arr;
        }

        return (E[]) Arrays.copyOf(arrayList, this.position, arr.getClass());
    }

    //parameter 없이 호출하면
    //Objects배열을 그대로 리턴해준다.
    //타입을 직접 타입캐스팅 해야한다.
    public Object[] toArray() {
        return Arrays.copyOf(arrayList, this.position);
    }
}
