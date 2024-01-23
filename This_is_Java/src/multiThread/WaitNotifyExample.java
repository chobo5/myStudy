package multiThread;

public class WaitNotifyExample {
    public static void main(String[] args) {
        WorkObject workObject = new WorkObject();

        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                workObject.methodA();
            }
        });


        Thread threadB = new Thread(() -> {
            for (int i = 0; i <10; i++) {
                workObject.methodB();
            }

        });
        threadA.start();
        threadA.start();
    }
}
