package de.kruemelnerd.todo.backend.controller;

import de.kruemelnerd.todo.backend.controller.TodoController;
import de.kruemelnerd.todo.backend.domain.Todo;
import de.kruemelnerd.todo.backend.repository.TodoService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.http.ContentType.JSON;

public class TestTodoController {

    @Mock
    TodoService todoService;

    @InjectMocks
    TodoController todoController;


    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        RestAssuredMockMvc.standaloneSetup(todoController);
    }

    @Test
    void getAllTodosFromController() {
        List<Todo> allTodo = new ArrayList<Todo>();
        allTodo.add(new Todo("Descriptiontext 1"));
        allTodo.add(new Todo("Descriptiontext 2"));


        Mockito.when(todoService.getAllTodos()).thenReturn(allTodo);

        RestAssuredMockMvc.given()
                .when()
                .get("/getAllTodos")
                .then()
                .log().ifValidationFails()
                .statusCode(HttpStatus.OK.value())
                .contentType(JSON);

/*        RestAssuredMockMvc.given()
                .when()
                .get("/getAllTodos")
                .then()
                .statusCode(HttpStatus.OK.value());
//                .body(hasSize(2));
*/
    }
}
