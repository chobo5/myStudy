import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemberMenu implements Menu{

    private BufferedReader in;

    private List<Member> memberList = new ArrayList<>();

    public MemberMenu(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void execute() throws IOException {
        printMenu();
        String memberMenuNo = in.readLine();
        switch (memberMenuNo) {
            case "1":
                join();
                break;
            case "2":
                view();
                break;
            case "3":
                modify();
                break;
            case "4":
                resign();
                break;
            case "5":
                list();
                break;
        }
    }

    @Override
    public String getName() {
        return "회원 메뉴";
    }

    public void printMenu() {
        System.out.println("1. 회원가입");
        System.out.println("1. 회원상세");
        System.out.println("3. 회원정보 수정");
        System.out.println("4. 회원 탈퇴");
        System.out.println("5. 회원 목록");
    }


    public void join() throws IOException {
        System.out.println("이름: ");
        String name = in.readLine();
        System.out.println("이메일: ");
        String email = in.readLine();
        System.out.println("비밀번호: ");
        String password = in.readLine();
        Member member = new Member(name, email, password);
        memberList.add(member);
        System.out.println("회원가입이 완료되었습니다.");
    }

    public void view() throws IOException {
        System.out.println("열람할 회원 번호를 입력하세요");
        int memberNo = Integer.parseInt(in.readLine());
        Member member = memberList.get(memberNo - 1);
        System.out.println(member.allToString());
    }

    public void modify() throws IOException {
        System.out.println("수정할 회원 번호를 입력하세요");
        int memberNo = Integer.parseInt(in.readLine());
        Member member = memberList.get(memberNo - 1);

        System.out.println("이름: ");
        String name = in.readLine();
        member.setName(name);

        System.out.println("이메일: ");
        String email = in.readLine();
        member.setEmail(email);

        System.out.println("비밀번호: ");
        String password = in.readLine();
        member.setPassword(password);

        System.out.println("회원정보 수정이 완료되었습니다.");

    }

    public void resign() throws IOException {
        System.out.println("탈퇴할 회원의 번호를 입력하세요");
        int memberNo = Integer.parseInt(in.readLine());
        memberList.remove(memberNo - 1);

        System.out.println("회원 탈퇴가 완료되었습니다.");
    }

    public void list() {
        memberList.forEach(System.out::println);
    }
}
