package bitcamp.myapp.controller;



import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    private static final Log log = LogFactory.getLog(AboutController.class);
    public AboutController() {
        log.debug("생성자 호출");
    }
    @GetMapping("/about")
    public void about() {
    }


}


