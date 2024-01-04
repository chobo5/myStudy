package bitcamp.myapp;

import bitcamp.io.BufferedDataInputStream;
import bitcamp.io.BufferedDataOutputStream;
import bitcamp.io.DataInputStream;
import bitcamp.io.DataOutputStream;
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

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class App {
    Prompt prompt = new Prompt(System.in);

    List<Assignment> assignmentRepository = new LinkedList<>();
    List<Board> boardRepository = new LinkedList<>();
    List<Member> memberRepository = new ArrayList<>();
    List<Board> greetingRepository = new ArrayList<>();
    MenuGroup mainMenu;
    public App() {
        prepareMenu();
        loadAssignment();
        loadMember();
        loadBoard();
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
        saveAssignment();
        saveMember();
        saveBoard();
    }

    void loadAssignment() {
        try (BufferedDataInputStream in = new BufferedDataInputStream("assignment.data")) {
            int size = in.readInt();
            long start = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                String title = in.readUTF();
                String content = in.readUTF();
                Date deadline = Date.valueOf(in.readUTF());

                Assignment assignment = new Assignment();
                assignment.setTitle(title);
                assignment.setContent(content);
                assignment.setDeadline(deadline);

                assignmentRepository.add(assignment);
            }
            long end = System.currentTimeMillis();
            System.out.printf("걸린시간: %d\n", end - start);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("과제데이터 로딩 오류");
        }

    }

    void saveAssignment() {
        try (BufferedDataOutputStream out = new BufferedDataOutputStream("assignment.data")) {
            long start = System.currentTimeMillis();
            // 저장할 데이터 개수를 2바이트로 출력한다.
            out.writeInt(assignmentRepository.size());

            for (int i = 0; i < 10000; i++) {
                for (Assignment assignment : assignmentRepository) {
                    // assignment 객체에서 값을 꺼내 바이트 배열로 만든 다음에 출력한다.
                    out.writeUTF(assignment.getTitle());
                    out.writeUTF(assignment.getContent());
                    out.writeUTF(assignment.getDeadline().toString());
                }
            }
            long end = System.currentTimeMillis();
            System.out.printf("걸린시간: %d\n", end - start);

        }catch (Exception e) {
            System.out.println("과제데이터 저장 오류");
        }
    }

    void loadMember() {
        try (BufferedDataInputStream in = new BufferedDataInputStream("member.data")) {
            byte[] bytes = new byte[60000];
            int size = in.read() << 8 | in.read();
            for (int i = 0; i < size; i++) {
                Member member = new Member();
                member.setName(in.readUTF());
                member.setEmail(in.readUTF());
                member.setPassword(in.readUTF());
                member.setCreatedDate(new java.util.Date(in.readLong()));
                memberRepository.add(member);
            }
        } catch (Exception e) {
            System.out.println("맴버데이터 로딩 오류");
        }
    }

    void saveMember() {
        try (BufferedDataOutputStream out = new BufferedDataOutputStream("member.data")) {
            out.write(memberRepository.size() >> 8);
            out.write(memberRepository.size());
            for (Member member : memberRepository) {
                out.writeUTF(member.getName());
                out.writeUTF(member.getEmail());
                out.writeUTF(member.getPassword());
                out.writeLong(member.getCreatedDate().getTime());
            }
        } catch (Exception e) {
            System.out.println("맴버데이터 저장 오류");
        }
    }

    void loadBoard() {
        try (BufferedDataInputStream in = new BufferedDataInputStream("board.data")) {
            byte[] bytes = new byte[60000];
            int size = in.read() >> 8 | in.read();
            for (int i = 0; i < size; i++) {
                Board board = new Board();
                board.setTitle(in.readUTF());
                board.setContent(in.readUTF());
                board.setWriter(in.readUTF());
                board.setCreatedDate(new java.util.Date(in.readLong()));
                boardRepository.add(board);
            }
        }catch (Exception e) {
            System.out.println("게시물 로딩 오류");
        }
    }

    void saveBoard() {
        try (BufferedDataOutputStream out = new BufferedDataOutputStream("board.data")) {
            out.write(boardRepository.size() >> 8);
            out.write(boardRepository.size());

            for (Board board : boardRepository) {
                out.writeUTF(board.getTitle());
                out.writeUTF(board.getContent());
                out.writeUTF(board.getWriter());
                out.writeLong(board.getCreatedDate().getTime());
            }
        } catch (Exception e) {
            System.out.println("게시물 저장 오류");
        }
    }
}
