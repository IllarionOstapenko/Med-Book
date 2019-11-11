package com.book.medecinebook.services;

import com.book.medecinebook.models.Laboratory;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface LaboratoryService extends UserDetailsService {
    void create(Laboratory laboratory);

    List<Laboratory> findAll();

}
