package com.book.medecinebook.controllers;

import com.book.medecinebook.models.Doctor;
import com.book.medecinebook.models.Patient;
import com.book.medecinebook.models.Speciality;
import com.book.medecinebook.models.User;
import com.book.medecinebook.services.PatientService;
import com.book.medecinebook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MainController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/home")
    public List<Patient> home() {

        System.out.println("Home");
        return patientService.findAll();
    }

    @GetMapping("/authUser")
    public User authUser() {
        return userService.authUser();
    }

    @GetMapping("/getUsers")
    public List<User> get() {
        return userService.get();
    }

    @GetMapping("/get")
    public List<Doctor> some() {
        return userService.getUsersByName();
    }




}




