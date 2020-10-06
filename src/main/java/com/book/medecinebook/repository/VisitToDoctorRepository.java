package com.book.medecinebook.repository;

import com.book.medecinebook.models.VisitToDoctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VisitToDoctorRepository extends JpaRepository<VisitToDoctor, Integer> {
    VisitToDoctor findById(int id);

    Page<VisitToDoctor> findAll(Pageable pageable);

    List<VisitToDoctor> findAllByPatientId(int id);

    List<VisitToDoctor> findAllByDoctorId(int id);

    List<VisitToDoctor> findAllByDateOfVisit(LocalDate dateOfVisit);

    List<VisitToDoctor> findAllByDoctorIdAndDateOfVisit(int id, LocalDate dateOfVisit);

    List<VisitToDoctor> findAllByDoctorIdAndDateOfVisitAfter(int id, LocalDate dateOfVisit);

    List<VisitToDoctor> findAllByPatientIdAndDateOfVisitAfterAndConclusionIsNull(int id, LocalDate localDate);

    List<VisitToDoctor> findAllByPatientIdAndDateOfVisitBefore(int id, LocalDate localDate);


}
