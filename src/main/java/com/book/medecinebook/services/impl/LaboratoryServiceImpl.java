package com.book.medecinebook.services.impl;

import com.book.medecinebook.dao.LaboratoryDAO;
import com.book.medecinebook.models.Laboratory;
import com.book.medecinebook.services.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoryServiceImpl implements LaboratoryService {

    @Autowired
    LaboratoryDAO laboratoryDAO;

    @Override
    public void create(Laboratory laboratory) {
        if (laboratory != null) laboratoryDAO.save(laboratory);

    }

    @Override
    public List<Laboratory> findAll() {
        return laboratoryDAO.findAll();
    }

    @Override
    public Laboratory findOneById(Integer id) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return laboratoryDAO.findByUsername(username);
    }
}
