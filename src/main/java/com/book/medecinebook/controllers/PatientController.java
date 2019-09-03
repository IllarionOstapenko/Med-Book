package com.book.medecinebook.controllers;

import com.book.medecinebook.models.CustomResponse;
import com.book.medecinebook.models.Patient;
import com.book.medecinebook.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/create/patient")
    public CustomResponse save(@RequestBody Patient patient) {
        System.out.println(patient);
        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
        patientService.create(patient);
        return new CustomResponse("ok!", true);
    }

    @GetMapping("/patients")

    public List<Patient> patients() {
        System.out.println("Patients works");
        return patientService.findAll();
    }
}
