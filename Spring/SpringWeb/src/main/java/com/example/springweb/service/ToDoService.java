package com.example.springweb.service;


import com.example.springweb.domain.ToDo;
import com.example.springweb.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@RequiredArgsConstructor //final이 붙은 필드만 초기화해주는 생성자가 자동으로 만들어진다.
public class ToDoService {
    private final ToDoRepository toDoRepository; //생성자에서 초기화

    @Transactional //트렌잭션 단위 동작한다.
    public void addToDo() {
        ToDo todo = new ToDo();
        todo.setTodo("hello" + new Date().toString());
        toDoRepository.save(todo);
    }
}
