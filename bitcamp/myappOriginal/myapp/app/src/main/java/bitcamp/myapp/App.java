
package bitcamp.myapp;


import bitcamp.menu.MenuGroup;
import bitcamp.myapp.dao.BasicDao;
import bitcamp.myapp.dao.json.AssignmentDaoImpl;
import bitcamp.myapp.dao.json.BoardDaoImpl;
import bitcamp.myapp.dao.json.MemberImpl;
import bitcamp.myapp.handler.assignment.*;
import bitcamp.myapp.handler.board.*;
import bitcamp.myapp.handler.member.*;
import bitcamp.util.*;


public class App {
    Prompt prompt = new Prompt(System.in);

    BasicDao assignmentDao = new AssignmentDaoImpl("assignment.json");
    BasicDao dao = new BoardDaoImpl("board.json");
    BasicDao memberDao = new MemberImpl("member.json");
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
        assignmentMenu.addItem("등록", new AssignmentAddHandler(prompt, assignmentDao));
        assignmentMenu.addItem("조회", new AssignmentViewHandler(prompt, assignmentDao));
        assignmentMenu.addItem("수정", new AssignmentModifyHandler(prompt, assignmentDao));
        assignmentMenu.addItem("삭제", new AssignmentDeleteHandler(prompt, assignmentDao));
        assignmentMenu.addItem("목록", new AssignmentListHandler(prompt, assignmentDao));

        MenuGroup boardMenu = mainMenu.addGroup("게시판");
        boardMenu.addItem("등록", new BoardAddHandler(prompt, dao));
        boardMenu.addItem("조회", new BoardViewHandler(prompt, dao));
        boardMenu.addItem("수정", new BoardModifyHandler(prompt, dao));
        boardMenu.addItem("삭제", new BoardDeleteHandler(prompt, dao));
        boardMenu.addItem("목록", new BoardListHandler(prompt, dao));

        MenuGroup helpMenu = mainMenu.addGroup("도움말");

        MenuGroup memberMenu = mainMenu.addGroup("회원 관리");
        memberMenu.addItem("등록", new MemberAddHandler(prompt, memberDao));
        memberMenu.addItem("조회", new MemberViewHandler(prompt, memberDao));
        memberMenu.addItem("수정", new MemberModifyHandler(prompt, memberDao));
        memberMenu.addItem("삭제", new MemberDeleteHandler(prompt, memberDao));
        memberMenu.addItem("목록", new MemberListHandler(prompt, memberDao));
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
    }

}
