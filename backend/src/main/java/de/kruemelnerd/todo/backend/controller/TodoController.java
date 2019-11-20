package de.kruemelnerd.todo.backend.controller;

import de.kruemelnerd.todo.backend.model.Todo;
import de.kruemelnerd.todo.backend.repository.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.access.prepost.PreAuthorize;


import java.util.List;

@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("todo")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    ResponseEntity<List<Todo>> getAllTodos() {
        return new ResponseEntity<>(todoService.getAllTodos(), HttpStatus.OK);
    }

    @PostMapping("todo")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    ResponseEntity<Todo> saveNewTodo(@RequestBody Todo todo) {
        return new ResponseEntity<>(todoService.saveTodo(todo), HttpStatus.CREATED);
    }

    @PutMapping("toogleTodo")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Todo> toogleMap(@RequestBody long id) {
        return new ResponseEntity<>(todoService.toogleTodoEntry(id), HttpStatus.OK);
    }
}
