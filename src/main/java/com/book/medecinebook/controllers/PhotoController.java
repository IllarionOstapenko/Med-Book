package com.book.medecinebook.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
public class PhotoController {
    @PostMapping("/create/user/photo")
    public String photo(MultipartFile image) throws IOException {
        image.getOriginalFilename();
        System.out.println(image.getOriginalFilename());
        String path = "D:" + File.separator + "Medecine Angular" + File.separator + "book-ang" + File.separator + "src"
                + File.separator + "assets" + File.separator + "img" + File.separator;
        image.transferTo(new File(path + image.getOriginalFilename()));
        return "";
    }

}
