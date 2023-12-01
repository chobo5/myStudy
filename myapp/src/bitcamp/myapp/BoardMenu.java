package bitcamp.myapp;



public class BoardMenu {
    private static final String[] ONBOARD_MENU = {"게시글", "1.등록", "2.조회", "3.변경", "4.삭제", "0.이전"};

    public static void execute() {
        while (true) {
            MenuProvider.showMenu(ONBOARD_MENU);
            String input = Prompt.getUserInput("메인/게시글");
            switch (input) {
                case "1":
                    System.out.println("등록입니다.");
                    break;
                case "2":
                    System.out.println("조회입니다.");
                    break;
                case "3":
                    System.out.println("변경입니다.");
                    break;
                case "4":
                    System.out.println("삭제입니다.");
                    break;
                case "0":
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    return;
                case "menu":
                    MenuProvider.showMenu(ONBOARD_MENU);
                    break;
                default:
                    System.out.println("올바른 메뉴번호를 입력하세요");
                    break;
            }
        }
    }
}
