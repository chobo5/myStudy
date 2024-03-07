package bitcamp.myapp.controller;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.vo.Assignment;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

@Component
public class AssignmentController {

    private AssignmentDao assignmentDao;

    public AssignmentController(AssignmentDao assignmentDao) {
        System.out.println("AssignmentController() 생성됨");
        this.assignmentDao = assignmentDao;
    }

    @RequestMapping("/assignment/form")
    public String form() throws  Exception   {
        return "/assignment/form.jsp";
    }

    @RequestMapping("/assignment/add")
    public String add(Assignment assignment)
            throws Exception {
        assignmentDao.add(assignment);
        System.out.println(assignment);
        return "redirect:list";
    }

    @RequestMapping("/assignment/list")
    public String list(Map<String, Object> map)
            throws ServletException, IOException {
        map.put("list", assignmentDao.findAll());
        return "/assignment/list.jsp";
    }

    @RequestMapping("/assignment/view")
    public String view(@RequestParam("no") int no, Map<String, Object> map)
            throws Exception {
        Assignment assignment = assignmentDao.findBy(no);
        if (assignment == null) {
            throw new Exception("과제 번호가 유효하지 않습니다.");
        }
        map.put("assignment", assignment);
        return "/assignment/view.jsp";
    }

    @RequestMapping("/assignment/update")
    public String update(Assignment assignment)
            throws Exception {


        Assignment old = assignmentDao.findBy(assignment.getNo());
        if (old == null) {
            throw new Exception("과제 번호가 유효하지 않습니다.");
        }

        assignmentDao.update(assignment);
        return "redirect:list";

    }

    @RequestMapping("/assignment/delete")
    public String delete(@RequestParam("no") int no)
            throws Exception {

        if (assignmentDao.delete(no) == 0) {
            throw new Exception("과제 번호가 유효하지 않습니다.");
        }
        return "redirect:list";
    }


}
