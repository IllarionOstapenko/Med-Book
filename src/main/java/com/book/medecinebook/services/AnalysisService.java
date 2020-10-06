package com.book.medecinebook.services;

import com.book.medecinebook.models.Analysis;

import java.util.List;

public interface AnalysisService {
    
    void save(Analysis analysis);

    List<Analysis> findAll();
}
