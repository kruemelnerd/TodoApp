package de.kruemelnerd.todo.backend.controller;

import de.kruemelnerd.todo.backend.model.Todo;
import de.kruemelnerd.todo.backend.repository.TodoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@WithMockUser(username="test",roles={"USER","ADMIN"})
class TodoControllerITTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TodoService todoService;

    @Test
    void getAllTodosFromController() throws Exception {
        List<Todo> allTodo = new ArrayList<>();
        allTodo.add(new Todo("Descriptiontext 1"));
        allTodo.add(new Todo("Descriptiontext 2"));


        Mockito.when(todoService.getAllTodos()).thenReturn(allTodo);

        mockMvc.perform(MockMvcRequestBuilders.get("/todo").contentType(MediaType.APPLICATION_JSON)) //
                .andExpect(jsonPath("$", hasSize(2))) //
                .andDo(print());

    }
}
