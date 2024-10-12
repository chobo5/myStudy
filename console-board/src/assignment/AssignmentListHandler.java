package assignment;

import menu.MenuHandler;

import java.io.BufferedReader;
import java.util.List;

public class AssignmentListHandler implements MenuHandler {

    private BufferedReader in;
    private AssignmentRepository assignmentRepository;

    public AssignmentListHandler(BufferedReader in, AssignmentRepository assignmentRepository) {
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
