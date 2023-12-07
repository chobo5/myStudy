package bitcamp.myapp.menu;

import bitcamp.util.AnsiEscape;
import java.util.Arrays;

public class MenuService<T> implements CRUDOperations<T>{
    private int currentIndex;

    private int arrayLength;

    private T[] objectArray;

    public MenuService(int arrayLength) {
        this.currentIndex = 0;
        this.arrayLength = arrayLength;
        this.objectArray = (T[]) new Object[arrayLength];
    }

    public void showMenu(String[] array) {
        System.out.println("[" + AnsiEscape.FONT_RED_BOLD + array[0] + AnsiEscape.RESET + "]");
        System.out.println();
        for (int i = 1; i < array.length ; i++) {
            System.out.println(array[i]);
        }
    }

    public void add(T object) {

        objectArray[currentIndex] = object;
        System.out.println("성공적으로 등록되었습니다.");

        currentIndex++;
        if (currentIndex > arrayLength) {
            arrayLength += 3;
            T[] newArray = Arrays.copyOf(objectArray, arrayLength);
            objectArray = newArray;
        }

    }

    public void get(int id) {
        if (id >= 0 && id < currentIndex) {
            System.out.println(objectArray[id]);
        } else {
            System.out.println(id +"번은 존재하지 않습니다.");
        }
    }

    public void modify(int id, T object) {
        if (id >= 0 && id < currentIndex) {
            objectArray[id] = object;
            System.out.println(id + "번 변경이 완료되었습니다..");
        } else {
            System.out.println(id +"번은 존재하지 않습니다.");
        }

    }

    public void delete(int id) {
        if (id >= 0 && id < currentIndex) {
            for (int i = id; i < currentIndex - 1; i++) {
                objectArray[i] = objectArray[i + 1];
            }
            objectArray[currentIndex - 1] = null; //주소의 인스턴스가 null이므로 garbage가 됬다.
            currentIndex--;
            System.out.println(id + "번이 삭제 되었습니다.");
        }
    }

    public void getAll() {
        for (int i = 0; i < currentIndex ; i++) {
            System.out.println(objectArray[i]);
        }
    }

}
