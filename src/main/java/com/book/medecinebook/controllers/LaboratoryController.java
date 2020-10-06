package com.book.medecinebook.controllers;

import com.book.medecinebook.models.CustomResponse;
import com.book.medecinebook.models.Laboratory;
import com.book.medecinebook.services.LaboratoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class LaboratoryController {

    private final LaboratoryService laboratoryService;

    @PostMapping("/create/laboratory")
    public CustomResponse save(@RequestBody Laboratory laboratory) {
        laboratoryService.create(laboratory);
        return new CustomResponse("ok!", true);
    }

    @GetMapping("/laboratories")
    public List<Laboratory> getLaboratories() {
        return laboratoryService.findAll();
    }

}
