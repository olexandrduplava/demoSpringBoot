package com.demoSrping.demoSpring.service.impl;

import com.demoSrping.demoSpring.entity.Article;
import com.demoSrping.demoSpring.repository.ArticleRepository;
import com.demoSrping.demoSpring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getAllArticles()
    {
        List<Article> articles = new ArrayList<>();
        articleRepository.findAll().forEach(articles::add);
        return articles;
    }

    public Article getArticleById(Long id)
    {
        return articleRepository.findById(id).get();
    }

    public void saveOrUpdate(Article user)
    {
        articleRepository.save(user);
    }

    public void delete(Long id)
    {
        articleRepository.deleteById(id);
    }

}
