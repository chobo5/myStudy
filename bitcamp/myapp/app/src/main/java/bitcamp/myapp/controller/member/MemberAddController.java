package bitcamp.myapp.controller.member;

import bitcamp.myapp.controller.PageController;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;


public class MemberAddController implements PageController {

    private MemberDao memberDao;
    private String uploadDir;

    public MemberAddController(MemberDao memberDao, String uploadDir) {
        this.memberDao = memberDao;
        this.uploadDir = uploadDir;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
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


}
