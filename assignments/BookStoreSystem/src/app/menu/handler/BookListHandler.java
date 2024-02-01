package app.menu.handler;

import app.dao.Dao;
import app.menu.MenuItem;
import app.vo.Book;
import util.Prompt;

public class BookListHandler implements Handler{
    private Dao<Book> dao;
    private Prompt prompt;
    public BookListHandler(Dao<Book> dao) {
        this.dao = dao;
    }
    @Override
    public void action() {

    }
}
