package com.demoSrping.demoSpring.repository;

import com.demoSrping.demoSpring.entity.User;
import com.demoSrping.demoSpring.entity.enums.Color;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>{

    @Query("SELECT u FROM User u WHERE u.age > :age")
    List<User> usersWithAgeHigherThanValue(@Param("age")Integer age);

    @Query("SELECT u FROM User u Join Article a on a.user = u where a.color = :color")
    List<User> usersWithArticleColor(@Param("color") Color color);

    @Query("SELECT u.name FROM User u where u.articles.size > 3")
    List<String> usersWithMoreThanThreeArticles();

}
