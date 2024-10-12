package v2.assignment;

import v2.menu.MenuCommand;

import java.io.BufferedReader;

public class AssignmentCreateCommand implements MenuCommand {

    private BufferedReader in;
    private AssignmentRepository assignmentRepository;


    public AssignmentCreateCommand(BufferedReader in, AssignmentRepository assignmentRepository) {
        this.in = in;
        this.assignmentRepository = assignmentRepository;
    }


    @Override
    public void action() {
        try {
            System.out.println("제목:");
            String title = in.readLine();
            System.out.println("내용:");
            String content = in.readLine();
            System.out.println("마감기한:");
            String deadline = in.readLine();
            Assignment newAssignment = new Assignment(title, content, deadline);
            assignmentRepository.save(newAssignment);
            System.out.println("과제 생성이 완료되었습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
