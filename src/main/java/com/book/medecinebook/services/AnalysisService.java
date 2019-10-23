package com.book.medecinebook.services;

import com.book.medecinebook.models.Analysis;
import com.book.medecinebook.models.CustomResponse;

import java.util.List;

public interface AnalysisService {
    CustomResponse save(Analysis analysis);

    List<Analysis> findAll();
}
