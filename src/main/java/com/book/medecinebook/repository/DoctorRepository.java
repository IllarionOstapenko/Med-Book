package com.book.medecinebook.repository;

import com.book.medecinebook.enums.Speciality;
import com.book.medecinebook.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Doctor findByUsername(String username);

    Doctor findById(int integer);

    List<Doctor> findBySpeciality(Speciality speciality);

}
