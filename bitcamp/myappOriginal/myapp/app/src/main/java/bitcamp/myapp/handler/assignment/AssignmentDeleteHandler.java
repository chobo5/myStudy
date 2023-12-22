package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;

public class AssignmentDeleteHandler extends AbstractMenuHandler {
    private ArrayList<Assignment> objectRepository;

    public AssignmentDeleteHandler(Prompt prompt, ArrayList<Assignment> objectRepository) {
        super(prompt);
        this.objectRepository = objectRepository;

    }

    @Override
    public void action() {
        try {
            int index = this.prompt.inputInt("번호? ");
            objectRepository.remove(index);
            System.out.println("성공적으로 삭제되었습니다.");
        } catch (Exception e) {
            System.out.println("삭제 오류");
        }


    }
}
