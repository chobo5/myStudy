package bitcamp.myapp.controller;

import bitcamp.myapp.controller.RequestMapping;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Component
public class MemberController {

    private MemberDao memberDao;
    private String uploadDir = System.getProperty("member.upload.dir");

    public MemberController(MemberDao memberDao) {
        System.out.println("MemberController() 호출됨");
        this.memberDao = memberDao;
    }

    @RequestMapping("/member/form")
    public String form() {
        return "/member.form.jsp";
    }

    @RequestMapping("/member/add")
    public String add(Member member,
                      @RequestParam("file") Part file)
            throws ServletException, IOException {

        if (file.getSize() > 0) {
            // 파일을 선택해서 업로드 했다면,
            String filename = UUID.randomUUID().toString();
            member.setPhoto(filename);
            file.write(this.uploadDir + "/" + filename);
        }
        memberDao.add(member);
        return "redirect:list";

    }

    @RequestMapping("/member/list")
    public String list(Map<String, Object> map)
            throws ServletException, IOException {
        map.put("list", memberDao.findAll());
        return "/member/list.jsp";
    }

    @RequestMapping("/member/view")
    public String view(@RequestParam("no") int no,
                       Map<String, Object> map) throws Exception {

        Member member = memberDao.findBy(no);

        if (member == null) {
            throw new Exception("회원 번호가 유효하지 않습니다.");
        }
        map.put("member", member);
        return "/member/view.jsp";
    }

    @RequestMapping("/member/update")
    public String update(Member member,
                         @RequestParam("file") Part file) throws Exception{

        Member old = memberDao.findBy(member.getNo());
        if (old == null) {
            throw new Exception("회원 번호가 유효하지 않습니다.");
        }
        member.setNo(old.getNo());
        member.setCreatedDate(old.getCreatedDate());

        if (file.getSize() > 0) {
            // 파일을 선택해서 업로드 했다면,
            String filename = UUID.randomUUID().toString();
            member.setPhoto(filename);
            file.write(this.uploadDir + "/" + filename);
            new File(this.uploadDir + "/" + old.getPhoto()).delete();
        } else {
            member.setPhoto((old.getPhoto()));
        }

        memberDao.update(member);
        return "redirect:list";


    }

    @RequestMapping("/member/delete")
    public String delete(@RequestParam("no") int no)
            throws Exception {
        Member member = memberDao.findBy(no);

        if (member == null) {
            throw new Exception("회원 번호가 유효하지 않습니다.");
        }
        memberDao.delete(no);
        String filename = member.getPhoto();
        if (filename != null) {
            new File(this.uploadDir + "/" + filename).delete();
        }

        return "redirect:list";


    }

}
