package org.example;

import org.example.dao.Dao;
import org.example.dao.mysql.DaoImpl;
import org.example.menu.Menu;
import org.example.menu.MenuItem;
import org.example.menu.handler.BookAddHandler;
import org.example.menu.handler.BookModifyHandler;
import org.example.menu.handler.BookSearchHandler;
import org.example.menu.handler.BookListHandler;
import org.example.menu.handler.BookDeleteHandler;
import org.example.util.Prompt;
import org.example.vo.Book;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    Prompt prompt = new Prompt(System.in);

    Dao<Book> dao;

    Menu menu;

    Main() {
        prepareDatabase();
        prepareMenu();
    }

    void prepareDatabase() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://db-ld296-kr.vpc-pub-cdb.ntruss.com/studydb", "study", "Bitcamp!@#123");
            dao = (Dao<Book>) new DaoImpl(con);
        } catch (Exception e) {
            System.out.println("통신 오류!");
            e.printStackTrace();
        }
    }

    void prepareMenu() {

        menu = Menu.getInstance();
        MenuItem addMenuItem = new MenuItem(new BookAddHandler(dao, prompt), "도서 추가");
        MenuItem updateMenuItem = new MenuItem(new BookModifyHandler(dao, prompt), "도서 수정");
        MenuItem searchMenuItem = new MenuItem(new BookSearchHandler(dao, prompt), "도서 검색");
        MenuItem listMenuItem = new MenuItem(new BookListHandler(dao), "도서 목록");
        MenuItem deleteMenuItem = new MenuItem(new BookDeleteHandler(dao, prompt), "도서 삭제");

        menu.addMenuItem(addMenuItem, updateMenuItem, searchMenuItem, listMenuItem, deleteMenuItem);
    }

    void run() {
        System.out.println("[도서 관리 시스템]");
        try {
            menu.execute(prompt);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}