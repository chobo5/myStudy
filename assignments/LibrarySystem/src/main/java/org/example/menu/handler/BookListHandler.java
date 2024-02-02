package org.example.menu.handler;

import org.example.dao.Dao;
import org.example.util.Prompt;
import org.example.vo.Book;

import java.util.List;

public class BookListHandler implements Handler{
    private Dao<Book> dao;
    private Prompt prompt;
    public BookListHandler(Dao<Book> dao) {
        this.dao = dao;
    }
    @Override
    public void action() {
        List<Book> result = dao.findAll();
        System.out.println();
        System.out.println("---------------------------------");
        System.out.printf("%-4s\t%-20s\t%-10s\t%s\n","번호", "제목", "저자", "출판사");
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("%-4s\t%-20s\t%-10s\t%s\n",
                    (i + 1) + ".",
                    result.get(i).getTitle(),
                    result.get(i).getWriter(),
                    result.get(i).getPublisher()
            );
        }
        System.out.println("---------------------------------");
    }
}
