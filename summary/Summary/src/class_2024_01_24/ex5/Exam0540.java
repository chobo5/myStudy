package class_2024_01_24.ex5;

//synchronized 인스턴스 메서드 적용 후
public class Exam0540 {
    public static void main(String[] args) {
        Job job1 = new Job();
        Job job2 = new Job();

        Worker2 w1 = new Worker2("홍길동", job1);
        Worker2 w2 = new Worker2("임꺽정", job1);
        Worker2 w3 = new Worker2("유관순", job1);
        Worker2 w4 = new Worker2("김구", job2);
        Worker2 w5 = new Worker2("안중근", job2);
        Worker2 w6 = new Worker2("윤봉길", job2);


        w1.start();
        w2.start();
        w3.start();
        w4.start();
        w5.start();
        w6.start();
    }

    static class Job {
        //같은 변수(= 인스턴스)에 대해 여러 스레드가 동시에 진입하는 것을 막는다.
        // 만약 다른 변수(= 인스턴스)라면? 막지 않는다.
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
