package com.tulesko.SpringSecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tulesko.SpringSecurity.model.User;
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
