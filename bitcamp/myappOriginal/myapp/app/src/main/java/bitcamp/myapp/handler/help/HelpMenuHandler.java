package bitcamp.myapp.handler.help;

import bitcamp.menu.AbstractMenu;
import bitcamp.menu.AbstractMenuHandler;
import bitcamp.util.Prompt;

public class HelpMenuHandler extends AbstractMenuHandler {

    public HelpMenuHandler(Prompt prompt) {
        super(prompt);
    }

    @Override
    protected void action() {
        System.out.println("도움말입니다.");
    }
}
