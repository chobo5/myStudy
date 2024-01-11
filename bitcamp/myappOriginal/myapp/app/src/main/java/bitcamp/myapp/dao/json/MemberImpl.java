package bitcamp.myapp.dao.json;

import bitcamp.myapp.dao.AbstractDao;
import bitcamp.myapp.vo.Member;

import java.util.List;

public class MemberImpl extends AbstractDao<Member> {

    private int nextKey;
    public MemberImpl(String filepath) {
        super(filepath);
        nextKey = list.getLast().getNo() + 1;
    }
    @Override
    public void add(Member member) {
        member.setNo(nextKey++);
        list.add(member);
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
    public int update(Member member) {
        int index = indexOf(member.getNo());
        if (index != -1) {
            list.set(index, member);
            saveData();
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Member findBy(int no) {
        int index = indexOf(no);
        return list.get(index);
    }

    public Member findBy(String email) {
        int index = indexOf(email);
        return list.get(index);
    }

    @Override
    public List<Member> findAll() {
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

    private int indexOf(String email) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmail().equals(email)) {
                return i;
            }
        }
        return -1;
    }
}
