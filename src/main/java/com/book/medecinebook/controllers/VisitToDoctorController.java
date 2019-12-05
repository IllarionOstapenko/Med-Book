package com.book.medecinebook.controllers;


import com.book.medecinebook.models.CustomResponse;
import com.book.medecinebook.models.VisitToDoctor;
import com.book.medecinebook.repository.VisitToDoctorRepository;
import com.book.medecinebook.services.VisitToDoctorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
        visitToDoctorService.create(visitToDoctor, doctorId, patientId);
        System.out.println("visit to doctor work");
        return new CustomResponse("visit is create", true);
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

    @GetMapping("/getAllByDoctorId&doctorId={doctorId}")
    public List<VisitToDoctor> getByDoctorId(@PathVariable int doctorId) {
        return visitToDoctorService.findAllByDoctorId(doctorId);
    }

    @PostMapping("/secondTest")
    public List<VisitToDoctor> secondTest(@RequestBody LocalDate dateOfVisit) {
        System.out.println(dateOfVisit);

        return visitToDoctorService.findAllByDate(dateOfVisit);
    }

    @PostMapping("/thirdTest&doctorId={doctorId}")
    public List<VisitToDoctor> thirdTest(@PathVariable int doctorId, @RequestBody LocalDate date) {
        System.out.println(doctorId);
        System.out.println(date);
        return visitToDoctorService.findAllByDoctorIdAndDateOfVisit(doctorId, date);
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

    @GetMapping("/getAllByDoctorIdAndDateOfVisits&doctorId={doctorId}")
    public List<VisitToDoctor> getAllByDoctorIdAndDateOfVisits(@PathVariable int doctorId) {
        System.out.println("doctorId");
        return visitToDoctorService.findAllByDoctorIdAndDateOfVisit(doctorId, LocalDate.now());
    }

    @PostMapping("/conclusion&visitId={visitId}")
    public CustomResponse saveConclusion(@RequestBody String conclusion, @PathVariable int visitId) {
        final VisitToDoctor byId = visitToDoctorService.findById(visitId);
        byId.setConclusion(conclusion);
        System.out.println(conclusion);
        System.out.println(visitId);
        visitToDoctorService.save(byId);
        return new CustomResponse("conclusion saved", true);
    }

//
//    @GetMapping("/visitToDoctor")
//    public Page<VisitToDoctor> find(Pageable pageable) {
//        System.out.println("visitToDoctor worksdsdasdas");
//        return visitToDoctorService.findAll(pageable);
//    }

    @GetMapping("/visitToDoctor")
    public List<VisitToDoctor> list() {
        System.out.println("BLALlasl");
        return visitToDoctorRepository.findAll();
    }

    @GetMapping("/visits&page={page}&size={size}")
    public Page<VisitToDoctor> test(@PathVariable int page, @PathVariable int size) {
        Pageable firs = PageRequest.of(page, size);
        System.out.println("VISITS WORKING");
        System.out.println(page);
        System.out.println(size);
//        System.out.println(pageable);
        return visitToDoctorRepository.findAll(firs);
    }


    @GetMapping("/visitToDoctor&doctorId={doctorId}")
    public List<VisitToDoctor> findByDoctorIdAndDateAfter(@PathVariable int doctorId) {
        System.out.println("visits working ");
        return visitToDoctorService.findAllByDoctorIdAndDateOfVisitAfter(doctorId);
    }


    @PostMapping("/fourthTest&doctorId={doctorId}")
    public List<VisitToDoctor> thirdTest(@PathVariable int doctorId, @RequestBody VisitToDoctor visitToDoctor) {
        System.out.println(doctorId);
        System.out.println(visitToDoctor);
        return visitToDoctorService.findAllByDoctorIdAndDateOfVisit(doctorId, visitToDoctor);
    }


}
