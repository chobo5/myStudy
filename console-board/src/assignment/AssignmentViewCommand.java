package assignment;

import menu.MenuCommand;

import java.io.BufferedReader;

public class AssignmentViewCommand implements MenuCommand {

    private BufferedReader in;
    private AssignmentRepository assignmentRepository;

    public AssignmentViewCommand(BufferedReader in, AssignmentRepository assignmentRepository) {
        this.in = in;
        this.assignmentRepository = assignmentRepository;
    }


    @Override
    public void action() {
        try {
            System.out.println("열람할 과제 번호를 입력하세요");
            int assignmentNo = Integer.parseInt(in.readLine());
            Assignment assignment = assignmentRepository.findByNo(assignmentNo);
            System.out.println(assignment);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
