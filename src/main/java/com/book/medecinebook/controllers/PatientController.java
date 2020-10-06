package com.book.medecinebook.controllers;

import com.book.medecinebook.models.CustomResponse;
import com.book.medecinebook.models.Patient;
import com.book.medecinebook.services.PatientService;
import com.book.medecinebook.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/create/patient")
    public CustomResponse save(@RequestBody Patient patient) {
        patientService.create(patient);
        return new CustomResponse("ok!", true);
    }

    @GetMapping("/patients")
    public List<Patient> patients() {
        return patientService.findAll();
    }

    @GetMapping("/patient/username")
    public Patient findPatientByUsername(@RequestParam String username) {
        return patientService.findByUsername(username);
    }

    @GetMapping("/getPatientById&patientId={patientId}")
    public Patient findPatientById(@PathVariable int patientId) {
        return patientService.findById(patientId);
    }

}
