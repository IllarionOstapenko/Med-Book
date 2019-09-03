package com.book.medecinebook.dao;

import com.book.medecinebook.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface DoctorDAO extends JpaRepository<Doctor, Integer> {
    Doctor findByUsername(String username);
}
