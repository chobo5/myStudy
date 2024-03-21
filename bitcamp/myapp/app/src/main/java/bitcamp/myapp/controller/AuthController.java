package bitcamp.myapp.controller;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.mysql.AssignmentDaoImpl;
import bitcamp.myapp.vo.Member;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final Log log = LogFactory.getLog(AuthController.class);
    MemberDao memberDao;

    public AuthController(MemberDao memberDao) {
        log.debug("생성자 호출");
        this.memberDao = memberDao;
    }

    @GetMapping("form")
    public void form(@CookieValue(value = "email", required = false) String email, Model model) {
        model.addAttribute("email", email);
    }
    @PostMapping("login")
    public String login(String email,
                        String password,
                        String saveEmail,
                        HttpServletResponse response,
                        HttpSession session) throws Exception {

        if (saveEmail != null) {
            Cookie cookie = new Cookie("email", email);
            cookie.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("email", "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        Member member = memberDao.findByEmailAndPassword(email, password);

        if (member != null) {
            session.setAttribute("loginUser", member);
        }
        return "auth/login";
    }

    @GetMapping("logout")
    public String logout(HttpSession session)
            throws ServletException, IOException {
        session.invalidate();
        return "redirect:/index.html";
    }

}
