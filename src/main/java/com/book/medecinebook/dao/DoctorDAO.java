package com.book.medecinebook.dao;

import com.book.medecinebook.enums.Speciality;
import com.book.medecinebook.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorDAO extends JpaRepository<Doctor, Integer> {
    Doctor findByUsername(String username);


//    @Query("SELECT spec FROM Doctor spec where spec.speciality like :speciality")
//    List<Doctor> findUsersBySpeciality(String speciality);

//    List<Doctor> findAllBySpeciality(String speciality);

    List<Doctor> findBySpeciality(Speciality speciality);

}
