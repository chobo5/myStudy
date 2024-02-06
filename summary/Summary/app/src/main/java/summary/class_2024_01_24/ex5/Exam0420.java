package class_2024_01_24.ex5;

//synchronized 메서드 적용 후
public class Exam0420 {
    public static void main(String[] args) {
        Worker2 w1 = new Worker2("홍길동");
        Worker2 w2 = new Worker2("임꺽정");

        w1.start();
        w2.start();
    }

    synchronized static void play(String threadName) throws Exception {
        System.out.println(threadName);
        Thread.sleep(3000);
    }

    private static void delay() {
        int delayCount = (int) (Math.random() * 1000);
        for (int i = 0; i < delayCount; i++)
            Math.asin(45.765); // CPU를 뺏길 기회를 제공
    }

    static class Worker2 extends Thread {
        public Worker2(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                play(getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
