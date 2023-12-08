public class ArrayStack {
    private int size;
    private int last = 0;

    private int[] arrayStack;
    public ArrayStack(int size) {
        this.size = size;
        arrayStack = new int[size];
    }

    public void push(int input) {
        arrayStack[last] = input;
        last++;
    }

    public void pop() {
        arrayStack[last] = 0;
        last--;
    }


}
