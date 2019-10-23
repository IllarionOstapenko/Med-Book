package com.book.medecinebook.repository;

import com.book.medecinebook.models.Patient;
import com.book.medecinebook.models.VisitToDoctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VisitToDoctorRepository extends JpaRepository<VisitToDoctor, Integer> {
    VisitToDoctor findById(int id);

    List<VisitToDoctor> findByPatient(Patient patient);

    List<VisitToDoctor> findAllByPatientId(int id);

    List<VisitToDoctor> findAllByDateOfVisit(LocalDate dateOfVisit);

    List<VisitToDoctor> findAllByPatientIdAndDateOfVisitAfter(int id, LocalDate localDate);

    List<VisitToDoctor> findAllByPatientIdAndDateOfVisitBefore(int id, LocalDate localDate);

    List<VisitToDoctor> findAllByPatientIdAndDateOfVisit(int id, LocalDate localDate);

}
