package bitcamp.myapp.menu;

import bitcamp.myapp.menu.MenuService;
import bitcamp.util.Prompt;
import bitcamp.myapp.vo.Assignment;

public class AssignmentMenu {
    private String title;

    //의존 객체(dependency object - dependency)
    private Prompt prompt;
    private MenuService<Assignment> menuService;

    public AssignmentMenu(String title, Prompt prompt) {
        this.title = title;
        this.prompt = prompt;
        this.menuService = new MenuService<Assignment>(3);
    }

    public void execute() {
        while (true) {
            final String[] ASSIGNMENT_MENUS = {this.title, "1.등록", "2.조회", "3.변경", "4.삭제", "5.목록", "0.이전"};
            menuService.showMenu(ASSIGNMENT_MENUS);
            String input = prompt.getUserInput("메인/" + this.title, "");
            switch (input) {
                case "1":
                    addAssignment();
                    break;
                case "2":
                    getAssignment();
                    break;
                case "3":
                    modifyAssignment();
                    break;
                case "4":
                    deleteAssignment();
                    break;
                case "5":
                    getAllAssignments();
                    break;
                case "0":
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    return;
                case "menu":
                    menuService.showMenu(ASSIGNMENT_MENUS);
                    break;
                default:
                    System.out.println("올바른 메뉴번호를 입력하세요");
                    break;
            }
        }
    }

    private void addAssignment() {
        System.out.println("=> 과제 등록");
        Assignment assignment = new Assignment();
        assignment.title = prompt.getUserInput("메인/과제", "과제명: ");
        assignment.content = prompt.getUserInput("메인/과제", "내용: ");
        assignment.deadLine = prompt.getUserInput("메인/과제", "제출 마감일: ");
        menuService.add(assignment);
        System.out.println("과제등록이 완료되었습니다.");

    }

    private void getAssignment() {
        System.out.println("과제 상세조회입니다.");
        int index = prompt.inputInt("메인/과제", "조회할 과제의 번호를 입력하세요.");
        menuService.get(index);
    }

    private void modifyAssignment() {
        System.out.println("과제 변경입니다.");
        int index = prompt.inputInt("메인/과제", "변경할 과제의 번호를 입력하세요.");
        Assignment assignment = new Assignment();
        assignment.title = prompt.getUserInput("메인/과제", "과제명 수정: ");
        assignment.content = prompt.getUserInput("메인/과제", "내용 수정: ");
        assignment.deadLine = prompt.getUserInput("메인/과제", "제출 마감일 수정: ");
        menuService.modify(index, assignment);

    }

    private void deleteAssignment() {
        System.out.println("과제 삭제입니다.");
        int index = prompt.inputInt("메인/과제", "삭제할 과제 번호를 입력하세요.");
        menuService.delete(index);
    }


    private void getAllAssignments() {
        System.out.println("과제 목록입니다.");
        System.out.printf("%-20s\t%s\n", "과제", "제출 마감일");
        menuService.getAll();
    }
}
