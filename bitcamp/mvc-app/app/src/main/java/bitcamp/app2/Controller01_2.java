package bitcamp.app2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/c01_2")
public class Controller01_2 {
    @GetMapping("h1")
    public String handler1(Model model) {
        model.addAttribute("name", "홍길동");
        model.addAttribute("age", 20);
        return "c01_1";
    }

    @GetMapping("h2")
    public void handler2(Model model) {

        model.addAttribute("name", "홍길동2");
        model.addAttribute("age", 30);

        // InternalResourceViewResolver를 사용하는 경우,
        // request handler가 뷰 이름을 리턴하지 않으면
        // request handler의 URL을 상대 경로로써 뷰 이름으로 사용한다.
        // 즉 이 핸들러의 URL은 "/c01_2/h2" 이기 때문에 뷰 이름도 "/c01_2/h2"가 된다.
        // InternalResourceViewResolver는 바로 이 URL을 사용하여 다음과 같이 최종 URL을 만든다.
        // => "/WEB-INF/jsp2/" + "/c01_2/h2" + ".jsp"
        // => "/WEB-INF/jsp2/c01_2/h2.jsp"
        //
        // 실무에서는 이 방법을 많이 사용한다.
        // view name= /c01_2/h2
    }

    @GetMapping("h3")
    public Map<String, Object> handler3() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "홍길동3");
        map.put("age", 40);

        return map;
        //view name = c01_2/h3

    }

    @GetMapping("h4")
    public ModelAndView handler4() {

        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "홍길동3");
        mv.addObject("age", 40);
        mv.setViewName("c01_2/h4");

        // ModelAndView 객체에 값과 뷰 이름을 담아 리턴하면
        // 프론트 컨트롤러는 ModelAndView 객체에 보관되어 있는 값들을
        // ServletRequest 보관소로 옮기고,
        // 설정된 뷰 이름을 ViewResolver에게 넘긴다.
        //
        return mv;
    }

    @GetMapping("h5")
    public ModelAndView handler5() {

        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "홍길동3");
        mv.addObject("age", 40);

        // ModelAndView 객체에 값과 뷰 이름을 담아 리턴하면
        // 프론트 컨트롤러는 ModelAndView 객체에 보관되어 있는 값들을
        // ServletRequest 보관소로 옮기고,
        // 뷰 이름을 지정하지 않으면 request handler의 path를 ViewResolver에게 넘긴다.
        // => /c01_2/h5
        // InternalResourceViewResolver 는 위 URL을 다음과 같이 바꾼다.
        // => /WEB-INF/jsp2/c01_2/h5.jsp
        // 그런 후에 해당 URL의 JSP를 실행한다.
        return mv;
    }
}
