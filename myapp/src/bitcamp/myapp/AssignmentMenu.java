package bitcamp.myapp;

import java.util.Arrays;

public class AssignmentMenu {
    private static final String[] ASSIGNMENT_MENUS = {"과제", "1.등록", "2.조회", "3.변경", "4.삭제", "5.목록", "0.이전"};

    static Assignment[] assignments = new Assignment[3];

    static int currentIndex = 0;

    static int newLenth = 0;

    public static void execute() {
        while (true) {
            MenuProvider.showMenu(ASSIGNMENT_MENUS);
            String input = Prompt.getUserInput("메인/과제", "");
            switch (input) {
                case "1":
                    add();
                    break;
                case "2":
                    find();
                    break;
                case "3":
                    modify();
                    break;
                case "4":
                    delete();
                    break;
                case "5":
                    list();
                    break;
                case "0":
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    return;
                case "menu":
                    MenuProvider.showMenu(ASSIGNMENT_MENUS);
                    break;
                default:
                    System.out.println("올바른 메뉴번호를 입력하세요");
                    break;
            }
        }
    }
    private static void add() {
        System.out.println("=> 과제 등록");
        Assignment assignment = new Assignment();
        assignment.title = Prompt.getUserInput("메인/과제", "과제명: ");
        assignment.content = Prompt.getUserInput("메인/과제", "내용: ");
        assignment.deadLine = Prompt.getUserInput("메인/과제", "제출 마감일: ");
        assignments[currentIndex] = assignment;
        System.out.println("과제등록이 완료되었습니다.");

        currentIndex++;
        if (currentIndex > 3) {
            newLenth += 3;
            Assignment[] newArray = Arrays.copyOf(assignments, newLenth);
            assignments = newArray;
            currentIndex = newLenth;
        }

    }

    private static void find() {
        System.out.println("과제 상세조회입니다.");
        String strIndex = Prompt.getUserInput("메인/과제", "조회할 과제의 번호를 입력하세요.");
        int index = Integer.parseInt(strIndex);
        if (index >= 0 && index < currentIndex) {
            System.out.printf("과제명: %s\n", assignments[index].title);
            System.out.printf("내용: %s\n", assignments[index].content);
            System.out.printf("제출 마감일: %s\n", assignments[index].deadLine);
        } else {
            System.out.println("존재하지 않는 괴제입니다.");
        }


    }

    private static void modify() {
        System.out.println("과제 변경입니다.");
        String strIndex = Prompt.getUserInput("메인/과제", "변경할 과제의 번호를 입력하세요.");
        int index = Integer.parseInt(strIndex);
        if (index >= 0 && index < currentIndex) {
            assignments[index].title = Prompt.getUserInput("메인/과제", "과제명 수정: ");
            assignments[index].content = Prompt.getUserInput("메인/과제", "내용 수정: ");
            assignments[index].deadLine = Prompt.getUserInput("메인/과제", "제출 마감일 수정: ");
            System.out.println("과제 변경이 완료되었습니다..");
        } else {
            System.out.println("과제가 존재하지 않습니다.");
        }

    }

    private static void delete() {
        System.out.println("과제 삭제입니다.");
        String strIndex = Prompt.getUserInput("메인/과제", "삭제할 과제 번호를 입력하세요.");
        int index = Integer.parseInt(strIndex);
        if (index >= 0 && index < currentIndex) {
            for (int i = index; i < currentIndex - 1 ; i++) {
                assignments[i] = assignments[i + 1];
            }
            assignments[currentIndex - 1] = null; //주소의 인스턴스가 null이므로 garbage가 됬다.
            currentIndex--;

            System.out.println("과제 삭제가 완료되었습니다.");
        } else {
            System.out.println("존재하지 않는 괴제입니다.");
        }

    }

    private static void list() {
        System.out.println("과제 목록입니다.");
        System.out.printf("%-20s\t%s\n", "과제", "제출 마감일");
        for (int i = 0; i < currentIndex; i++) {
            System.out.printf("%-20s\t%s\n", assignments[i].title, assignments[i].deadLine);
            System.out.println();
        }
    }
}
