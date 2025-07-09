package com.Online.Marketplace.Online.Marketplace.service.impl;

import org.springframework.stereotype.Service;

import com.Online.Marketplace.Online.Marketplace.model.User;
import com.Online.Marketplace.Online.Marketplace.repository.UserRepository;
import com.Online.Marketplace.Online.Marketplace.service.UserService;
@Service
public class UserServiceimpl implements UserService {
    
    UserRepository userRepository;
    
    public UserServiceimpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
     public String createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "User already exists";
        }
        userRepository.save(user);
        return "User created successfully";
    }

    @Override
    public String updateUser(User user) {
        userRepository.save(user);
        return "User updated successfully";
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteUser(Integer id) {
        userRepository.deleteById(id);
        return "User deleted successfully";
    }

    @Override
    public String deleteAllUsers() {
        userRepository.deleteAll();
        return "All users deleted successfully";
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    

}