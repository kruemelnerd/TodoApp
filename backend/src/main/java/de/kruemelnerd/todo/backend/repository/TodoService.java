package de.kruemelnerd.todo.backend.repository;

import de.kruemelnerd.todo.backend.domain.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo saveTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Todo getTodo(long id) {
        return todoRepository.getOne(id);
    }

    public Todo toogleTodoEntry(long id) {
        Todo todo = todoRepository.getOne(id);
        todo.setDone(!todo.getDone());
        return todoRepository.save(todo);
    }
}
