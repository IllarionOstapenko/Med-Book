package com.book.medecinebook.controllers;


import com.book.medecinebook.models.CustomResponse;
import com.book.medecinebook.models.Patient;
import com.book.medecinebook.models.ResultOfAnalysis;
import com.book.medecinebook.repository.ResultOfAnalysisRepository;
import com.book.medecinebook.services.PatientService;
import com.book.medecinebook.services.ResultOfAnalysisService;
import com.book.medecinebook.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "*")
@RestController
public class ResultOfAnalysisController {
    private ResultOfAnalysisService resultOfAnalysisService;
    private PatientService patientService;
    private UserService userService;

    private ResultOfAnalysisRepository resultOfAnalysisRepository;

    @PostMapping("/save/resultOfAnalysis")
    public CustomResponse saveResultOfAnalysis(@RequestBody ResultOfAnalysis resultOfAnalysis, @PathVariable int patientId) {
//        transfer this field to service
        resultOfAnalysis.setPatient(patientService.findById(patientId));
        resultOfAnalysisService.save(resultOfAnalysis);
        return new CustomResponse("Result is saved", true);
    }

    @PostMapping("/create/resultOfAnalysis&patientId={patientId}&userId={userId}")
    public CustomResponse createResultOfAnalysis(@RequestBody ResultOfAnalysis resultOfAnalysis,
                                                 @PathVariable int patientId,
                                                 @PathVariable int userId) {
        System.out.println("result works");
        System.out.println(resultOfAnalysis);
        System.out.println(resultOfAnalysis.getAnalysis());
        System.out.println(resultOfAnalysis.getPatient());
        resultOfAnalysisService.create(resultOfAnalysis, patientId, userId);

        return new CustomResponse("Result is created", true);
    }


    @GetMapping("/getAllAnalysisByPatientId&patientId={patientId}")
    public List<ResultOfAnalysis> getAllResultOfAnalysisByPatientId(@PathVariable int patientId) {
        return resultOfAnalysisService.findAllByPatientId(patientId);
    }

    @PostMapping("/getAllByPatientIdAndTitle&patientId={patientId}")
    public List<ResultOfAnalysis> findAllByPatientIdAndAnalysisTitle(@PathVariable int patientId, @RequestBody String title) {
        System.out.println("loxxxxxxxxxx");
        return resultOfAnalysisService.findAllByPatientIdAndAnalyzesTitle(patientId, title);
    }


}
