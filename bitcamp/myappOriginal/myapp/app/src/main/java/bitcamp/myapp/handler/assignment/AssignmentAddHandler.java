package bitcamp.myapp.handler.assignment;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;

public class AssignmentAddHandler implements MenuHandler {
    Prompt prompt;
    ArrayList<Assignment> objectRepository;

    public AssignmentAddHandler(Prompt prompt, ArrayList<Assignment> objectRepository) {
        this.prompt = prompt;
        this.objectRepository = objectRepository;

    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        Assignment assignment = new Assignment();
        assignment.title = prompt.input("과제명? ");
        assignment.content = prompt.input("내용? ");
        assignment.deadline = prompt.input("제출 마감일? ");

        this.objectRepository.add(assignment);
    }
}
