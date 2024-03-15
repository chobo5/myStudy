package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c01_1")
public class Controller01_1 {

//    @RequestMapping //이 애노테이션을 붙여서 요청이 들어왔을 떄 호출될 메서드임을 표시한다. -> RequestHandler
    @ResponseBody
    public String handler() {
        return "c01_1 -> handler()";
    }

    @RequestMapping //이 애노테이션을 붙여서 요청이 들어왔을 떄 호출될 메서드임을 표시한다.
    @ResponseBody
    public String handler2() {
        return "c01_1 -> handler2()";
    }
}
