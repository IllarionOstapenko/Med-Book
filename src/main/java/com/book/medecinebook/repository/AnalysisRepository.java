package com.book.medecinebook.repository;

import com.book.medecinebook.models.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AnalysisRepository extends JpaRepository<Analysis, Integer> {

    List<Analysis> findAll();
}
