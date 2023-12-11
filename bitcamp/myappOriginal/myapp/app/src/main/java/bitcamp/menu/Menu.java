package bitcamp.menu;

import bitcamp.util.Prompt;

public interface Menu {
    //객체를 실행할때 호출할 메서드를 선언한다.
    //구현을 해서는 안된다
    //=> 추상메서드
    public abstract void execute(Prompt prompt); //public abstract 생략 가능

    public abstract String getTitle ();
}
