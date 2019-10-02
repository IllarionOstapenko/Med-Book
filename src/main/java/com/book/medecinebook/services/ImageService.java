package com.book.medecinebook.services;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface ImageService {
    String storeFile(MultipartFile file) throws IOException;
}
