package bitcamp.myapp;


import java.io.*;

import bitcamp.menu.MenuGroup;
import bitcamp.myapp.handler.assignment.*;
import bitcamp.myapp.handler.board.*;
import bitcamp.myapp.handler.member.*;
import bitcamp.myapp.vo.Assignment;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Method;
import java.util.*;


public class App {
    Prompt prompt = new Prompt(System.in);

    List<Assignment> assignmentRepository;
    List<Board> boardRepository;
    List<Member> memberRepository;
    MenuGroup mainMenu;

    public App() {
        assignmentRepository = loadData("assignment.json", Assignment.class);
        boardRepository = loadData("board.json", Board.class);
        memberRepository = loadData("member.json", Member.class);
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
        saveData("assignment.json", assignmentRepository);
        saveData("member.json", memberRepository);
        saveData("board.json", boardRepository);

    }


    //<E>: 메서드를 호출할 때 타입 E가 무엇인지 결정된다.
    //List<E> 리턴값을 받은 변수의 정보를 보고 결정한다.
    <E> List<E> loadData(String filepath, Class<E> clazz) { // 이 메서드의 리턴타입에 따라 타입을 결정한다.
        ArrayList<E> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(filepath))) {
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = in.readLine()) != null) {
                sb.append(str);
            }

            return (List<E>) new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(sb.toString(),
                    TypeToken.getParameterized(ArrayList.class, clazz));


        }catch (NoSuchElementException e) {
            System.out.printf("%s 파일 로딩 완료!\n", filepath);

        } catch (Exception e) {
            System.out.printf("%s 파일 로딩중 오류 발생\n", filepath);
            System.out.println();
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    void saveData(String filepath, List<?> dataList) { //CsvString을 상속 or 구현한 객체를 받는다.
        try (BufferedWriter out = new BufferedWriter(new FileWriter(filepath))) {
            out.write(new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(dataList));
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
