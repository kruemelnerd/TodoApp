package de.kruemelnerd.todo.backend.controller;

import de.kruemelnerd.todo.backend.model.Todo;
import de.kruemelnerd.todo.backend.repository.TodoService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsIterableContaining.hasItems;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {
/*
    @MockBean
    UserService userService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @AfterEach
    public void tearDown() {
        RestAssuredMockMvc.reset();
    }


    @Test
    void secured_api_should_react_with_default(){
    given()
    .when()
    .get("/admin/user/")
    .then()
            .statusCode(HttpStatus.UNAUTHORIZED.value());
    }

    @Test
    public void secured_api_should_give_http_200_when_authorized() {

        given()
                .auth().with(SecurityMockMvcRequestPostProcessors.httpBasic("foo", "bar"))
                .when()
                .get("/admin/todo/")
                .then()
                .statusCode(HttpStatus.OK.value());

    }

    @Test
    void getAllTodosFromController() {
        List<Todo> allTodo = new ArrayList<>();
        allTodo.add(new Todo("Descriptiontext 1"));
        allTodo.add(new Todo("Descriptiontext 2"));


        when(todoService.getAllTodos()).thenReturn(allTodo);

        given()
                .auth().with(SecurityMockMvcRequestPostProcessors.httpBasic("foo", "bar"))
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
        Todo newTodo = new Todo("Testtitle", "Testdescription", true);

        when(todoService.saveTodo(any(Todo.class))).thenReturn(newTodo);

        given()
                .auth().with(SecurityMockMvcRequestPostProcessors.httpBasic("foo", "bar"))
                .contentType(JSON)
                .body(newTodo)
                .post("todo")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .contentType(JSON)
                .body("description", is("Testdescription"))
                .body("title", is("Testtitle"))
                .body("done", is(true))
                .log().ifValidationFails();
    }

    @Test
    void finishAOldTodo(){
        long id = 4;
        Todo newTodo = new Todo("Neuer Title", "Neu Beschreibung", true);
        when(todoService.toogleTodoEntry(id)).thenReturn(newTodo);

        given()
                .auth().with(SecurityMockMvcRequestPostProcessors.httpBasic("foo", "bar"))
                .contentType(JSON)
                .body(id)
                .put("toogleTodo")
                .then()
                .statusCode(HttpStatus.OK.value())
                .contentType(JSON)
                .body("description", is(newTodo.getDescription()))
                .body("title", is(newTodo.getTitle()))
                .body("done", is(newTodo.getDone()))
                .log().ifValidationFails();
    }
*/
}
