package com.demoSrping.demoSpring.service;

import com.demoSrping.demoSpring.entity.Article;
import com.demoSrping.demoSpring.entity.User;
import com.demoSrping.demoSpring.entity.enums.Color;
import com.demoSrping.demoSpring.repository.UserRepository;
import com.demoSrping.demoSpring.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;

    private final User user1 = new User();
    private final User user2 = new User();
    private final User user3 = new User();
    private final User user4 = new User();

    private final Article article1 = new Article();
    private final Article article2 = new Article();
    private final Article article3 = new Article();
    private final Article article4 = new Article();
    private final Article article5 = new Article();

    @BeforeEach
    public void init(){
        user1.setName("name1");
        user1.setAge(5);
        user1.setId(1L);

        user2.setName("name2");
        user2.setAge(10);
        user2.setId(2L);

        user3.setName("name3");
        user3.setAge(15);
        user3.setId(3L);

        user4.setName("name4");
        user4.setAge(20);
        user4.setId(4L);

        article1.setId(1L);
        article1.setColor(Color.BLACK);
        article1.setText("Text1");

        article2.setId(2L);
        article2.setColor(Color.WHITE);
        article2.setText("Text2");

        article3.setId(3L);
        article3.setColor(Color.YELLOW);
        article3.setText("Text3");

        article4.setId(4L);
        article4.setColor(Color.RED);
        article4.setText("Text4");

        article5.setId(5L);
        article5.setColor(Color.WHITE);
        article5.setText("Text5");
    }

    @Test
    public void getUserById() {
        User user = new User();
        user.setName("TEST");
        user.setAge(20);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);
        assertNotNull(result);
        assertEquals(user.getId(), result.getId());
        verify(userRepository, times(1)).findById(anyLong());
    }
    @Test
    public void getAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        when(userRepository.findAll()).thenReturn(userList);

        List<User> result = userService.getAllUsers();
        assertNotNull(result);
        assertEquals(userList, result);
    }

    @Test
    public void saveUser() {
        User user = user1;

        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = userService.saveOrUpdate(user);
        assertNotNull(result);
        assertEquals(user.getName(), result.getName());
        assertEquals(user.getAge(), result.getAge());
        verify(userRepository, times(1)).save(user);
    }


}
