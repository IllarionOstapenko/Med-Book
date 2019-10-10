package com.book.medecinebook.controllers;

import com.book.medecinebook.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/addPhoto")
    public void savePhoto(@RequestParam("image") MultipartFile file) throws IOException {
        imageService.storeFile(file);
    }
}
