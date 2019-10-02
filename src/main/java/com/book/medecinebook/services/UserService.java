package com.book.medecinebook.services;

import com.book.medecinebook.models.Doctor;
import com.book.medecinebook.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void create(User user);

    List<User> findAll();

    User findOneById(Integer id);

    User authUser();

    List<User> get();

    List<Doctor> getUsersByName();

}
