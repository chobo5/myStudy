package bitcamp.myapp.controller;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home()
            throws Exception {
        return "/home.jsp";
    }

    public HomeController() {
        System.out.println("HomeController() 호출됨");
    }
}


