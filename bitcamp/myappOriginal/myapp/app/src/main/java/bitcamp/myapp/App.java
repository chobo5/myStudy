package bitcamp.myapp;


import java.io.*;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuGroup;
import bitcamp.menu.MenuItem;
import bitcamp.myapp.handler.assignment.*;
import bitcamp.myapp.handler.board.*;
import bitcamp.myapp.handler.member.*;
import bitcamp.myapp.vo.Assignment;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class App {
    Prompt prompt = new Prompt(System.in);

    List<Assignment> assignmentRepository = loadData("assignment.data");
    List<Board> boardRepository = loadData("board.data");
    List<Member> memberRepository = loadData("member.data");
    MenuGroup mainMenu;

    public App() {
        prepareMenu();
    }


    public static void main(String[] args) {
        new App().run();
    }

    void prepareMenu() {
        mainMenu = MenuGroup.getInstance("메인");

        MenuGroup assignmentMenu = mainMenu.addGroup("과제");
        assignmentMenu.addItem("등록", new AssignmentAddHandler(prompt, assignmentRepository));
        assignmentMenu.addItem("조회", new AssignmentViewHandler(prompt, assignmentRepository));
        assignmentMenu.addItem("수정", new AssignmentModifyHandler(prompt, assignmentRepository));
        assignmentMenu.addItem("삭제", new AssignmentDeleteHandler(prompt, assignmentRepository));
        assignmentMenu.addItem("목록", new AssignmentListHandler(prompt, assignmentRepository));

        MenuGroup boardMenu = mainMenu.addGroup("게시판");
        boardMenu.addItem("등록", new BoardAddHandler(prompt, boardRepository));
        boardMenu.addItem("조회", new BoardViewHandler(prompt, boardRepository));
        boardMenu.addItem("수정", new BoardModifyHandler(prompt, boardRepository));
        boardMenu.addItem("삭제", new BoardDeleteHandler(prompt, boardRepository));
        boardMenu.addItem("목록", new BoardListHandler(prompt, boardRepository));

        MenuGroup helpMenu = mainMenu.addGroup("도움말");

        MenuGroup memberMenu = mainMenu.addGroup("회원 관리");
        memberMenu.addItem("등록", new MemberAddHandler(prompt, memberRepository));
        memberMenu.addItem("조회", new MemberViewHandler(prompt, memberRepository));
        memberMenu.addItem("수정", new MemberModifyHandler(prompt, memberRepository));
        memberMenu.addItem("삭제", new MemberDeleteHandler(prompt, memberRepository));
        memberMenu.addItem("목록", new MemberListHandler(prompt, memberRepository));
    }

    public void run() {
        while (true) {
            try {
                mainMenu.execute(prompt);
                prompt.close();
                break;
            } catch (Exception e) {
                System.out.println("오류가 발생했습니다. 프로그램을 재시작합니다.");
            }
        }
        saveData("assignment.data", assignmentRepository);
        saveData("member.data", memberRepository);
        saveData("board.data", boardRepository);

    }


    <E> List<E> loadData(String filepath) { // 이 메서드의 리턴타입에 따라 타입을 결정한다.
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filepath)))) {
            return (List<E>) in.readObject();
        } catch (Exception e) {
            System.out.printf("%s 파일 로딩중 오류 발생\n", filepath);
            System.out.println();
            e.printStackTrace();
        }
        return new ArrayList<E>();
    }

    void saveData(String filepath, List<?> dataList) {
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filepath)))) {
            out.writeObject(dataList);
        } catch (Exception e) {
            System.out.printf("%s 파일 저장중 오류 발생\n", filepath);
            System.out.println();
            e.printStackTrace();
        }
    }


}
