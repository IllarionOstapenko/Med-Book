package com.book.medecinebook.controllers;

import com.book.medecinebook.models.CustomResponse;
import com.book.medecinebook.models.Doctor;
import com.book.medecinebook.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/create/doctor")
    public CustomResponse save(@RequestBody Doctor doctor) {
        System.out.println(doctor);
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        doctorService.create(doctor);
        System.out.println(doctor.getAuthorities());
        return new CustomResponse("ok!", true);
    }

    @GetMapping("/doctors")
    public List<Doctor> patients() {
        return doctorService.findAll();
    }



}
