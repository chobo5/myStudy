package bitcamp.util;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool implements Pooling<WorkerThread>{
    private List<WorkerThread> list = new ArrayList<>();

    public ThreadPool() { }

    //처음에 스레드를 미리 일정 개수 만들어두기
    public ThreadPool(int initSize) {
        if (initSize <= 0 || initSize > 100) {
            return;
        }
        list.add(create());
    }

    @Override
    public WorkerThread get() {
        if (list.size() > 0) {
            return list.remove(0);
        }
        WorkerThread thread = new WorkerThread(this);
        thread.start();
        return thread;
    }

    @Override
    public void revert(WorkerThread thread) {
        list.add(thread);
    }

    private WorkerThread create() {
        WorkerThread thread = new WorkerThread(this);
        thread.start();
        try {
            thread.sleep(500); //스레드가 wait할 시간을 확보한다.
        }catch (Exception e) {
        }
        System.out.printf("새 스레드 생성!(%s)\n", thread.getName());

        return thread;
    }
}
