package com.Online.Marketplace.Online.Marketplace.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Online.Marketplace.Online.Marketplace.model.User;
import com.Online.Marketplace.Online.Marketplace.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping 
    public String createUser(@RequestBody User user) {
        if(userService.getUserByEmail(user.getEmail()) != null) {
            return "User already exists";
        }
        return userService.createUser(user);
    }
    @PutMapping("/{id}")
    public String updateUser(@RequestBody User user){
        return userService.updateUser(user);
    } 
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }
   @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        return userService.deleteUser(id);
    }
    @DeleteMapping()
    public String deleteAllUsers() {
        return userService.deleteAllUsers();
    }
}

