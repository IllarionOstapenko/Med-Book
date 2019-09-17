package com.book.medecinebook.controllers;

import com.book.medecinebook.models.User;
import com.book.medecinebook.services.UserService;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PhotoController {

    @Autowired
    private UserService userService;

    @PostMapping("/create/user/photo")
    public void photo(MultipartFile image) throws IOException {
        image.getOriginalFilename();
        System.out.println(image.getOriginalFilename());

        /** save photo in assets/image in angular */

//        String path = "D:" + File.separator + "Medecine Angular" + File.separator + "book-ang" + File.separator + "src"
//                + File.separator + "assets" + File.separator + "img" + File.separator;
//        image.transferTo(new File(path + image.getOriginalFilename()));
//        return "";
//

        /** save photo in src/image in spring*/

        String path = "D:" + File.separator + "Medecine Spring" + File.separator +
                "medecine-book" + File.separator + "src" + File.separator + "image" + File.separator;
        image.transferTo(new File(path + image.getOriginalFilename()));

        /** save photo in resources/static in spring*/

//        String path = "D:" + File.separator + "Medecine Spring" + File.separator +
//                "medecine-book" + File.separator + "src" + File.separator + "main" +
//                File.separator + "resources" + File.separator + "static" + File.separator;
//        image.transferTo(new File(path + image.getOriginalFilename()));
    }


}

