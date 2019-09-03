package com.book.medecinebook.services.impl;

import com.book.medecinebook.dao.DoctorDAO;
import com.book.medecinebook.models.Doctor;
import com.book.medecinebook.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorDAO doctorDAO;

    @Override
    public void create(Doctor doctor) { if (doctor != null) doctorDAO.save(doctor); }

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
}
