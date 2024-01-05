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
import bitcamp.myapp.vo.CsvString;
import bitcamp.myapp.vo.Member;
import bitcamp.util.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.*;


public class App {
    Prompt prompt = new Prompt(System.in);

    List<Assignment> assignmentRepository;
    List<Board> boardRepository;
    List<Member> memberRepository;
    MenuGroup mainMenu;

    public App() {
        assignmentRepository = loadData("assignment.csv", Assignment.class);
        boardRepository = loadData("board.csv", Board.class);
        memberRepository = loadData("member.csv", Member.class);
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
        saveData("assignment.csv", assignmentRepository);
        saveData("member.csv", memberRepository);
        saveData("board.csv", boardRepository);

    }


    //<E>: 메서드를 호출할 때 타입 E가 무엇인지 결정된다.
    //List<E> 리턴값을 받은 변수의 정보를 보고 결정한다.
    <E> List<E> loadData(String filepath, Class<E> clazz) { // 이 메서드의 리턴타입에 따라 타입을 결정한다.
        ArrayList<E> list = new ArrayList<>();
        try (Scanner in = new Scanner(new FileReader(filepath))) {
            //1. 클래스 정보를 가지고 객체를 리턴하는 팩토리 메서드를 알아낸다.
            Method factoryMethod = clazz.getMethod("createFromCsv", String.class);
            //2. 생성자를 가지고 인스턴스를 생성한다.

            while (true) {
                E obj = (E) factoryMethod.invoke(null, in.nextLine());
                list.add(obj);
            }

        }catch (NoSuchElementException e) {
            System.out.printf("%s 파일 로딩 완료!\n", filepath);

        } catch (Exception e) {
            System.out.printf("%s 파일 로딩중 오류 발생\n", filepath);
            System.out.println();
            e.printStackTrace();
        }
        return list;
    }

    void saveData(String filepath, List<? extends CsvString> dataList) { //CsvString을 상속 or 구현한 객체를 받는다.
        try (FileWriter out = new FileWriter(filepath)) {
            for (CsvString csvObject : dataList) {
                
                out.write(csvObject.toCsvString() + "\n");
            }
        } catch (Exception e) {
            System.out.printf("%s 파일 저장중 오류 발생\n", filepath);
            System.out.println();
            e.printStackTrace();
        }
    }

    //List<?>: 어떤 타입을 받아도 괜찮다.
//    void saveData(String filepath, List<?> dataList) {
//        try (ObjectOutputStream out = new ObjectOutputStream(
//                new BufferedOutputStream(new FileOutputStream(filepath)))) {
//
//            out.writeObject(dataList);
//
//        } catch (Exception e) {
//            System.out.printf("%s 파일 저장 중 오류 발생!\n", filepath);
//            e.printStackTrace();
//        }
//    }

}
