package com.rorpheeyah.springbootplayground.config;

import com.rorpheeyah.springbootplayground.models.Article;
import com.rorpheeyah.springbootplayground.repos.ArticleRepos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ArticleConfig {

    @Bean
    CommandLineRunner commandLineRunner(ArticleRepos articleRepos){
        return args -> {

            Article article = new Article("Spirited Away", "Spirited Away tells the story of Chihiro Ogino (Hiiragi), " +
                    "a 10-year-old girl who, while moving to a new neighbourhood, enters the world of Kami(spirits of " +
                    "Japanese Shinto folklore).", LocalDate.of(2001, Month.JULY,20));

            Article article1 = new Article("My Neighbor Totoro", "My Neighbor Totoro is a 1988 Japanese animated fantasy" +
                    " film written and directed by Hayao Miyazaki and animated by Studio Ghibli for Tokuma Shoten.",
                    LocalDate.of(1988, Month.APRIL,16));

            articleRepos.saveAll(List.of(article, article1));
        };
    }
}
