package multiThread;

public class ThreadExam {
    public static void main(String[] args) {
        //방법1
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t.start();

        //방법2
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();
    }



}
