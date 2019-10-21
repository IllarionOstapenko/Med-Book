package com.book.medecinebook.repository;

import com.book.medecinebook.models.Doctor;
import com.book.medecinebook.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);

    User findByUsername(String toString);

    //    @Query("select u from User u where u.name like 'name'")
    @Query("select users from Doctor users")
    List<Doctor> getUsersByName();

    List<User> findAll();


}

