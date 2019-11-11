package com.book.medecinebook.repository;

import com.book.medecinebook.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Patient findByUsername(String username);

    Patient findById(int id);

}

