package com.book.medecinebook.services;

import com.book.medecinebook.enums.Speciality;
import com.book.medecinebook.models.Doctor;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface DoctorService extends UserDetailsService {
    void create(Doctor doctor);

    List<Doctor> findAll();

    Doctor findOneById(Integer id);


    List<Doctor> getAllDoctorsWithSpecialities(String speciality);

    List<Doctor> findBySpeciality(Speciality speciality);
}
