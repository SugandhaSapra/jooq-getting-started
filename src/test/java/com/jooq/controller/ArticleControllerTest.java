package com.jooq.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jooq.entities.Article;
import com.jooq.entities.Comment;
import com.jooq.repository.ArticleRepository;
import com.jooq.repository.CommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
    @Autowired
    private CommentRepository commentRepository;

    @BeforeEach
    void setUp() {
        articleRepository.deleteAll();
    }

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
        initJavaArticleWithComment();
        mockMvc.perform(get("/articles")
                .param("title", "Java"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Java -JDK-15"));

    }


    protected String toJson(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }

    private void initJavaArticleWithComment() {
        Article article = Article.builder()
                .id(UUID.randomUUID())
                .title("Java -JDK-15")
                .description("New features revealed")
                .body("The Arrival of Java 15 brings in Records")
                .build();
        Article savedArticle = articleRepository.save(article);
        Comment comment = Comment.builder()
                .body("Nice Article")
                .createdAt(new Date())
                .article(savedArticle)
                .build();
        commentRepository.save(comment);
    }
}