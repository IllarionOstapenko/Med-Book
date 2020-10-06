package com.book.medecinebook.services.impl;

import com.book.medecinebook.models.Analysis;
import com.book.medecinebook.models.ResultOfAnalysis;
import com.book.medecinebook.repository.AnalysisRepository;
import com.book.medecinebook.repository.PatientRepository;
import com.book.medecinebook.repository.ResultOfAnalysisRepository;
import com.book.medecinebook.repository.UserRepository;
import com.book.medecinebook.services.ResultOfAnalysisService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class ResultOfAnalysisServiceImpl implements ResultOfAnalysisService {
    private  final ResultOfAnalysisRepository resultOfAnalysisRepository;
    private final AnalysisRepository analysisRepository;
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;

    @Override
    public void save(ResultOfAnalysis resultOfAnalysis) {
        resultOfAnalysis.setAnalysis(analysisRepository.getOne(1));
        resultOfAnalysis.setPatient(patientRepository.findById(1));
        resultOfAnalysis.setUser(userRepository.findById(2));
        resultOfAnalysis.setLocalDateTime(LocalDateTime.now());
        resultOfAnalysisRepository.save(resultOfAnalysis);
    }

    @Override
    public void create(ResultOfAnalysis resultOfAnalysis, int patientId, int userId) {
        final Analysis analysisId = analysisRepository.findById(resultOfAnalysis.getAnalysis().getId());
        resultOfAnalysis.setPatient(patientRepository.findById(patientId));
        resultOfAnalysis.setUser(userRepository.findById(userId));
        resultOfAnalysis.setLocalDateTime(LocalDateTime.now());
        resultOfAnalysis.setAnalysis(analysisId);
        resultOfAnalysis.setResult(resultOfAnalysis.getResult());
        resultOfAnalysisRepository.save(resultOfAnalysis);
    }

    @Override
    public List<ResultOfAnalysis> findAllByPatientId(int id) {
        return resultOfAnalysisRepository.findAllByPatientId(id);
    }

    @Override
    public List<ResultOfAnalysis> findAllByPatientIdAndAnalyzesTitle(int id, String title) {
        return resultOfAnalysisRepository.findAllByPatientIdAndAnalysisTitle(id, title);
    }
}
