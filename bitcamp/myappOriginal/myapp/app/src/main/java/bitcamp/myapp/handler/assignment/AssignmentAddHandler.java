package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.sql.Date;
import java.util.ArrayList;

public class AssignmentAddHandler extends AbstractMenuHandler {
    private ArrayList<Assignment> objectRepository;

    public AssignmentAddHandler(Prompt prompt, ArrayList<Assignment> objectRepository) {
        super(prompt);
        this.objectRepository = objectRepository;

    }

    @Override
    public void action() {
    try {
        Assignment assignment = new Assignment();
        assignment.setTitle(prompt.input("과제명? "));
        assignment.setContent(prompt.input("내용? "));
        assignment.setDeadline(prompt.inputDate("제출 마감일(YYYY-MM-DD)? "));
        this.objectRepository.add(assignment);
    } catch (Exception e) {
        System.out.println("과제 입력 형식이잘못되었습니다, 다시 입력해주세요");
        action();
    }

    }
}
