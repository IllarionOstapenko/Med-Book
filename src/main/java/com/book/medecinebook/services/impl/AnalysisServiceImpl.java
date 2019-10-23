package com.book.medecinebook.services.impl;

import com.book.medecinebook.models.Analysis;
import com.book.medecinebook.models.CustomResponse;
import com.book.medecinebook.repository.AnalysisRepository;
import com.book.medecinebook.services.AnalysisService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AnalysisServiceImpl implements AnalysisService {

    private AnalysisRepository analysisRepository;

    @Override
    public CustomResponse save(Analysis analysis) {
        if (analysis.getTitle().isEmpty() || analysis.getUnit().isEmpty()) {
            System.out.println(new CustomResponse("DSADSA", true));
            return new CustomResponse("Title is empty", false);
        }
        analysisRepository.save(analysis);
        return new CustomResponse("200OK", true);
    }

    @Override
    public List<Analysis> findAll() {
        return analysisRepository.findAll();
    }
}
