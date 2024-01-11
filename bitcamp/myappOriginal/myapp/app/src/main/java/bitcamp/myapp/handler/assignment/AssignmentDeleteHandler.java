package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BasicDao;
import bitcamp.util.Prompt;

public class AssignmentDeleteHandler extends AbstractMenuHandler {
    private BasicDao assignmentDao;

    public AssignmentDeleteHandler(Prompt prompt, BasicDao assignmentDao) {
        super(prompt);
        this.assignmentDao = assignmentDao;

    }

    @Override
    public void action() {
        try {
            int index = this.prompt.inputInt("번호? ");
            assignmentDao.delete(index);
            System.out.println("성공적으로 삭제되었습니다.");
        } catch (Exception e) {
            System.out.println("삭제 오류");
        }


    }
}
