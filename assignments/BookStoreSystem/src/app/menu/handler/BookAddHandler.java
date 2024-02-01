package app.menu.handler;

import app.dao.Dao;
import app.menu.MenuItem;
import app.vo.Book;
import util.Prompt;

public class BookAddHandler implements Handler{
    private Dao<Book> dao;

    private Prompt prompt;
    public BookAddHandler(Dao<Book> dao, Prompt prompt) {
        this.dao = dao;
        this.prompt = prompt;
    }

    @Override
    public void action() {
        Book book = new Book();
        book.setTitle(prompt.input("도서명: "));
        book.setWriter(prompt.input("저자: "));
        book.setPublisher(prompt.input("출판사명:"));
        dao.add(book);
    }
}
