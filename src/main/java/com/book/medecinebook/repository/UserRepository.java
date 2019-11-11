package com.book.medecinebook.repository;

import com.book.medecinebook.models.Doctor;
import com.book.medecinebook.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);

    User findByUsername(String username);

    List<User> findAll();

    User findById(int id);


}

