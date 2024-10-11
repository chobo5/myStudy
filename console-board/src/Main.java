import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("콘솔 게시판 프로그램 시작");
        List<Board> boardList = new ArrayList<>();
        List<Member> memberList = new ArrayList<>();
        Member loginMember = null;
        while(true) {
            System.out.println("1. 회원 메뉴");
            System.out.println("2. 게시글 메뉴");

            String menuNo = in.readLine();

            if (menuNo.equals("1")) {
                System.out.println("1. 로그인");
                System.out.println("2. 회원가입");
                System.out.println("3. 회원정보 수정");
                System.out.println("4. 회원 탈퇴");
                System.out.println("5. 로그아웃");
                System.out.println("6. 회원 목록");
                String memberMenuNo = in.readLine();
                switch (memberMenuNo) {
                    case "1":
                        System.out.println("이메일: ");
                        String emailForLogin = in.readLine();
                        System.out.println("비밀번호: ");
                        String pwForLogin = in.readLine();
                        boolean isLogin = false;
                        for (Member member : memberList) {
                            if (member.getEmail().equals(emailForLogin) && member.getPassword().equals(pwForLogin)) {
                                loginMember = member;
                                isLogin = true;
                                System.out.println("로그인 되었습니다.");
                                break;
                            }
                        }
                        if (isLogin == false) {
                            System.out.println("아이디 또는 비밀번호가 잘못 되었습니다.");
                        }
                        break;

                    case "2":
                        System.out.println("이름: ");
                        String name = in.readLine();
                        System.out.println("이메일: ");
                        String email = in.readLine();
                        System.out.println("비밀번호: ");
                        String password = in.readLine();
                        Member newMember = new Member(name, email, password);
                        memberList.add(newMember);
                        break;

                    case "3":
                        if (loginMember == null) {
                            System.out.println("로그인이 필요합니다.");
                            break;
                        }
                        System.out.println("이름: ");
                        String modifyName = in.readLine();
                        System.out.println("이메일: ");
                        String modifyEmail = in.readLine();
                        System.out.println("비밀번호: ");
                        String modifyPw = in.readLine();
                        loginMember.setName(modifyName);
                        loginMember.setEmail(modifyEmail);
                        loginMember.setPassword(modifyPw);
                        System.out.println("회원정보 수정이 완료되었습니다.");
                        break;

                    case "4":
                        if (loginMember != null) {
                            memberList.remove(loginMember);
                            loginMember = null;
                            System.out.println("회원 탈퇴가 완료되었습니다.");
                        } else {
                            System.out.println("로그인이 필요합니다.");
                        }
                        break;

                    case "5":
                        if (loginMember != null) {
                            loginMember = null;
                            System.out.println("로그아웃이 완료되었습니다.");
                        } else {
                            System.out.println("로그인이 필요합니다.");
                        }
                        break;

                    case "6":
                        memberList.forEach(System.out::println);
                        break;
                }

            } else if (menuNo.equals("2")) {
                System.out.println("1. 게시글 작성");
                System.out.println("2. 게시글 수정");
                System.out.println("3. 게시글 삭제");
                System.out.println("4. 게시글 목록");
                String boardMenuNo = in.readLine();
                switch (boardMenuNo) {
                    case "1":
                        if (loginMember == null) {
                            System.out.println("로그인이 필요합니다.");
                            break;
                        }
                        System.out.println("제목:");
                        String title = in.readLine();
                        System.out.println("내용:");
                        String content = in.readLine();
                        Board newBoard = new Board(loginMember, title, content);
                        boardList.add(newBoard);
                        System.out.println("게시물 작성이 완료되었습니다.");
                        break;

                    case "2":
                        if (loginMember == null) {
                            System.out.println("로그인이 필요합니다.");
                            break;
                        }

                        System.out.println("수정할 게시물 번호를 입력하세요");
                        int modiNo = Integer.parseInt(in.readLine());
                        Board boardtoModify = boardList.get(modiNo - 1);
                        if (!boardtoModify.getWriter().equals(loginMember)) {
                            System.out.println("게시물 수정 권한이 없습니다.");
                            break;
                        }
                        System.out.println("제목:");
                        String modiTitle = in.readLine();
                        System.out.println("내용:");
                        String modiContent = in.readLine();

                        boardtoModify.setTitle(modiTitle);
                        boardtoModify.setContent(modiContent);
                        System.out.println("게시물 수정이 완료되었습니다.");
                        break;
                    case "3":
                        if (loginMember == null) {
                            System.out.println("로그인이 필요합니다.");
                            break;
                        }

                        System.out.println("삭제할 게시물 번호를 입력하세요");
                        int deleteNo = Integer.parseInt(in.readLine());
                        Board boardToDelete = boardList.get(deleteNo - 1);
                        if (!boardToDelete.getWriter().equals(loginMember)) {
                            System.out.println("게시물 수정 권한이 없습니다.");
                            break;
                        }
                        boardList.remove(deleteNo - 1);
                        System.out.println("게시물 삭제가 완료되었습니다.");
                        break;
                    case "4":
                        for (int i = 0; i < boardList.size(); i++) {
                            System.out.print(i + 1 + ". ");
                            System.out.println(boardList.get(i));
                        }
                        break;
                }
            }





        }

    }
}