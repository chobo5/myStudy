package class_2024_01_24.ex5;

//synchronized 메서드 적용 전
public class Exam0630 {
    public static void main(String[] args) {
        Job job1 = new Job();
        Job job2 = new Job();

        Worker1 w1 = new Worker1("홍길동", job1);
        Worker2 w2 = new Worker2("임꺽정", job1);
        Worker3 w3 = new Worker3("유관순", job2);
        Worker4 w4 = new Worker4("안중근", job1);

        w1.start();
        w2.start();
        w3.start();
        w4.start();
    }

    static class Job {
        synchronized void play(String threadName) throws Exception {
            System.out.println(threadName + ".play1() 호출");
            Thread.sleep(10000);
        }

        synchronized void play2(String threadName) throws Exception {
            System.out.println(threadName + ".play2() 호출");
            Thread.sleep(10000);
        }

        synchronized void play3(String threadName) throws Exception {
            System.out.println(threadName + ".play3() 호출");
            Thread.sleep(10000);
        }

    }


    static class Worker1 extends Thread {
        Job job;

        public Worker1(String name, Job job) {
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

    static class Worker2 extends Thread {
        Job job;

        public Worker2(String name, Job job) {
            super(name);
            this.job = job;
        }

        @Override
        public void run() {
            try {
                job.play2(getName());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    static class Worker3 extends Thread {
        Job job;

        public Worker3(String name, Job job) {
            super(name);
            this.job = job;
        }

        @Override
        public void run() {
            try {
                job.play3(getName());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    static class Worker4 extends Thread {
        Job job;

        public Worker4(String name, Job job) {
            super(name);
            this.job = job;
        }

        @Override
        public void run() {
            try {
                job.play3(getName());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
