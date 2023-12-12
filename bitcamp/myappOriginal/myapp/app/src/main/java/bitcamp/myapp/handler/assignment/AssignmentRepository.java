package bitcamp.myapp.handler.assignment;

import bitcamp.myapp.vo.Assignment;

public class AssignmentRepository {
    private Assignment[] assignments = new Assignment[3];
    private int length = 0;

    public void add(Assignment assignment) {
        if (this.length == this.assignments.length) {
            int oldSize = this.assignments.length;
            int newSize = oldSize + (oldSize / 2);

            // 이전 배열에 들어 있는 값을 새 배열에 복사
            Assignment[] arr = new Assignment[newSize];
            for (int i = 0; i < oldSize; i++) {
                arr[i] = this.assignments[i];
            }

            // 새 배열을 가리키도록 배열 레퍼런스를 변경
            this.assignments = arr;
        }


        this.assignments[this.length++] = assignment;
    }

    public Assignment remove(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        Assignment deleted = assignments[index];
        for (int i = index; i < (this.length - 1); i++) {
            this.assignments[i] = this.assignments[i + 1]; // 다음 레퍼런스의 값을 삭제하려는 현재 레퍼런스로 이동
        }
        this.assignments[this.length] = null;
        this.length--;
        return deleted;
    }

    public Assignment get(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        Assignment assignment = this.assignments[index];
        return assignment;
    }

    public Assignment[] toArray() {
        if (length == 0) {
            return null;
        }

        Assignment[] arr = new Assignment[length];
        for (int i = 0; i < length; i++) {
            arr[i] = assignments[i];
        }

        return arr;
    }

    public Assignment set(int index, Assignment assignment) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        assignments[index] = assignment;
        return assignments[index];
    }
}
