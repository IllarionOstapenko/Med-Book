package com.book.medecinebook.services;

import com.book.medecinebook.models.Patient;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface PatientService extends UserDetailsService {

    void create(Patient patient);

    Patient findById(int id);

    List<Patient> findAll();

    Patient findByUsername(String username);
}


