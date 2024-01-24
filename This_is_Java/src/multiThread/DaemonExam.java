package multiThread;

public class DaemonExam {
    public static void main(String[] args) {
        Thread autoSaveThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
                System.out.println("작업 내용을 저장");
            }
        });

        autoSaveThread.setDaemon(true);
        autoSaveThread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        System.out.println("메인 스레드 종료");
    }
}
