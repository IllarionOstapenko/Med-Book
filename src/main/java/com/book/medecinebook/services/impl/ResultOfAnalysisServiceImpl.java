package com.book.medecinebook.services.impl;

import com.book.medecinebook.models.ResultOfAnalysis;
import com.book.medecinebook.repository.ResultOfAnalysisRepository;
import com.book.medecinebook.services.ResultOfAnalysisService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ResultOfAnalysisServiceImpl implements ResultOfAnalysisService {
    private ResultOfAnalysisRepository resultOfAnalysisRepository;

    @Override
    public void save(ResultOfAnalysis resultOfAnalysis) {
        resultOfAnalysisRepository.save(resultOfAnalysis);
    }

    @Override
    public List<ResultOfAnalysis> findAllByPatientId(int id) {
        return resultOfAnalysisRepository.findAllByPatientId(id);
    }
}
