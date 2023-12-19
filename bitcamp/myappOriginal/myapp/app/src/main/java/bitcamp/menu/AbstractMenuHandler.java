package bitcamp.menu;

import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public abstract class AbstractMenuHandler implements MenuHandler{

    protected Prompt prompt;
    protected Menu menu;

    public AbstractMenuHandler(Prompt prompt) {
        this.prompt = prompt;
    }

    @Override
    public void action(Menu menu) {
        printMenuTitle(menu.getTitle());
        //서브클래스를 구현할 때 , 사용할 일이 있다면 쓸 수 있도록 보관해 둔다.
        this.menu = menu;
        //Menu를 실행할떄 이 메서드가 호출되면
        //즉시 서브클래스의 다음메서드를 호출한다.
        action();
    }

    private void printMenuTitle(String title) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, title);
    }


    //서브 클래스가 구현해야할 메서드
    //MenuHandler 인터페이스의 action(Menu menu)함수가 실행될떄 실행되야할 메서드.
    //따라서 Protected
    protected abstract void action();
}
