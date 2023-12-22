package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;

public class AssignmentModifyHandler extends AbstractMenuHandler {
    private ArrayList<Assignment> objectRepository;

    public AssignmentModifyHandler(Prompt prompt, ArrayList<Assignment> objectRepository) {
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
