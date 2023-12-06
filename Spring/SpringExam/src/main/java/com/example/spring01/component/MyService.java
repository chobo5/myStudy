package com.example.spring01.component;

public class MyService extends MyDao {
    private MyDao myDao; //필

    public void setMyDao(MyDao myDao) { //myDao 프로퍼티
        this.myDao = myDao;
    }
    public void service() {
        System.out.println("MyService의 인스턴스.service()");
        myDao.get();
    }


}
