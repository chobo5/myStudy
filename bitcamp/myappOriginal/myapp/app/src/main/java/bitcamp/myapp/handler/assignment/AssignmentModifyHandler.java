package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;

import java.util.List;

public class AssignmentModifyHandler extends AbstractMenuHandler {
    private List<Assignment> objectRepository;

    public AssignmentModifyHandler(Prompt prompt, List<Assignment> objectRepository) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    public void action() {
        int index = this.prompt.inputInt("번호? ");
        Assignment oldAssignment = (Assignment) objectRepository.get(index);
        Assignment newAssignment = new Assignment();
        newAssignment.setTitle(this.prompt.input("과제명(%s)? ", oldAssignment.getTitle()));
        newAssignment.setContent(this.prompt.input("내용(%s)? ", oldAssignment.getContent()));
        newAssignment.setDeadline(this.prompt.inputDate("제출 마감일(%s)? ", oldAssignment.getDeadline()));
        objectRepository.set(index, newAssignment);
    }
}
