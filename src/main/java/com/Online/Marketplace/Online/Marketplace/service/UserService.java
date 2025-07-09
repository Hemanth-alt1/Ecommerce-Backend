package com.Online.Marketplace.Online.Marketplace.service;
import com.Online.Marketplace.Online.Marketplace.model.User;

public interface UserService {
    public String createUser(User user);
    public String updateUser(User user);
    public User getUserById(Integer id);
    public User getUserByEmail(String email);
    public String deleteUser(Integer id);
    public String deleteAllUsers();
}
