package bitcamp.myapp;

public class AssignmentMenu {
    private static final String[] ASSIGNMENT_MENUS = {"과제", "1.등록", "2.조회", "3.변경", "4.삭제", "0.이전"};


    public static void execute() {
        while (true) {
            MenuProvider.showMenu(ASSIGNMENT_MENUS);
            String input = Prompt.getUserInput("메인/과제");
            switch (input) {
                case "1":
                    System.out.println("과제 등록입니다.");
                    break;
                case "2":
                    System.out.println("과제 조회입니다.");
                    break;
                case "3":
                    System.out.println("과제 변경입니다.");
                    break;
                case "4":
                    System.out.println("과제 삭제입니다.");
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
}
