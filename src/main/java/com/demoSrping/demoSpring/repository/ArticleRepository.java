package com.demoSrping.demoSpring.repository;

import com.demoSrping.demoSpring.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
