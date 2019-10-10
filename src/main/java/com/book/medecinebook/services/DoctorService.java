package com.book.medecinebook.services;

import com.book.medecinebook.enums.Speciality;
import com.book.medecinebook.models.Doctor;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface DoctorService extends UserDetailsService {
    void create(Doctor doctor);

    List<Doctor> findAll();

    Optional<Doctor> findOneById(Integer id);


    List<Doctor> getAllDoctorsWithSpecialities(String speciality);

    List<Doctor> findBySpeciality(Speciality speciality);
}
