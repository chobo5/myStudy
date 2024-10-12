package assignment;

import menu.MenuCommand;

import java.io.BufferedReader;
import java.util.List;

public class AssignmentListCommand implements MenuCommand {

    private BufferedReader in;
    private AssignmentRepository assignmentRepository;

    public AssignmentListCommand(BufferedReader in, AssignmentRepository assignmentRepository) {
        this.in = in;
        this.assignmentRepository = assignmentRepository;
    }


    @Override
    public void action() {
        List<Assignment> assignmentList = assignmentRepository.list();
        for (int i = 0; i < assignmentList.size(); i++) {
            System.out.print(i + 1 + ". ");
            System.out.println(assignmentList.get(i));
        }
    }
}
