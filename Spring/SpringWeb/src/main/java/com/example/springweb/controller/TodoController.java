package com.example.springweb.controller;


import com.example.springweb.domain.ToDo;
import com.example.springweb.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//결과를 만들어서 view(JSP)에게 전달한다.
@Controller
@RequestMapping("/todos")
//http://localhost:8080/todos 이 경로로 시작해야한다.
@RequiredArgsConstructor
public class TodoController {

    private final ToDoService toDoService;
    @GetMapping("/list") //위의 경로에 /list를 붙인 경로가 실행되야 아래의 메서드가 실행된다.
    public String list(Model model) { //Dispatcher Servlet이 실행되면 자동으로 모델객체를 넣어준다.-> view(JSP)에서 사
        List<ToDo> toDoList = toDoService.getTodoList();
        model.addAttribute("todos", toDoList);
        return "list";
    }

    @PostMapping("/addToDo")
    public String addToDo(@RequestParam("todo") String todo) {
        toDoService.addToDo(todo);
        return "redirect/todos/list"; //자동 이동, http://localhost:8080/todos/list
    }
}
