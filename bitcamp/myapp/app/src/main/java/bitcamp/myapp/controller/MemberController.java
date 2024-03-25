package bitcamp.myapp.controller;

import bitcamp.myapp.service.MemberService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/member")
public class MemberController {
    private static final Log log = LogFactory.getLog(MemberController.class);
    private final MemberService memberService;
    private String uploadDir;

    public MemberController(MemberService memberService, ServletContext sc) {
        log.debug("생성자 호출");
        this.memberService = memberService;
        this.uploadDir = sc.getRealPath("/upload");
    }

    @GetMapping("form")
    public void form() {
    }

    @PostMapping("add")
    public String add(Member member,
                      MultipartFile file)
            throws ServletException, IOException {

        if (file.getSize() > 0) {
            // 파일을 선택해서 업로드 했다면,
            String filename = UUID.randomUUID().toString();
            member.setPhoto(filename);
            file.transferTo(new File(this.uploadDir + "/" + filename));
        }
        memberService.add(member);
        return "redirect:list";

    }

    @GetMapping("list")
    public void list(Model model)
            throws ServletException, IOException {
        model.addAttribute("list", memberService.list());
    }

    @GetMapping("view")
    public void view(int no, Model model) throws Exception {

        Member member = memberService.get(no);

        if (member == null) {
            throw new Exception("회원 번호가 유효하지 않습니다.");
        }
        model.addAttribute("member", member);
    }

    @PostMapping("update")
    public String update(Member member, MultipartFile file) throws Exception{

        Member old = memberService.get(member.getNo());
        if (old == null) {
            throw new Exception("회원 번호가 유효하지 않습니다.");
        }
        member.setNo(old.getNo());
        member.setCreatedDate(old.getCreatedDate());

        if (file.getSize() > 0) {
            // 파일을 선택해서 업로드 했다면,
            String filename = UUID.randomUUID().toString();
            member.setPhoto(filename);
            file.transferTo(new File(this.uploadDir + "/" + filename));
            new File(this.uploadDir + "/" + old.getPhoto()).delete();
        } else {
            member.setPhoto((old.getPhoto()));
        }

        memberService.update(member);
        return "redirect:list";

    }

    @GetMapping("delete")
    public String delete(int no) throws Exception {
        Member member = memberService.get(no);

        if (member == null) {
            throw new Exception("회원 번호가 유효하지 않습니다.");
        }
        memberService.delete(no);
        String filename = member.getPhoto();
        if (filename != null) {
            new File(this.uploadDir + "/" + filename).delete();
        }

        return "redirect:list";
    }

}
