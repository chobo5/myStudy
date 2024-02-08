package bitcamp.myapp.handler;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.util.Prompt;

public class HelpHandler extends AbstractMenuHandler {

  @Override
  protected void action(Prompt prompt) {
    System.out.println("도움말입니다.");
  }
}
