package com.demoSrping.demoSpring.service;

import com.demoSrping.demoSpring.entity.User;
import com.demoSrping.demoSpring.entity.enums.Color;

import java.util.List;

public interface UserService {

    List<User> usersWithAgeHigherThanValue(Integer age);
    List<User> usersWithArticleColor(Color color);
    List<String> usersWithMoreThanThreeArticles();

    List<User> getAllUsers();
    User getUserById(Long id);
    User saveOrUpdate(User user);
    void delete(Long id);

}
