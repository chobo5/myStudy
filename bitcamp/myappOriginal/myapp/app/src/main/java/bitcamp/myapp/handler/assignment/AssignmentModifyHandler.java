package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;
import bitcamp.myapp.dao.BasicDao;

public class AssignmentModifyHandler extends AbstractMenuHandler {
    private BasicDao assignmentDao;

    public AssignmentModifyHandler(Prompt prompt, BasicDao assignmentDao) {
        super(prompt);
        this.assignmentDao = assignmentDao;
    }

    @Override
    public void action() {
        int no = this.prompt.inputInt("번호? ");
        Assignment oldAssignment = (Assignment) assignmentDao.findBy(no);
        Assignment newAssignment = new Assignment();
        newAssignment.setNo(oldAssignment.getNo());
        newAssignment.setTitle(this.prompt.input("과제명(%s)? ", oldAssignment.getTitle()));
        newAssignment.setContent(this.prompt.input("내용(%s)? ", oldAssignment.getContent()));
        newAssignment.setDeadline(this.prompt.inputDate("제출 마감일(%s)? ", oldAssignment.getDeadline()));
        assignmentDao.update(newAssignment);
    }
}
