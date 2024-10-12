package v2;

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
        boardMenu.add(new MenuItem("게시글 생성", new BoardCreateHandler(in, boardRepository)));
        boardMenu.add(new MenuItem("게시글 상세", new BoardViewHandler(in, boardRepository)));
        boardMenu.add(new MenuItem("게시글 수정", new BoardModifyHandler(in, boardRepository)));
        boardMenu.add(new MenuItem("게시글 삭제", new BoardDeleteHandler(in, boardRepository)));
        boardMenu.add(new MenuItem("게시글 목록", new BoardListHandler(in, boardRepository)));
        mainMenu.add(boardMenu);


        MenuGroup assignmentMenu = new MenuGroup("과제 메뉴");
        AssignmentRepository assignmentRepository = new AssignmentRepository();
        assignmentMenu.add(new MenuItem("과제 생성", new AssignmentCreateHandler(in, assignmentRepository)));
        assignmentMenu.add(new MenuItem("과제 상세", new AssignmentViewHandler(in, assignmentRepository)));
        assignmentMenu.add(new MenuItem("과제 수정", new AssignmentModifyHandler(in, assignmentRepository)));
        assignmentMenu.add(new MenuItem("과제 삭제", new AssignmentDeleteHandler(in, assignmentRepository)));
        assignmentMenu.add(new MenuItem("과제 목록", new AssignmentListHandler(in, assignmentRepository)));
        mainMenu.add(assignmentMenu);


        MenuGroup memberMenu = new MenuGroup("회원 메뉴");
        MemberRepository memberRepository = new MemberRepository();
        memberMenu.add(new MenuItem("회원 가입", new MemberCreateHandler(in, memberRepository)));
        memberMenu.add(new MenuItem("회원 상세", new MemberViewHandler(in, memberRepository)));
        memberMenu.add(new MenuItem("회원 수정", new MemberModifyHandler(in, memberRepository)));
        memberMenu.add(new MenuItem("회원 탈퇴", new MemberResignHandler(in, memberRepository)));
        memberMenu.add(new MenuItem("회원 목록", new MemberListHandler(in, memberRepository)));
        mainMenu.add(memberMenu);


        mainMenu.execute(in);


    }
}