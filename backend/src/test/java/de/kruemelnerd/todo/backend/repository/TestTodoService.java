package de.kruemelnerd.todo.backend.repository;

import de.kruemelnerd.todo.backend.domain.Todo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestTodoService {

    @Mock
    TodoRepository todoRepository;


    @InjectMocks
    TodoService todoService;

    @Test
    void saveATodo(){
        Todo todo = new Todo();
        todo.setDesciption("testdescription");
        todo.setTitle("testtitle");

        Todo savedTodo = todoService.saveTodo(todo);
        assertThat(todoRepository.count(), is(1L));
        assertThat(savedTodo.getDesciption(), is(todo.getDesciption()));
        assertThat(savedTodo.getTitle(), is(todo.getTitle()));
    }
}
