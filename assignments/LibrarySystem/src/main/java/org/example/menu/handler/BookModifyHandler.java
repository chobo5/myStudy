package org.example.menu.handler;

import org.example.dao.Dao;
import org.example.util.Prompt;
import org.example.vo.Book;

import java.util.List;

public class BookModifyHandler implements Handler{
    private Dao<Book> dao;
    private Prompt prompt;
    public BookModifyHandler(Dao<Book> dao, Prompt prompt) {
        this.dao = dao;
        this.prompt = prompt;
    }
    @Override
    public void action() {
        List<Book> result = dao.find(prompt.input("수정할 도서명 또는 저자 또는 출판사를 입력해주세요"));
        if (result.size() == 0) {
            System.out.println("검색된 도서가 없습니다.");
        } else {
            System.out.printf("%-4s\t%-20s\t%-20s\t%s\n","번호", "제목", "저자", "출판사");
            for (int i = 0; i < result.size(); i++) {
                System.out.printf("%-4s\t%-20s\t%-20s\t%s\n",
                        (i + 1) + ".",
                        result.get(i).getTitle(),
                        result.get(i).getWriter(),
                        result.get(i).getPublisher()
                );
            }
            int input = prompt.inputInt("수정할 도서 번호를 입력해주세요.") - 1;
            Book old = result.get(input);
            old.setTitle(prompt.input("제목(%s)? ", old.getTitle()));
            old.setWriter(prompt.input("제목(%s)? ", old.getWriter()));
            old.setPublisher(prompt.input("제목(%s)? ", old.getPublisher()));
            dao.update(result.get(input));
        }
    }
}
