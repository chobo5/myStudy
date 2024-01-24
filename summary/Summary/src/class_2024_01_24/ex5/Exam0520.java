package class_2024_01_24.ex5;

//synchronized 인스턴스 메서드 적용 후
public class Exam0520 {
    public static void main(String[] args) {
        Job job = new Job();
        Worker2 w1 = new Worker2("홍길동", job);
        Worker2 w2 = new Worker2("임꺽정", job);

        w1.start();
        w2.start();
    }

    static class Job {
       synchronized void play(String threadName) throws Exception {
            System.out.println(threadName);
            Thread.sleep(10000);
        }
    }


    static class Worker2 extends Thread {
        Job job;

        public Worker2(String name, Job job) {
            super(name);
            this.job = job;
        }

        @Override
        public void run() {
            try {

                job.play(getName());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
