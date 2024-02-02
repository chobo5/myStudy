package org.example.menu.handler;

import org.example.dao.Dao;
import org.example.util.Prompt;
import org.example.vo.Book;

public class BookAddHandler implements Handler{
    private Dao<Book> dao;

    private Prompt prompt;
    public BookAddHandler(Dao<Book> dao, Prompt prompt) {
        this.dao = dao;
        this.prompt = prompt;
    }

    @Override
    public void action() {
        try {
            Book book = new Book();
            book.setTitle(prompt.input("도서명: "));
            book.setWriter(prompt.input("저자: "));
            book.setPublisher(prompt.input("출판사: "));
            dao.add(book);

        } catch (Exception e) {
            System.out.println("과제 입력 중 오류 발생!");
            System.out.println("다시 시도하시기 바랍니다.");
        }

    }
}
