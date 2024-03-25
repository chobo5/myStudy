package bitcamp.myapp.service.impl;

import bitcamp.myapp.controller.MemberController;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.service.AssignmentService;
import bitcamp.myapp.vo.Assignment;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class DefaultAssignmentService implements AssignmentService {

    private static final Log log = LogFactory.getLog(DefaultAssignmentService.class);
    private final AssignmentDao assignmentDao;

    @Override
    public void add(Assignment assignment) {
        assignmentDao.add(assignment);
    }

    @Override
    public int update(Assignment assignment) {
        return assignmentDao.update(assignment);
    }

    @Override
    public List<Assignment> list() {
        return assignmentDao.findAll();
    }

    @Override
    public Assignment get(int no) {
        return assignmentDao.findBy(no);
    }

    @Override
    public int delete(int no) {
        return assignmentDao.delete(no);
    }
}
