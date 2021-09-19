package com.rorpheeyah.springbootplayground.services;

import com.rorpheeyah.springbootplayground.models.Article;
import com.rorpheeyah.springbootplayground.models.Main;
import com.rorpheeyah.springbootplayground.repos.ArticleRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
public class ArticleService {

    private final ArticleRepos articleRepos;

    @Autowired
    public ArticleService(ArticleRepos articleRepos) {
        this.articleRepos = articleRepos;
    }

    public Main<Article> getArticles(){
        Main<Article> main = new Main<>();
        main.setApiKey("Article_API_READ");
        main.setData(articleRepos.findAll());
        main.setMessage("OK");
        return main;
    }

    public void addNewArticle(@NonNull Article article){
        articleRepos.save(article);
    }

    @Transactional
    public void updateArticle(Long articleId, String title, String description) {
        Article article = articleRepos.findById(articleId).orElseThrow(() -> new IllegalStateException("Article does not exist."));
        if(title != null && title.length() > 0 && !Objects.equals(article.getTitle(), title)){
            article.setTitle(title);
        }

        if(description != null && description.length() > 0){
            article.setDescription(description);
        }
    }

    public void deleteArticle(Long id) {
        boolean isExist = articleRepos.existsById(id);
        if(!isExist){
            throw new IllegalStateException("Article does not exist.");
        }else{
            articleRepos.deleteById(id);
        }
    }
}
