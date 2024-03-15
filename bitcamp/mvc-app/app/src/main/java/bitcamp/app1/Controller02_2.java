package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/c02_2")
public class Controller02_2 {

    @GetMapping //GET 요청일 떄만 호출
    @ResponseBody
    public String handler1() {
        return "get";
    }

    @PostMapping
    @ResponseBody
    public String handler12() {
        return "post";
    }
}
