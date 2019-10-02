package com.book.medecinebook.dao;

import com.book.medecinebook.models.Doctor;
import com.book.medecinebook.models.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorDAO extends JpaRepository<Doctor, Integer> {
    Doctor findByUsername(String username);


    @Query("SELECT spec FROM Doctor spec")
    List<Doctor> findUsersBySpeciality();
}
