package de.kruemelnerd.todo.backend.repository;

import de.kruemelnerd.todo.backend.model.Todo;
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

class TodoServiceTest {

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
        allTodos.add(new Todo("title1", "description1", true));
        allTodos.add(new Todo("title2", "description2", false));
        allTodos.add(new Todo("title3", "description3", true));

        when(todoRepository.findAll()).thenReturn(allTodos);

        List<Todo> allTodosFromService = todoService.getAllTodos();
        assertThat(allTodosFromService, hasSize(3));
        assertThat(allTodosFromService.get(0).getTitle(), is("title1"));
        assertThat(allTodosFromService.get(1).getTitle(), is("title2"));
        assertThat(allTodosFromService.get(2).getTitle(), is("title3"));

        assertThat(allTodosFromService.get(0).getDescription(), is("description1"));
        assertThat(allTodosFromService.get(1).getDescription(), is("description2"));
        assertThat(allTodosFromService.get(2).getDescription(), is("description3"));

        assertThat(allTodosFromService.get(0).getDone(), is(true));
        assertThat(allTodosFromService.get(1).getDone(), is(false));
        assertThat(allTodosFromService.get(2).getDone(), is(true));
    }

    @Test
    void finishOpenTodo(){
        long id = 4;
        Todo oldTodo = new Todo("title", "description", false);
        oldTodo.setId(id);
        Todo newTodo = new Todo(oldTodo.getTitle(), oldTodo.getDescription(), true);
        newTodo.setId(id);

        when(todoRepository.getOne(id)).thenReturn(oldTodo);
        when(todoRepository.save(oldTodo)).thenReturn(oldTodo);

        Todo actualTodo = todoService.toogleTodoEntry(id);
        assertThat(actualTodo, is(newTodo));
    }

    @Test
    void finishClosedTodo(){
        long id = 4;
        Todo oldTodo = new Todo("title", "description", true);
        oldTodo.setId(id);
        Todo newTodo = new Todo(oldTodo.getTitle(), oldTodo.getDescription(), false);
        newTodo.setId(id);

        when(todoRepository.getOne(id)).thenReturn(oldTodo);
        when(todoRepository.save(oldTodo)).thenReturn(oldTodo);

        Todo actualTodo = todoService.toogleTodoEntry(id);
        assertThat(actualTodo, is(newTodo));
    }
}
