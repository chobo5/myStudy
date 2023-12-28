package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.List;
import bitcamp.util.Prompt;

import java.util.ArrayList;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class MemberDeleteHandler extends AbstractMenuHandler {
    private List<Member> objectRepository;

    public MemberDeleteHandler(Prompt prompt, List<Member> objectRepository) {
        super(prompt);
        this.objectRepository = objectRepository;
    }
    @Override
    public void action() {
        int index = this.prompt.inputInt("번호? ");
        this.objectRepository.remove(index);
        System.out.println("성공적으로 삭제되었습니다.");
    }
}
