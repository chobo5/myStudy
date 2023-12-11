package bitcamp.myapp;

import bitcamp.myapp.menu.AssignmentMenu;
import bitcamp.myapp.menu.BoardMenu;
import bitcamp.myapp.menu.MainMenu;
import bitcamp.myapp.menu.MemberMenu;
import bitcamp.util.Prompt;

public class MyApp {

    public static void main(String[] args) {
        Prompt prompt = new Prompt();
//        MainMenu mainMenu = new MainMenu(prompt);
//        mainMenu.execute();
//        new MainMenu(prompt).execute();
        MenuGroup mainMenuGroup = new MenuGroup("메인", prompt);

        MenuGroup assignmentMenuGroup = new MenuGroup("과제", prompt);
        assignmentMenuGroup.add(new MenuItem("등록", prompt));
        assignmentMenuGroup.add(new MenuItem("조회", prompt));
        assignmentMenuGroup.add(new MenuItem("수정", prompt));
        assignmentMenuGroup.add(new MenuItem("삭제", prompt));
        assignmentMenuGroup.add(new MenuItem("목록", prompt));

        MenuGroup boardMenuGroup = new MenuGroup("게시글", prompt);
        boardMenuGroup.add(new MenuItem("등록", prompt));
        boardMenuGroup.add(new MenuItem("조회", prompt));
        boardMenuGroup.add(new MenuItem("수정", prompt));
        boardMenuGroup.add(new MenuItem("삭제", prompt));
        boardMenuGroup.add(new MenuItem("목록", prompt));

        MenuGroup memberMenuGroup = new MenuGroup("회원 관리", prompt);
        memberMenuGroup.add(new MenuItem("등록", prompt));
        memberMenuGroup.add(new MenuItem("조회", prompt));
        memberMenuGroup.add(new MenuItem("수정", prompt));
        memberMenuGroup.add(new MenuItem("삭제", prompt));
        memberMenuGroup.add(new MenuItem("목록", prompt));

        mainMenuGroup.add(assignmentMenuGroup);
        mainMenuGroup.add(boardMenuGroup);
        mainMenuGroup.add(memberMenuGroup);


        mainMenuGroup.execute(prompt);


        prompt.close();
    }
}