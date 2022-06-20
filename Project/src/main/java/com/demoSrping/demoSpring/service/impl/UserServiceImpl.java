package com.demoSrping.demoSpring.service.impl;

import com.demoSrping.demoSpring.entity.Article;
import com.demoSrping.demoSpring.entity.User;
import com.demoSrping.demoSpring.entity.enums.Color;
import com.demoSrping.demoSpring.repository.ArticleRepository;
import com.demoSrping.demoSpring.repository.UserRepository;
import com.demoSrping.demoSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<User> usersWithAgeHigherThanValue(Integer age) {
        return userRepository.usersWithAgeHigherThanValue(age);
    }

    @Override
    public List<User> usersWithArticleColor(Color color) {
        return userRepository.usersWithArticleColor(color);
    }

    @Override
    public List<String> usersWithMoreThanThreeArticles() {
        return userRepository.usersWithMoreThanThreeArticles();
    }

    @Override
    public List<User> getAllUsers()
    {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUserById(Long id)
    {
         Optional<User> userOptional = userRepository.findById(id);
         if (userOptional.isEmpty()){
             throw new EntityNotFoundException("User with id: " + id + " not exist in db");
         }
        return userOptional.get();
    }

    public User saveOrUpdate(User user)
    {
        for (Article ar: user.getArticles()) {
            Optional<Article> article = articleRepository.findById(ar.getId());
            if(article.isEmpty()){
                throw new EntityNotFoundException("Article: " + ar + " not exist");
            }
        }
       return userRepository.save(user);
    }

    public void delete(Long id)
    {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()){
            throw new EntityNotFoundException("User with id: " + id + " not exist in db");
        }
        userRepository.deleteById(id);
    }

}
