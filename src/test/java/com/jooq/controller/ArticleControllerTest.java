package com.jooq.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jooq.entities.Article;
import com.jooq.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class ArticleControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void should_be_able_to_save_article() throws Exception {
        Article article = new Article(UUID.randomUUID(), "title", "Desc", "Body", null);
        String json = toJson(article);
        mockMvc
                .perform(post("/articles").contentType(MediaType.APPLICATION_JSON).content(json))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void should_be_able_to_get_articles() throws Exception {
        Article article = new Article(UUID.randomUUID(), "Java", "Desc", "Body", null);
        articleRepository.save(article);
        mockMvc.perform(get("/articles"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    protected String toJson(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }
}