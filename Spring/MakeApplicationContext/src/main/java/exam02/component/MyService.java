package exam02.component;

public class MyService {
    MyDao myDao;

    public void setMyDao(MyDao myDao) {
        this.myDao = myDao;
    }

    public void service() {
        System.out.println("MyService.service()");
        myDao.get();
    }
}
