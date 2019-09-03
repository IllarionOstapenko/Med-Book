package com.book.medecinebook.dao;

import com.book.medecinebook.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface PatientDAO extends JpaRepository<Patient, Integer> {
    Patient findByUsername(String username);
}
