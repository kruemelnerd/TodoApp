package de.kruemelnerd.todo.backend.controller;

import de.kruemelnerd.todo.backend.domain.Todo;
import de.kruemelnerd.todo.backend.repository.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("getAllTodos")
    ResponseEntity<List<Todo>> getAllTodos(){
        return new ResponseEntity<>(todoService.getAllTodos(), HttpStatus.OK);
    }
}
