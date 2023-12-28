package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.List;
import bitcamp.util.Prompt;

import java.util.ArrayList;

public class AssignmentListHandler extends AbstractMenuHandler {

    private List<Assignment> objectRepository;

    public AssignmentListHandler(Prompt prompt, List<Assignment> objectRepository) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    public void action() {
        System.out.printf("%-20s\t%s\n", "과제", "제출마감일");

        Object[] objects = objectRepository.toArray();
        if (objects == null) {
            System.out.println("과제가 존재하지 않습니다.");
            return;
        }

        for (Object object : objects) {
            Assignment assignment = (Assignment) object;
            System.out.printf("%-20s\t%s\n", assignment.getTitle(), assignment.getDeadline());
        }
    }
}
