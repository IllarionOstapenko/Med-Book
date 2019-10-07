package com.book.medecinebook.services.impl;

import com.book.medecinebook.enums.Speciality;
import com.book.medecinebook.dao.DoctorDAO;
import com.book.medecinebook.models.Doctor;
import com.book.medecinebook.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorDAO doctorDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void create(Doctor doctor) {

        if (doctor != null)
            doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        doctorDAO.save(doctor);
    }

    @Override
    public List<Doctor> findAll() {

        return doctorDAO.findAll();
    }

    @Override
    public Doctor findOneById(Integer id) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return doctorDAO.findByUsername(username);
    }

    @Override
    public List<Doctor> getAllDoctorsWithSpecialities(String speciality) {
        return null;
    }

    @Override
    public List<Doctor> findBySpeciality(Speciality speciality) {
        return doctorDAO.findBySpeciality(speciality);
    }
}
