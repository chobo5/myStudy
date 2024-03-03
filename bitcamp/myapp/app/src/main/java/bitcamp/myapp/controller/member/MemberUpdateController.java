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
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class MemberUpdateController implements PageController {

  private MemberDao memberDao;
  private String uploadDir;

  public MemberUpdateController(MemberDao memberDao, String uploadDir) {
    this.memberDao = memberDao;
    this.uploadDir = uploadDir;
  }


  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response)
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
}