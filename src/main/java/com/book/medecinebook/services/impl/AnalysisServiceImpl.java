package com.book.medecinebook.services.impl;

import com.book.medecinebook.models.Analysis;
import com.book.medecinebook.repository.AnalysisRepository;
import com.book.medecinebook.services.AnalysisService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AnalysisServiceImpl implements AnalysisService {

    private final AnalysisRepository analysisRepository;

    @Override
    public void save(Analysis analysis) {
        if (analysis != null)
            analysisRepository.save(analysis);
    }

    @Override
    public List<Analysis> findAll() {
        return analysisRepository.findAll();
    }
}
