package com.book.medecinebook.services.impl;

import com.book.medecinebook.repository.LaboratoryRepository;
import com.book.medecinebook.models.Laboratory;
import com.book.medecinebook.services.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoryServiceImpl implements LaboratoryService {

    @Autowired
    private LaboratoryRepository laboratoryRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void create(Laboratory laboratory) {
        if (laboratory != null)
            laboratory.setPassword(passwordEncoder.encode(laboratory.getPassword()));

        laboratoryRepository.save(laboratory);

    }

    @Override
    public List<Laboratory> findAll() {
        return laboratoryRepository.findAll();
    }

    @Override
    public Laboratory findOneById(Integer id) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return laboratoryRepository.findByUsername(username);
    }
}
