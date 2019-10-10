package com.book.medecinebook.controllers;

import com.book.medecinebook.enums.Speciality;
import com.book.medecinebook.repository.DoctorRepository;
import com.book.medecinebook.models.CustomResponse;
import com.book.medecinebook.models.Doctor;
import com.book.medecinebook.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/create/doctor")
    public CustomResponse save(@RequestBody Doctor doctor) {
        System.out.println(doctor);
        doctorService.create(doctor);
        System.out.println(doctor.getAuthorities());
        return new CustomResponse("ok!", true);
    }

    @GetMapping("/doctors")
    public List<Doctor> patients() {
        return doctorService.findAll();
    }


    @GetMapping("/specialities")
    public Speciality[] getSpecialities() {
        return Speciality.values();
    }

    @GetMapping("/doctor/speciality/{speciality}")
    public List<Doctor> getDoctorsBySpeciality(@PathVariable String speciality) {
        return doctorService.findBySpeciality(Speciality.valueOf(speciality));
    }

}
