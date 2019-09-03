package com.book.medecinebook.services.impl;

import com.book.medecinebook.dao.PatientDAO;
import com.book.medecinebook.models.Patient;
import com.book.medecinebook.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientDAO patientDAO;

    @Override
    public void create(Patient patient) {
        if (patient != null) patientDAO.save(patient);
    }

    @Override
    public List<Patient> findAll() {
        return patientDAO.findAll();
    }

    @Override
    public Patient findOneById(Integer id) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return patientDAO.findByUsername(username);
    }
}
