package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class MemberModifyHandler extends AbstractMenuHandler {
    private ArrayList<Member> objectRepository;

    public MemberModifyHandler(Prompt prompt, ArrayList<Member> objectRepository) {
        super(prompt);
        this.objectRepository = objectRepository;
    }
    @Override
    public void action() {

        int index = this.prompt.inputInt("번호? ");
        Member oldMember = this.objectRepository.get(index);
        if (oldMember == null) {
            System.out.println("회원 번호가 유효하지 않습니다.");
            return;
        }

        Member newMember = new Member();
        newMember.setEmail(this.prompt.input("이메일(%s)? ", oldMember.getEmail()));
        newMember.setName(this.prompt.input("이름(%s)? ", oldMember.getName()));
        newMember.setPassword(this.prompt.input("새 암호? "));
        newMember.setCreatedDate(this.prompt.input("가입일(%s)? ", oldMember.getCreatedDate()));
        this.objectRepository.set(index, newMember);
    }
}
