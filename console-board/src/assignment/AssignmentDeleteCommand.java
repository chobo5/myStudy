package assignment;

import menu.MenuCommand;

import java.io.BufferedReader;

public class AssignmentDeleteCommand implements MenuCommand {

    private BufferedReader in;
    private AssignmentRepository assignmentRepository;

    public AssignmentDeleteCommand(BufferedReader in, AssignmentRepository assignmentRepository) {
        this.in = in;
        this.assignmentRepository = assignmentRepository;
    }


    @Override
    public void action() {
        try {
            System.out.println("삭제할 과제 번호를 입력하세요");
            int assignmentNo = Integer.parseInt(in.readLine());

            assignmentRepository.delete(assignmentNo);
            System.out.println("과제 삭제가 완료되었습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
