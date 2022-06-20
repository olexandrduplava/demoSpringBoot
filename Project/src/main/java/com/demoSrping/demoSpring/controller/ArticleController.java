package com.demoSrping.demoSpring.controller;

import com.demoSrping.demoSpring.entity.Article;
import com.demoSrping.demoSpring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping()
    private List<Article> getAllArticles()
    {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    private Article getArticle(@PathVariable("id") Long id)
    {
        return articleService.getArticleById(id);
    }

    @PostMapping()
    private Long saveArticle(@RequestBody Article article)
    {
        articleService.saveOrUpdate(article);
        return article.getId();
    }

    @DeleteMapping("/{id}")
    private void deleteArticle(@PathVariable("id") Long id)
    {
        articleService.delete(id);
    }

}
