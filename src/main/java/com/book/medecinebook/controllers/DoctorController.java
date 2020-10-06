package com.book.medecinebook.controllers;

import com.book.medecinebook.enums.Speciality;
import com.book.medecinebook.models.CustomResponse;
import com.book.medecinebook.models.Doctor;
import com.book.medecinebook.repository.DoctorRepository;
import com.book.medecinebook.repository.UserRepository;
import com.book.medecinebook.services.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "*")
@RestController
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping("/create/doctor")
    public CustomResponse save(@RequestBody Doctor doctor) {
        doctorService.create(doctor);
        return new CustomResponse("ok!", true);
    }

    @GetMapping("/doctors")
    public List<Doctor> doctors() {
        return doctorService.findAll();
    }

    @GetMapping("/specialities")
    public Speciality[] getSpecialities() {
        return Speciality.values();
    }

    @GetMapping("/doctor/speciality/{speciality}")
    public List<Doctor> getDoctorsBySpeciality(@PathVariable String speciality) {
        System.out.println(speciality);
        return doctorService.findBySpeciality(Speciality.valueOf(speciality));
    }

}
