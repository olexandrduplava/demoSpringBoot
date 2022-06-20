package com.demoSrping.demoSpring.service.impl;

import com.demoSrping.demoSpring.entity.User;
import com.demoSrping.demoSpring.entity.enums.Color;
import com.demoSrping.demoSpring.repository.UserRepository;
import com.demoSrping.demoSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

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
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
    }

    public User getUserById(Long id)
    {
        return userRepository.findById(id).get();
    }

    public User saveOrUpdate(User user)
    {
       return userRepository.save(user);
    }

    public void delete(Long id)
    {
        userRepository.deleteById(id);
    }

}
