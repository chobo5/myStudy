package org.example.menu.handler;

import org.example.dao.Dao;
import org.example.util.Prompt;
import org.example.vo.Book;

import java.util.List;


public class BookDeleteHandler implements Handler{
    private Dao<Book> dao;
    private Prompt prompt;
    public BookDeleteHandler(Dao<Book> dao, Prompt prompt) {
        this.dao = dao;
        this.prompt = prompt;
    }
    @Override
    public void action() {

        try {
            List<Book> result = dao.find(prompt.input("삭제할 도서명 또는 저자 또는 출판사를 입력해주세요\n"));
            if (result.size() == 0) {
                System.out.println("검색된 도서가 없습니다.");
            } else {
                System.out.println("---------------------------------");
                System.out.printf("%-4s\t%-20s\t%-20s\t%s\n","번호", "제목", "저자", "출판사");
                for (int i = 0; i < result.size(); i++) {
                    System.out.printf("%-4s\t%-20s\t%-20s\t%s\n",
                            (i + 1) + ".",
                            result.get(i).getTitle(),
                            result.get(i).getWriter(),
                            result.get(i).getPublisher()
                            );
                }
                System.out.println("---------------------------------");
                int input = prompt.inputInt("삭제할 도서 번호를 입력해주세요.\n") - 1;

                dao.delete(result.get(input).getId());



            }


        } catch (Exception e) {
            System.out.println("과제 입력 중 오류 발생!");
            System.out.println("다시 시도하시기 바랍니다.");
        }
//        dao.find()
//        dao.delete()

    }
}
