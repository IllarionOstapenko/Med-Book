package com.book.medecinebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedecineBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedecineBookApplication.class, args);
        System.out.println(System.getProperty("user.dir"));

    }
}
