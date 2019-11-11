package com.book.medecinebook.services.impl;

import com.book.medecinebook.enums.Speciality;
import com.book.medecinebook.models.Doctor;
import com.book.medecinebook.repository.DoctorRepository;
import com.book.medecinebook.services.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DoctorServiceImpl implements DoctorService {
    private DoctorRepository doctorRepository;
    private PasswordEncoder passwordEncoder;


    @Override
    public void create(Doctor doctor) {

        if (doctor != null)
            doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return doctorRepository.findByUsername(username);
    }

    @Override
    public List<Doctor> findBySpeciality(Speciality speciality) {
        return doctorRepository.findBySpeciality(speciality);
    }
}
