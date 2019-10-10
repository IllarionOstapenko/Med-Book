package com.book.medecinebook.repository;

import com.book.medecinebook.enums.Speciality;
import com.book.medecinebook.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Doctor findByUsername(String username);

    Doctor findById(int integer);

//    @Query("SELECT spec FROM Doctor spec where spec.speciality like :speciality")
//    List<Doctor> findUsersBySpeciality(String speciality);

//    List<Doctor> findAllBySpeciality(String speciality);

    List<Doctor> findBySpeciality(Speciality speciality);

}
