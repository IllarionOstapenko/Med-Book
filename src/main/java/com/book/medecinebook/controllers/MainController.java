package com.book.medecinebook.controllers;

import com.book.medecinebook.models.Doctor;
import com.book.medecinebook.models.Patient;
import com.book.medecinebook.models.User;
import com.book.medecinebook.repository.UserRepository;
import com.book.medecinebook.services.PatientService;
import com.book.medecinebook.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")
public class MainController {

    private PatientService patientService;
    private UserService userService;

    @GetMapping("/home")
    public List<Patient> home() {

        System.out.println("Home");
        return patientService.findAll();
    }

    @GetMapping("/authUser")
    public User authUser() {
        System.out.println("Auth USER");
//        this.userService.authUser().setDateOfBirth(userService.authUser().getDateOfBirth().plusDays(1));
        return userService.authUser();
    }

    @GetMapping("/getUsers")
    public List<User> get() {
        System.out.println("GET USERS");
        return userService.get();
    }

    @GetMapping("/get")
    public List<Doctor> some() {
        return userService.getUsersByName();
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {


        return userService.findAll();
    }

}




