package multiThread;

public class WorkObject {
    public synchronized void methodA() {
        System.out.println(Thread.currentThread().getName() + " method A 작업 실행");
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void methodB() {
        System.out.println(Thread.currentThread().getName() + " method B 작업 실행");
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
