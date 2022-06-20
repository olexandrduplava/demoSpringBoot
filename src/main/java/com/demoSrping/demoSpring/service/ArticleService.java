package com.demoSrping.demoSpring.service;

import com.demoSrping.demoSpring.entity.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAllArticles();
    Article getArticleById(Long id);
    void saveOrUpdate(Article article);
    void delete(Long id);

}
