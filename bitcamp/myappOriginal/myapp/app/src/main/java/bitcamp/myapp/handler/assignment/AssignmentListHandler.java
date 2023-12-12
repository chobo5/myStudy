package bitcamp.myapp.handler.assignment;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public class AssignmentListHandler implements MenuHandler {

    AssignmentRepository assignmentRepository;

    public AssignmentListHandler(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
        System.out.printf("%-20s\t%s\n", "과제", "제출마감일");

        Assignment[] assignments = assignmentRepository.toArray();
        if (assignments == null) {
            System.out.println("과제가 존재하지 않습니다.");
            return;
        }

        for (Assignment assignment : assignments) {
            System.out.printf("%-20s\t%s\n", assignment.title, assignment.deadline);
        }
    }
}
