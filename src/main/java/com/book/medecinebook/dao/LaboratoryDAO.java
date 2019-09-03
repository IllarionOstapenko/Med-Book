package com.book.medecinebook.dao;

import com.book.medecinebook.models.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratoryDAO extends JpaRepository<Laboratory, Integer> {
    Laboratory findByUsername(String username);
}
