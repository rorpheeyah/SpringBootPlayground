package com.rorpheeyah.springbootplayground.controllers;

import com.rorpheeyah.springbootplayground.models.Article;
import com.rorpheeyah.springbootplayground.models.Main;
import com.rorpheeyah.springbootplayground.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/article")
public class MainController {

    private final ArticleService articleService;

    @Autowired
    public MainController(ArticleService articleService){
        this.articleService = articleService;
    }

    @RequestMapping
    public Main<Article> getArticles(){
        return articleService.getArticles();
    }

    @PostMapping()
    public void addNewArticle(@RequestBody Article article){
        articleService.addNewArticle(article);
    }

    @DeleteMapping(path = "{articleId}")
    public void deleteArticle(@PathVariable("articleId") Long id){
        articleService.deleteArticle(id);
    }

    @PutMapping(path = "{articleId}")
    public void updateArticle(
            @PathVariable("articleId") Long articleId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description){
        articleService.updateArticle(articleId, title, description);
    }
}
