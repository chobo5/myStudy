package app.dao.mysql;

import app.dao.Dao;
import app.dao.DaoException;
import app.vo.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao<Book> {

    Connection con;

    public DaoImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void add(Book book) {
        try(Statement stmt = con.createStatement()) {
            stmt.executeUpdate(String.format("insert into books(title, writer, publisher) values('%s', '%s', '%s')",
                    book.getTitle(),
                    book.getWriter(),
                    book.getPublisher()));
        } catch (SQLException e) {
            throw new DaoException("데이터 입력 에러");
        }
    }

    @Override
    public List<Book> find(String input) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        try(Statement stmt = con.createStatement()) {
            ResultSet rs= stmt.executeQuery("select * from books");
            List<Book> list = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("assignment_no"));
                book.setTitle(rs.getString("title"));
                book.setWriter(rs.getString("writer"));
                book.setPublisher(rs.getString("publisher"));
                list.add(book);
            }
            return list;
        } catch (SQLException e) {
            throw new DaoException("데이터 로딩 에러");
        }
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public int delete() {
        return 0;
    }
}
