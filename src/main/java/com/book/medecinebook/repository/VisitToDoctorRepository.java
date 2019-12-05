package com.book.medecinebook.repository;

import com.book.medecinebook.models.Patient;
import com.book.medecinebook.models.VisitToDoctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;

public interface VisitToDoctorRepository extends JpaRepository<VisitToDoctor, Integer>,
        PagingAndSortingRepository<VisitToDoctor, Integer> {
    VisitToDoctor findById(int id);

    Page<VisitToDoctor> findAll(Pageable pageable);

    List<VisitToDoctor> findByPatient(Patient patient);

    List<VisitToDoctor> findAllByPatientId(int id);

    List<VisitToDoctor> findAllByPatientId(int id, Pageable pageable);

    List<VisitToDoctor> findAllByDoctorId(int id);

    List<VisitToDoctor> findAllByDateOfVisit(LocalDate dateOfVisit);

    List<VisitToDoctor> findAllByDoctorIdAndDateOfVisit(int id, LocalDate dateOfVisit);

    List<VisitToDoctor> findAllByDoctorIdAndDateOfVisitAfter(int id, LocalDate dateOfVisit);

    List<VisitToDoctor> findAllByPatientIdAndDateOfVisitAfterAndConclusionIsNull(int id, LocalDate localDate);

    List<VisitToDoctor> findAllByPatientIdAndDateOfVisitBefore(int id, LocalDate localDate);

    List<VisitToDoctor> findAllByPatientIdAndDateOfVisit(int id, LocalDate localDate);

}
