package bitcamp.myapp.handler.assignment;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;

import java.util.ArrayList;

public class AssignmentListHandler implements MenuHandler {

    ArrayList<Assignment> objectRepository;

    public AssignmentListHandler(ArrayList<Assignment> objectRepository) {
        this.objectRepository = objectRepository;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
        System.out.printf("%-20s\t%s\n", "과제", "제출마감일");

        Object[] objects = objectRepository.toArray();
        if (objects == null) {
            System.out.println("과제가 존재하지 않습니다.");
            return;
        }

        for (Object object : objects) {
            Assignment assignment = (Assignment) object;
            System.out.printf("%-20s\t%s\n", assignment.title, assignment.deadline);
        }
    }
}
