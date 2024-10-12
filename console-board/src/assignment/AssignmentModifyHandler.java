package assignment;

import menu.MenuHandler;

import java.io.BufferedReader;

public class AssignmentModifyHandler implements MenuHandler {

    private BufferedReader in;
    private AssignmentRepository assignmentRepository;

    public AssignmentModifyHandler(BufferedReader in, AssignmentRepository assignmentRepository) {
        this.in = in;
        this.assignmentRepository = assignmentRepository;
    }


    @Override
    public void action() {
        try {
            System.out.println("수정할 과제 번호를 입력하세요");
            int assignmentNo = Integer.parseInt(in.readLine());

            Assignment assignment = assignmentRepository.findByNo(assignmentNo);

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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
