package com.book.medecinebook.repository;

import com.book.medecinebook.models.ResultOfAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultOfAnalysisRepository extends JpaRepository<ResultOfAnalysis, Integer> {

    List<ResultOfAnalysis> findAllByPatientId(int id);

}
