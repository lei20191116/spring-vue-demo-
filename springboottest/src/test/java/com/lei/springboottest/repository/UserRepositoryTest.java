package com.lei.springboottest.repository;

import com.lei.springboottest.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private  UserRepository userRepository;
    @Test
    void contextLoads(){
        PageRequest pageRequest = PageRequest.of(0,3);
        Page<User> page = userRepository.findAll(pageRequest);

    }
    @Test
    void finAll(){
        System.out.println(userRepository.findAll());
    }
    @Test
    void save(){
        User user = new User();
        user.setName("test");
        user.setPassword("test");
        User user1 = userRepository.save(user);
        System.out.println(user1);
    }
    @Test
    void findById(){
        User user= userRepository.findById(1).get();
        System.out.println(user);
    }
    @Test
    void update(){
        User user = new User();
        user.setId(3);
        user.setName("测试");
        user.setPassword("adb");
        User user1 =userRepository.save(user);
        System.out.println(user1);
    }
    @Test
    void deleteById(){
        userRepository.deleteById(3);
    }
}