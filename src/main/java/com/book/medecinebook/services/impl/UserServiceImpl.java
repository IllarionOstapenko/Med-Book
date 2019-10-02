package com.book.medecinebook.services.impl;

import com.book.medecinebook.dao.UserDAO;
import com.book.medecinebook.models.Doctor;
import com.book.medecinebook.models.User;
import com.book.medecinebook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public void create(User user) {
        if (user != null)
            userDAO.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findOneById(Integer id) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findUserByUsername(username);
    }

    public User authUser() {
        return userDAO.findByUsername(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
    }

    @Override
    public List<User> get() {
        return userDAO.findAll();
    }

    @Override
    public List<Doctor> getUsersByName() {
        return userDAO.getUsersByName();
    }



}
