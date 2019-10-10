package com.book.medecinebook.controllers;

import com.book.medecinebook.models.CustomResponse;
import com.book.medecinebook.models.Patient;
import com.book.medecinebook.models.VisitToDoctor;
import com.book.medecinebook.services.PatientService;
import com.book.medecinebook.services.UserService;
import com.book.medecinebook.services.VisitToDoctorService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class PatientController {

    private PatientService patientService;
    private UserService userService;
    private VisitToDoctorService visitToDoctorService;


    @PostMapping("/create/patient")
    public CustomResponse save(@RequestBody Patient patient) {
        System.out.println(patient);

        patientService.create(patient);
        return new CustomResponse("ok!", true);
    }

    @GetMapping("/patients")
    public List<Patient> patients() {
        System.out.println("Patients works");
        return patientService.findAll();
    }

    @PostMapping("/test")
    public UserDetails test(@RequestParam String username) {
        System.out.println("test work");
        System.out.println(userService.loadUserByUsername(username));
        return userService.loadUserByUsername(username);
    }



}
