package de.kruemelnerd.todo.backend.controller;

import de.kruemelnerd.todo.backend.controller.TodoController;
import de.kruemelnerd.todo.backend.domain.Todo;
import de.kruemelnerd.todo.backend.repository.TodoService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsIterableContaining.hasItems;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoControllerTest {

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
        List<Todo> allTodo = new ArrayList<>();
        allTodo.add(new Todo("Descriptiontext 1"));
        allTodo.add(new Todo("Descriptiontext 2"));


        when(todoService.getAllTodos()).thenReturn(allTodo);

        RestAssuredMockMvc.given()
                .when()
                .get("todo")
                .then()
                .statusCode(HttpStatus.OK.value())
                .contentType(JSON)
                .body("description", hasItems("Descriptiontext 1", "Descriptiontext 2"))
                .log().ifValidationFails();
    }

    @Test
    void saveANewTodo() {
        Todo newTodo = new Todo("Testtitle", "Testdescription");

        when(todoService.saveTodo(any(Todo.class))).thenReturn(newTodo);

        RestAssuredMockMvc.given()
                .contentType(JSON)
                .body(newTodo)
                .post("todo")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .contentType(JSON)
                .body("description", is("Testdescription"))
                .body("title", is("Testtitle"))
                .log().ifValidationFails();

    }
}
