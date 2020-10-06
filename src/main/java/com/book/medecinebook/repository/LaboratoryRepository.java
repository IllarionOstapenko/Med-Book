package com.book.medecinebook.repository;

import com.book.medecinebook.models.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratoryRepository extends JpaRepository<Laboratory, Integer> {

    Laboratory findByUsername(String username);
}
