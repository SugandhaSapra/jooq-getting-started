package com.jooq.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jooq.entities.tables.pojos.Book;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @SneakyThrows
    @Test
    void should_get_books() {
        mockMvc
                .perform(get("/books"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").isNotEmpty())
                .andExpect(jsonPath("$[0].title").value("Atomic Habits"));

    }

    @SneakyThrows
    @Test
    void should_be_able_to_add_book() {
        Book book = new Book(2, "Docker", "XYZ");
        String inputInJson = toJson(book);

        mockMvc
                .perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON).content(inputInJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private String toJson(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }
}