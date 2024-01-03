package bitcamp.menu;

import bitcamp.util.Prompt;

import java.util.Stack;

//Composite 패턴에서 leaf역할을 수행하는 클래스
//Leaf
// - 하위 항목을 포함하지 않는 말단 객체.
public class MenuItem extends AbstractMenu {
    private String title;
    private MenuHandler menuHandler;

    public MenuItem(String title, Stack<String> breadCrumb) {
        super(title, breadCrumb);
    }

    public MenuItem(String title, MenuHandler menuHandler, Stack<String> breadCrumb) {
        this(title, breadCrumb);
        this.menuHandler = menuHandler;
    }

    @Override
    public void execute(Prompt prompt) {
        if(this.menuHandler != null) {
            try {
                this.menuHandler.action(this);
            } catch (NumberFormatException e) {
                System.out.println("번호를 입력하세요");
                return;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("번호가 유효하지 않습니다.");
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("입력 형식이잘못되었습니다, 다시 입력해주세요");
                return;
            } catch (Exception e) {
                System.out.println("실행 오류");
            }

        }
    }



}
