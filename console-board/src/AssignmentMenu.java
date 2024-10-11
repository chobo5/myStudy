import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AssignmentMenu implements Menu {
    private BufferedReader in;

    List<Assignment> assignmentList = new ArrayList<>();

    public AssignmentMenu(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void execute() throws IOException {
        printMenu();
        String menuNo = in.readLine();
        switch (menuNo) {
            case "1":
                create();
                break;
            case "2":
                view();
            case "3":
                modify();
                break;
            case "4":
                delete();
                break;
            case "5":
                list();
                break;
        }
    }

    @Override
    public String getName() {
        return "과제 메뉴";
    }

    public void printMenu() {
        System.out.println("1. 과제 생성");
        System.out.println("2. 과제 상세");
        System.out.println("3. 과제 수정");
        System.out.println("4. 과제 삭제");
        System.out.println("5. 과제 목록");
    }

    public void create() throws IOException {
        System.out.println("제목:");
        String title = in.readLine();
        System.out.println("내용:");
        String content = in.readLine();
        System.out.println("마감기한:");
        String deadline = in.readLine();
        Assignment newAssignment = new Assignment(title, content, deadline);
        assignmentList.add(newAssignment);
        System.out.println("과제 생성이 완료되었습니다.");
    }

    public void view() throws IOException {
        System.out.println("열람할 과제 번호를 입력하세요");
        int assignmentNo = Integer.parseInt(in.readLine());
        Assignment assignment = assignmentList.get(assignmentNo - 1);
        System.out.println(assignment);
    }

    public void modify() throws IOException {
        System.out.println("수정할 과제 번호를 입력하세요");
        int assignmentNo = Integer.parseInt(in.readLine());

        Assignment assignment = assignmentList.get(assignmentNo - 1);

        System.out.println("제목:");
        String title = in.readLine();
        System.out.println("내용:");
        String content = in.readLine();
        System.out.println("마감기한:");
        String deadline = in.readLine();

        assignment.setTitle(title);
        assignment.setContent(content);
        assignment.setDeadline(deadline);
        System.out.println("과제 수정이 완료되었습니다.");
    }

    public void delete() throws IOException {
        System.out.println("삭제할 과제 번호를 입력하세요");
        int assignmentNo = Integer.parseInt(in.readLine());

        assignmentList.remove(assignmentNo - 1);
        System.out.println("과제 삭제가 완료되었습니다.");
    }

    public void list() {
        for (int i = 0; i < assignmentList.size(); i++) {
            System.out.print(i + 1 + ". ");
            System.out.println(assignmentList.get(i));
        }
    }
}
