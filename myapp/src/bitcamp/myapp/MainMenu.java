package bitcamp.myapp;

public class MainMenu {
    private static final String[] MAIN_MENUS = {"과제관리 시스템", "1.과제", "2.게시글", "3.회원관리", "4.도움말", "0.종료"};

    private static void printMenu() {
        MenuProvider.showMenu(MAIN_MENUS);
    }

    public static void execute() {
        printMenu();
        while (true) {
            String input = Prompt.getUserInput("메인", "");
            switch (input) {
                case "1":
                    AssignmentMenu.execute();
                    break;
                case "2":
                    BoardMenu.execute();
                    break;
                case "3":
                    MemberMenu.execute();
                case "4":
                    System.out.println("도움말입니다.");
                    break;
                case "0":
                    System.out.println("종료합니다.");
                    Prompt.close();
                    return;
                case "menu":
                    MainMenu.printMenu();
                    break;
                default:
                    System.out.println("올바른 메뉴번호를 입력하세요");
                    break;
            }
        }
    }
}
