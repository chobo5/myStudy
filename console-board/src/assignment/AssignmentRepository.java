package assignment;

import java.util.ArrayList;
import java.util.List;

public class AssignmentRepository {
    List<Assignment> assignmentList = new ArrayList<>();

    public void save(Assignment assignment) {
        assignmentList.add(assignment);
    }

    public Assignment findByNo(int no) {
        return assignmentList.get(no - 1);
    }

    public void delete(int no) {
        assignmentList.remove(no - 1);
    }

    public List<Assignment> list() {
        return assignmentList;
    }
}
