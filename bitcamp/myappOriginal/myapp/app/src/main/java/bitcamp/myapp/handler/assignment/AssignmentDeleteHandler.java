package bitcamp.myapp.handler.assignment;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public class AssignmentDeleteHandler implements MenuHandler {
    Prompt prompt;
    AssignmentRepository assignmentRepository;

    public AssignmentDeleteHandler(Prompt prompt, AssignmentRepository assignmentRepository) {
        this.prompt = prompt;
        this.assignmentRepository = assignmentRepository;

    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = this.prompt.inputInt("번호? ");
        if (assignmentRepository.remove(index) == null) {
            System.out.println("과제 번호가 유효하지 않습니다.");
            return;
        }
        System.out.println("성공적으로 삭제되었습니다.");

    }
}
