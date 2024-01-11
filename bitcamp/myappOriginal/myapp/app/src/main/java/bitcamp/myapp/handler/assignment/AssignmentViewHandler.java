package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BasicDao;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;

public class AssignmentViewHandler extends AbstractMenuHandler {
    private BasicDao assignmentDao;

    public AssignmentViewHandler(Prompt prompt, BasicDao assignmentDao) {
        super(prompt);
        this.assignmentDao = assignmentDao;

    }

    @Override
    public void action() {

        int no = this.prompt.inputInt("번호? ");
        Assignment assignment = (Assignment) assignmentDao.findBy(no);
        if (assignment == null) {
            System.out.println("과제 번호가 유효하지 않습니다.");
            return;
        }
        System.out.printf("NO: %d\n", assignment.getNo());
        System.out.printf("과제명: %s\n", assignment.getTitle());
        System.out.printf("내용: %s\n", assignment.getContent());
        System.out.printf("제출 마감일: %s\n", assignment.getDeadline());
    }
}
