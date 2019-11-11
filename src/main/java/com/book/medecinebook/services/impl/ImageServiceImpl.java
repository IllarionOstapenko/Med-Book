package com.book.medecinebook.services.impl;

import com.book.medecinebook.services.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {
    @Value("${upload.path:#{null}}")
    private String uploadPath;

    public String storeFile(MultipartFile file) throws IOException {
        BufferedImage image = null;

        try {
            image = ImageIO.read(file.getInputStream());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        if (image != null) {
            final File uploadFolder = new ClassPathResource("static" + File.separator + uploadPath).getFile();
            if (!uploadFolder.exists()) {
                uploadFolder.mkdir();
            }
            final File targetFile = new File(uploadFolder.getAbsolutePath() + File.separator + file.getOriginalFilename());
            targetFile.createNewFile();
            file.transferTo(targetFile);
            return file.getOriginalFilename();
        } else {
            return null;
        }
    }
}
