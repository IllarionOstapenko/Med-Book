package com.book.medecinebook.repository;

import com.book.medecinebook.models.ResultOfAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultOfAnalysisRepository extends JpaRepository<ResultOfAnalysis, Integer> {

    ResultOfAnalysis findById(int id);

    List<ResultOfAnalysis> findAllByPatientId(int id);

    List<ResultOfAnalysis> findAllByPatientIdAndAnalysisTitle(int id, String title);

}
