package com.book.medecinebook.services.impl;

import com.book.medecinebook.repository.UserRepository;
import com.book.medecinebook.models.Doctor;
import com.book.medecinebook.models.User;
import com.book.medecinebook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(User user) {
        if (user != null)
            userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findOneById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username);
    }

    public User authUser() {
        return userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
    }

    @Override
    public List<User> get() {
        return userRepository.findAll();
    }

    @Override
    public List<Doctor> getUsersByName() {
        return userRepository.getUsersByName();
    }



}
