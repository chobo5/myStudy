package app.menu.handler;

import app.dao.Dao;
import app.menu.MenuItem;
import app.vo.Book;
import util.Prompt;

public class BookModifyHandler implements Handler{
    private Dao<Book> dao;
    private Prompt prompt;
    public BookModifyHandler(Dao<Book> dao, Prompt prompt) {
        this.dao = dao;
        this.prompt = prompt;
    }
    @Override
    public void action() {

    }
}
