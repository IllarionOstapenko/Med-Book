package com.book.medecinebook.services;

import com.book.medecinebook.models.Patient;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface PatientService extends UserDetailsService {
    void create(Patient patient);

    List<Patient> findAll();

    Optional<Patient> findOneById(Integer id);

    Patient findByUsername(String username);
}


