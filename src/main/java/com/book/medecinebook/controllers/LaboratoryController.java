package com.book.medecinebook.controllers;

import com.book.medecinebook.models.CustomResponse;
import com.book.medecinebook.models.Laboratory;
import com.book.medecinebook.services.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class LaboratoryController {

    @Autowired
    LaboratoryService laboratoryService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/create/laboratory")
    public CustomResponse save(@RequestBody Laboratory laboratory) {
        System.out.println(laboratory);
        laboratory.setPassword(passwordEncoder.encode(laboratory.getPassword()));
        laboratoryService.create(laboratory);
        System.out.println(laboratory.getAuthorities());
        return new CustomResponse("ok!", true);
    }

    @GetMapping("/laboratories")
    public List<Laboratory> getLaboratories() {
        return laboratoryService.findAll();
    }

}
