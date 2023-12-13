package bitcamp.myapp.handler.assignment;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;

public class AssignmentModifyHandler implements MenuHandler {
    Prompt prompt;
    ArrayList<Assignment> objectRepository;

    public AssignmentModifyHandler(Prompt prompt, ArrayList<Assignment> objectRepository) {
        this.prompt = prompt;
        this.objectRepository = objectRepository;

    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = this.prompt.inputInt("번호? ");
        Assignment oldAssignment = (Assignment) objectRepository.get(index);

        if (oldAssignment == null) {
            System.out.println("과제 번호가 유효하지 않습니다.");
            return;
        }

        Assignment newAssignment = new Assignment();
        newAssignment.title = this.prompt.input("과제명(%s)? ", oldAssignment.title);
        newAssignment.content = this.prompt.input("내용(%s)? ", oldAssignment.content);
        newAssignment.deadline = this.prompt.input("제출 마감일(%s)? ", oldAssignment.deadline);
        objectRepository.set(index, newAssignment);
    }
}
