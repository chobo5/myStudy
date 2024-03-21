package bitcamp.myapp.controller;


import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private Log log = LogFactory.getLog(HomeController.class);
    public HomeController() {
        log.debug("생성자 호출됨");
    }
    @GetMapping("/home")
    public void home() {

    }



}


