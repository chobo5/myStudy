package multiThread;

public class InterruptExam {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("실행중");
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("리소스 정리");
                System.out.println("실행 종료");
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt(); //main thread의 흐름에서 다른 thread를 종료시킬 수 있다.
    }
}
