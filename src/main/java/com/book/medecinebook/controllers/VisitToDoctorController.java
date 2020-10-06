package com.book.medecinebook.controllers;


import com.book.medecinebook.models.CustomResponse;
import com.book.medecinebook.models.VisitToDoctor;
import com.book.medecinebook.services.VisitToDoctorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class VisitToDoctorController {

    private final VisitToDoctorService visitToDoctorService;

    @PostMapping("/create/visit&doctor={doctorId}&patient={patientId}")
    public CustomResponse createVisitToDoctor(@RequestBody VisitToDoctor visitToDoctor, @PathVariable int doctorId, @PathVariable int patientId) {
        visitToDoctorService.create(visitToDoctor, doctorId, patientId);
        return new CustomResponse("visit is create", true);
    }

    @GetMapping("/getAllByDoctorId&doctorId={doctorId}")
    public List<VisitToDoctor> getByDoctorId(@PathVariable int doctorId) {
        return visitToDoctorService.findAllByDoctorId(doctorId);
    }


    @GetMapping("/getAllByPatientIdAndDateAfter&patient={patientId}")
    public List<VisitToDoctor> getAllByPatientIdAndDateAfter(@PathVariable int patientId) {
        return visitToDoctorService.findAllByPatientIdAndDateAfter(patientId);
    }

    @GetMapping("/getAllByPatientIdAndDateBefore&patient={patientId}")
    public List<VisitToDoctor> getAllByPatientIdAndDateBefore(@PathVariable int patientId) {
        return visitToDoctorService.findAllByPatientAndDateBefore(patientId);
    }

    @GetMapping("/getAllByDoctorIdAndDateOfVisits&doctorId={doctorId}")
    public List<VisitToDoctor> getAllByDoctorIdAndDateOfVisits(@PathVariable int doctorId) {
        return visitToDoctorService.findAllByDoctorIdAndDateOfVisit(doctorId, LocalDate.now());
    }

    @PostMapping("/conclusion&visitId={visitId}")
    public CustomResponse saveConclusion(@RequestBody String conclusion, @PathVariable int visitId) {
        final VisitToDoctor byId = visitToDoctorService.findById(visitId);
        byId.setConclusion(conclusion);
        visitToDoctorService.save(byId);
        return new CustomResponse("conclusion saved", true);
    }

    @GetMapping("/visitToDoctor")
    public List<VisitToDoctor> list() {
        return visitToDoctorService.findAll();
    }

    @GetMapping("/visits&page={page}&size={size}")
    public Page<VisitToDoctor> test(@PathVariable int page, @PathVariable int size) {
        Pageable firs = PageRequest.of(page, size);
        return visitToDoctorService.findAll(firs);
    }

    @GetMapping("/visitToDoctor&doctorId={doctorId}")
    public List<VisitToDoctor> findByDoctorIdAndDateAfter(@PathVariable int doctorId) {
        return visitToDoctorService.findAllByDoctorIdAndDateOfVisitAfter(doctorId);
    }

    @PostMapping("/fourthTest&doctorId={doctorId}")
    public List<VisitToDoctor> thirdTest(@PathVariable int doctorId, @RequestBody VisitToDoctor visitToDoctor) {
        return visitToDoctorService.findAllByDoctorIdAndDateOfVisit(doctorId, visitToDoctor);
    }

    @PostMapping("/findAllByDate&doctorId={doctorId}")
    public List<VisitToDoctor> thirdTest(@PathVariable int doctorId, @RequestBody LocalDate date) {
        return visitToDoctorService.findAllByDoctorIdAndDateOfVisit(doctorId, date);
    }

}
