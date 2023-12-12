package bitcamp.myapp.handler.member;

import bitcamp.myapp.vo.Assignment;
import bitcamp.myapp.vo.Member;

public class MemberRepository {
    private Member[] members = new Member[3];

    private int length = 0;

    public void add(Member member) {
        if (this.length == this.members.length) {
            int oldSize = this.members.length;
            int newSize = oldSize + (oldSize / 2);

            // 이전 배열에 들어 있는 값을 새 배열에 복사
            Member[] arr = new Member[newSize];
            for (int i = 0; i < oldSize; i++) {
                arr[i] = this.members[i];
            }

            // 새 배열을 가리키도록 배열 레퍼런스를 변경
            this.members = arr;
        }


        this.members[this.length++] = member;
    }

    public Member remove(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        Member deleted = members[index];
        for (int i = index; i < (this.length - 1); i++) {
            this.members[i] = this.members[i + 1]; // 다음 레퍼런스의 값을 삭제하려는 현재 레퍼런스로 이동
        }
        this.members[this.length] = null;
        this.length--;
        return deleted;
    }

    public Member get(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        Member member = this.members[index];
        return member;
    }

    public Member[] toArray() {
        if (length == 0) {
            return null;
        }

        Member[] arr = new Member[length];
        for (int i = 0; i < length; i++) {
            arr[i] = members[i];
        }

        return arr;
    }

    public Member set(int index, Member member) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        members[index] = member;
        return members[index];

    }
}