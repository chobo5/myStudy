package org.example.dao.mysql;


import org.example.dao.Dao;
import org.example.dao.DaoException;
import org.example.vo.Book;

import java.sql.*;
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
        try(PreparedStatement stmt = con.prepareStatement("select * from books where title like ? or writer like ? or publisher like ?")) {
            stmt.setString(1, "%" + input + "%");
            stmt.setString(2, "%" + input + "%");
            stmt.setString(3, "%" + input + "%");
            ResultSet rs= stmt.executeQuery();

            List<Book> list = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
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
    public List<Book> findAll() {
        try(Statement stmt = con.createStatement()) {
            ResultSet rs= stmt.executeQuery("select * from books");
            List<Book> list = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
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
    public int update(Book book) {
        try(Statement stmt = con.createStatement()) {
            return stmt.executeUpdate(String.format("update books set title = '%s', writer = '%s', publisher = '%s' where id = %d" ,
                    book.getTitle(),
                    book.getWriter(),
                    book.getPublisher(),
                    book.getId()));

        } catch (SQLException e) {
            throw new DaoException("데이터 입력 에러");
        }
    }

    @Override
    public int delete(int id) {
        try(Statement stmt = con.createStatement()) {
            stmt.executeUpdate(String.format("delete from books where id = " + id));

            return id;
        } catch (SQLException e) {
            throw new DaoException("데이터 입력 에러");
        }
    }
}
