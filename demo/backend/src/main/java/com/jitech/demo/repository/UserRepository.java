package com.jitech.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jitech.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
