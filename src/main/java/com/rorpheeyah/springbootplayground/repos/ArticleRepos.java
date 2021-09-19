package com.rorpheeyah.springbootplayground.repos;

import com.rorpheeyah.springbootplayground.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepos extends JpaRepository<Article, Long> {

}
