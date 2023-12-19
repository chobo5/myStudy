package com.example.springweb.service;


import com.example.springweb.domain.ToDo;
import com.example.springweb.repository.ToDoRepository;
import com.sun.tools.javac.comp.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor //final이 붙은 필드만 초기화해주는 생성자가 자동으로 만들어진다.
public class ToDoService {
    private final ToDoRepository toDoRepository; //생성자에서 초기화

    @Transactional //트렌잭션 단위 동작한다.
    public void addToDo(String todo) {
        ToDo toDo = new ToDo();
        toDo.setTodo(todo);
        toDoRepository.save(toDo);
    }

    @Transactional(readOnly = true) //조회만 한다.
    public List<ToDo> getTodoList() {
        return toDoRepository.findAll();
    }


}
