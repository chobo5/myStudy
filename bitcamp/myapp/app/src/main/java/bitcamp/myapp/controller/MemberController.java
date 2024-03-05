package bitcamp.myapp.controller;

import bitcamp.myapp.controller.RequestMapping;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


public class MemberController {

    private MemberDao memberDao;
    private String uploadDir;

    public MemberController(MemberDao memberDao, String uploadDir) {
        this.memberDao = memberDao;
        this.uploadDir = uploadDir;
    }

    @RequestMapping("/member/add")
    public String add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getMethod().equals("GET")) {
            return "/member/form.jsp";
        }

        Member member = new Member();
        member.setEmail(request.getParameter("email"));
        member.setName(request.getParameter("name"));
        member.setPassword(request.getParameter("password"));


        Part photoPart = request.getPart("photo");
        if (photoPart.getSize() > 0) {
            // 파일을 선택해서 업로드 했다면,
            String filename = UUID.randomUUID().toString();
            member.setPhoto(filename);
            photoPart.write(this.uploadDir + "/" + filename);
        }
        memberDao.add(member);
        request.setAttribute("viewUrl", "redirect:list");
        return "redirect:list";

    }

    @RequestMapping("/member/list")
    public String list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("list", memberDao.findAll());
        return "/member/list.jsp";
    }

    @RequestMapping("/member/view")
    public String view(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        int no = Integer.parseInt(request.getParameter("no"));
        Member member = memberDao.findBy(no);

        if (member == null) {
            throw new Exception("회원 번호가 유효하지 않습니다.");
        }

        request.setAttribute("member", member);
        return "/member/view.jsp";
    }

    @RequestMapping("/member/update")
    public String update(HttpServletRequest request, HttpServletResponse response)
            throws Exception{

        int no = Integer.parseInt(request.getParameter("no"));
        Member old = memberDao.findBy(no);
        if (old == null) {
            throw new Exception("회원 번호가 유효하지 않습니다.");
        }

        Member member = new Member();
        member.setNo(old.getNo());
        member.setEmail(request.getParameter("email"));
        member.setName(request.getParameter("name"));
        member.setPassword(request.getParameter("password"));
        member.setCreatedDate(old.getCreatedDate());

        Part photoPart = request.getPart("photo");
        if (photoPart.getSize() > 0) {
            // 파일을 선택해서 업로드 했다면,
            String filename = UUID.randomUUID().toString();
            member.setPhoto(filename);
            photoPart.write(this.uploadDir + "/" + filename);
            new File(this.uploadDir + "/" + old.getPhoto()).delete();
        } else {
            member.setPhoto((old.getPhoto()));
        }

        memberDao.update(member);
        return "redirect:list";


    }

    @RequestMapping("/member/delete")
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        int no = Integer.parseInt(request.getParameter("no"));
        System.out.println("NO " + no);
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