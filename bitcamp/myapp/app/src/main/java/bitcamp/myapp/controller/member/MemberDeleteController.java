package bitcamp.myapp.controller.member;

import bitcamp.myapp.controller.PageController;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class MemberDeleteController implements PageController {

    private MemberDao memberDao;
    private String uploadDir;

    public MemberDeleteController(MemberDao memberDao, String uploadDir) {
        this.memberDao = memberDao;
        this.uploadDir = uploadDir;
    }

    @Override
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
