package com.book.medecinebook.services;

import com.book.medecinebook.models.ResultOfAnalysis;

import java.util.List;

public interface ResultOfAnalysisService {

    void save(ResultOfAnalysis resultOfAnalysis);

    List<ResultOfAnalysis> findAllByPatientId(int id);
}
