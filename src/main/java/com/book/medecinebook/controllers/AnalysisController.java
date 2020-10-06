package com.book.medecinebook.controllers;

import com.book.medecinebook.models.Analysis;
import com.book.medecinebook.models.CustomResponse;
import com.book.medecinebook.services.AnalysisService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
public class AnalysisController {

    private final AnalysisService analysisService;

    @PostMapping("/save/analysis")
    public CustomResponse save(@RequestBody Analysis analysis) {
        analysisService.save(analysis);
        return new CustomResponse("Save analysis", true);
    }

    @GetMapping("/getAllAnalysis")
    public List<Analysis> findAllAnalysis() {
        return analysisService.findAll();
    }
}
