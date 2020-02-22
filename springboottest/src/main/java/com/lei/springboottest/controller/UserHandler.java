package com.lei.springboottest.controller;

import com.lei.springboottest.entity.User;
import com.lei.springboottest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/findAll/{page}/{size}")
    public Page<User> findAll(@PathVariable Integer page, @PathVariable Integer size){
        PageRequest request = PageRequest.of(page,size);
        return userRepository.findAll(request);
    }
    @PostMapping("/save")
    public String save(@RequestBody User user){
        User result = userRepository.save(user);
        if (result != null){
            return "success";
        }
        return "error";
    }
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id){
        return  userRepository.findById(id).get();
    }
    @PutMapping("/update")
    public  String update(@RequestBody User user){
        User result = userRepository.save(user);
        if (result != null){
            return "success";
        }
        return "error";
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }
}
