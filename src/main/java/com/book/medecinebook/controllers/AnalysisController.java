package com.book.medecinebook.controllers;

import com.book.medecinebook.models.Analysis;
import com.book.medecinebook.models.CustomResponse;
import com.book.medecinebook.services.AnalysisService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
public class AnalysisController {
    private AnalysisService analysisService;

    @PostMapping("/save/analysis")
    public void save(@RequestBody Analysis analysis) {
        analysisService.save(analysis);
//        return new CustomResponse("Save analysis", true);
    }
}
