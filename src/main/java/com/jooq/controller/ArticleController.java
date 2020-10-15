package com.jooq.controller;

import com.jooq.entities.Article;
import com.jooq.entities.ArticleTitle;
import com.jooq.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping
    public void saveArticle(@RequestBody Article article) {
        articleService.saveArticle(article);

    }

    @GetMapping
    public ResponseEntity<List<ArticleTitle>> searchArticleByTitle(@RequestParam("title") String title) {
        return ResponseEntity.ok(articleService.searchArticleByTitleWithComments(title));
    }
}
