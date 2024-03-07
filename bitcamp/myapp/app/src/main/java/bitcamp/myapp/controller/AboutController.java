package bitcamp.myapp.controller;


import org.springframework.stereotype.Component;

@Component
public class AboutController {
    @RequestMapping("/about")
    public String about()
            throws Exception {
        return "/about.jsp";
    }

    public AboutController() {
        System.out.println("AboutController() 호출됨");
    }
}


