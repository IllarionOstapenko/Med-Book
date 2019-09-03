package com.book.medecinebook.dao;

import com.book.medecinebook.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
    User findUserByUsername(String username);
}
