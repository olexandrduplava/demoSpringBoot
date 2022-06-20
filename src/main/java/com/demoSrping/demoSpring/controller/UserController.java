package com.demoSrping.demoSpring.controller;

import com.demoSrping.demoSpring.entity.User;
import com.demoSrping.demoSpring.entity.enums.Color;
import com.demoSrping.demoSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    private ResponseEntity<List<User>> getAllUsers()
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    private ResponseEntity<User> getUser(@PathVariable("id") Long id)
    {
        User user = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping()
    private ResponseEntity<Long> saveUser(@RequestBody User user)
    {
        User user1 = userService.saveOrUpdate(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1.getId());
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id)
    {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/getAge/{age}")
    public ResponseEntity<List<User>> getUserHigherAge(@PathVariable("age") Integer age) {
        List<User> users = userService.usersWithAgeHigherThanValue(age);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/getUser/{color}")
    public ResponseEntity<List<User>> getUserWithArticleColor(@PathVariable("color")Color color) {
        List<User> users = userService.usersWithArticleColor(color);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/getWithThree")
    public ResponseEntity<List<String>> getUserWithMoreThanThreeArticles() {
        List<String> users = userService.usersWithMoreThanThreeArticles();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }


}
