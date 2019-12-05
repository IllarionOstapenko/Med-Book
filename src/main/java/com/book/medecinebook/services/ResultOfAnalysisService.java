package com.book.medecinebook.services;

import com.book.medecinebook.models.Analysis;
import com.book.medecinebook.models.ResultOfAnalysis;

import java.util.List;

public interface ResultOfAnalysisService {

    void save(ResultOfAnalysis resultOfAnalysis);

    void create(ResultOfAnalysis resultOfAnalysis, int patientId, int userId);

    List<ResultOfAnalysis> findAllByPatientId(int id);

    List<ResultOfAnalysis> findAllByPatientIdAndAnalyzesTitle(int id, String title);
}
