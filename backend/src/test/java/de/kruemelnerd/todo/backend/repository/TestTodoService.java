package de.kruemelnerd.todo.backend.repository;

import de.kruemelnerd.todo.backend.domain.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TestTodoService {

    @Mock
    TodoRepository todoRepository;

    @InjectMocks
    TodoService todoService;

    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveATodo(){
        Todo todo = new Todo();
        todo.setDescription("testdescription");
        todo.setTitle("testtitle");

        when(todoRepository.save(any( ))).thenReturn(todo);

        Todo savedTodo = todoService.saveTodo(todo);
        assertThat(savedTodo.getDescription(), is(todo.getDescription()));
        assertThat(savedTodo.getTitle(), is(todo.getTitle()));
    }

    @Test
    void getAllTests(){
        List<Todo> allTodos = new ArrayList<>();
        allTodos.add(new Todo("title1", "description1"));
        allTodos.add(new Todo("title2", "description2"));
        allTodos.add(new Todo("title3", "description3"));

        when(todoRepository.findAll()).thenReturn(allTodos);

        List<Todo> allTodosFromService = todoService.getAllTodos();
        assertThat(allTodosFromService, hasSize(3));
        assertThat(allTodosFromService.get(0).getTitle(), is("title1"));
        assertThat(allTodosFromService.get(1).getTitle(), is("title2"));
        assertThat(allTodosFromService.get(2).getTitle(), is("title3"));
        assertThat(allTodosFromService.get(0).getDescription(), is("description1"));
        assertThat(allTodosFromService.get(1).getDescription(), is("description2"));
        assertThat(allTodosFromService.get(2).getDescription(), is("description3"));


    }
}
