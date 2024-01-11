package bitcamp.myapp.dao.json;

import bitcamp.myapp.dao.AbstractDao;
import bitcamp.myapp.vo.Assignment;

import java.util.List;

public class AssignmentDaoImpl extends AbstractDao<Assignment> {

    private int nextKey;
    public AssignmentDaoImpl(String filepath) {
        super(filepath);
        nextKey = list.getLast().getNo() + 1;
    }

    @Override
    public void add(Assignment assignment) {
        assignment.setNo(nextKey++);
        list.add(assignment);
        saveData();
    }

    @Override
    public int delete(int no) {
        int index = indexOf(no);
        if (index != -1) {
            list.remove(index);
            saveData();
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public int update(Assignment assignment) {
        int index = indexOf(assignment.getNo());
        if (index != -1) {
            list.set(index, assignment);
            saveData();
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Assignment findBy(int no) {
        int index = indexOf(no);
        return list.get(index);
    }

    @Override
    public List<Assignment> findAll() {
        return list.subList(0, list.size());
    }

    private int indexOf(int no) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNo() == no) {
                return i;
            }
        }
        return -1;
    }

}
