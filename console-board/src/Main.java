import assignment.*;
import board.*;
import member.*;
import menu.MenuGroup;
import menu.MenuItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("콘솔 게시판 프로그램 시작");

        MenuGroup mainMenu = new MenuGroup("메인 메뉴");

        MenuGroup boardMenu = new MenuGroup("게시판 메뉴");
        BoardRepository boardRepository = new BoardRepository();
        boardMenu.add(new MenuItem("게시글 생성", new BoardCreateCommand(in, boardRepository)));
        boardMenu.add(new MenuItem("게시글 상세", new BoardViewCommand(in, boardRepository)));
        boardMenu.add(new MenuItem("게시글 수정", new BoardModifyCommand(in, boardRepository)));
        boardMenu.add(new MenuItem("게시글 삭제", new BoardDeleteCommand(in, boardRepository)));
        boardMenu.add(new MenuItem("게시글 목록", new BoardListCommand(in, boardRepository)));
        mainMenu.add(boardMenu);

        MenuGroup assignmentMenu = new MenuGroup("과제 메뉴");
        AssignmentRepository assignmentRepository = new AssignmentRepository();
        assignmentMenu.add(new MenuItem("과제 생성", new AssignmentCreateCommand(in, assignmentRepository)));
        assignmentMenu.add(new MenuItem("과제 상세", new AssignmentViewCommand(in, assignmentRepository)));
        assignmentMenu.add(new MenuItem("과제 수정", new AssignmentModifyCommand(in, assignmentRepository)));
        assignmentMenu.add(new MenuItem("과제 삭제", new AssignmentDeleteCommand(in, assignmentRepository)));
        assignmentMenu.add(new MenuItem("과제 목록", new AssignmentListCommand(in, assignmentRepository)));
        mainMenu.add(assignmentMenu);

        MenuGroup memberMenu = new MenuGroup("회원 메뉴");
        MemberRepository memberRepository = new MemberRepository();
        memberMenu.add(new MenuItem("회원 가입", new MemberCreateCommand(in, memberRepository)));
        memberMenu.add(new MenuItem("회원 상세", new MemberViewCommand(in, memberRepository)));
        memberMenu.add(new MenuItem("회원 수정", new MemberModifyCommand(in, memberRepository)));
        memberMenu.add(new MenuItem("회원 탈퇴", new MemberResignCommand(in, memberRepository)));
        memberMenu.add(new MenuItem("회원 목록", new MemberListCommand(in, memberRepository)));
        mainMenu.add(memberMenu);

        mainMenu.execute(in);

    }
}