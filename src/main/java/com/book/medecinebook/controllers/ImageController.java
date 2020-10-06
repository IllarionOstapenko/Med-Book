package com.book.medecinebook.controllers;

import com.book.medecinebook.services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/addPhoto")
    public void savePhoto(@RequestParam("image") MultipartFile file) throws IOException {
        imageService.storeFile(file);
    }
}
