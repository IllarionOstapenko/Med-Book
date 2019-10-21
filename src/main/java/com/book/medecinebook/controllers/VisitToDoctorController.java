package com.book.medecinebook.controllers;


import com.book.medecinebook.models.CustomResponse;
import com.book.medecinebook.models.VisitToDoctor;
import com.book.medecinebook.repository.VisitToDoctorRepository;
import com.book.medecinebook.services.VisitToDoctorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class VisitToDoctorController {
    private VisitToDoctorService visitToDoctorService;

    private VisitToDoctorRepository visitToDoctorRepository;

    @PostMapping("/create/visit&doctor={doctorId}&patient={patientId}")
    public CustomResponse createVisitToDoctor(@RequestBody VisitToDoctor visitToDoctor, @PathVariable int doctorId, @PathVariable int patientId) {
//        System.out.println(visitToDoctor.getDateOfVisit().plusDays(1));
//        this.localDate = visitToDoctor.getDateOfVisit();
//        System.out.println(visitToDoctor.toDate);
//        System.out.println(localDate.toDate());
        visitToDoctorService.create(visitToDoctor, doctorId, patientId);
        System.out.println("visit to doctor work");
        return new CustomResponse("visit is create", true);
//        return null;
    }

    @GetMapping("/getAllVisits")
    public List<VisitToDoctor> getAllVisits() {
        System.out.println("getAllVisits works");
        return visitToDoctorService.findAll();
    }

    @GetMapping("/getByPatientId&patient={patientId}")
    public List<VisitToDoctor> getByPatientId(@PathVariable int patientId) {
        System.out.println("getByPatient work");
        return visitToDoctorService.findAllByPatientId(patientId);
    }

    @GetMapping("/secondTest")
    public List<VisitToDoctor> secondTest(@RequestBody LocalDate dateOfVisit) {
        return visitToDoctorService.findAllByDate(dateOfVisit);
    }


    @GetMapping("/getAllByPatientIdAndDateAfter&patient={patientId}")
    public List<VisitToDoctor> getAllByPatientIdAndDateAfter(@PathVariable int patientId) {
        System.out.println("getAllByPatientIdAndDateAfter");
        return visitToDoctorService.findAllByPatientIdAndDateAfter(patientId);
    }

    @GetMapping("/getAllByPatientIdAndDateBefore&patient={patientId}")
    public List<VisitToDoctor> getAllByPatientIdAndDateBefore(@PathVariable int patientId) {
        System.out.println("getAllByPatientIdAndDateBefore");
        return visitToDoctorService.findAllByPatientAndDateBefore(patientId);
    }

    @GetMapping("/getAllByDateOfVisits")
    public List<VisitToDoctor> getAllByDateOfVisits() {
        return visitToDoctorRepository.findAllByDateOfVisit(LocalDate.now());
    }

}
