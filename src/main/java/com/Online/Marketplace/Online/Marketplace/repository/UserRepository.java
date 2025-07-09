package com.Online.Marketplace.Online.Marketplace.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Online.Marketplace.Online.Marketplace.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
     User findByEmail(String email);
}
