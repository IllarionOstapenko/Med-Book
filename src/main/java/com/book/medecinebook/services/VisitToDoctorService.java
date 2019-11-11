package com.book.medecinebook.services;

import com.book.medecinebook.models.VisitToDoctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface VisitToDoctorService {
    void create(VisitToDoctor visitToDoctor, int doctorId, int patientId);

    void save(VisitToDoctor visitToDoctor);

    List<VisitToDoctor> findAll();

    Page<VisitToDoctor> findAll(Pageable pageable);

    VisitToDoctor findById(int id);

    List<VisitToDoctor> findAllByPatientId(int id);

    List<VisitToDoctor> findAllByDoctorId(int id);

    List<VisitToDoctor> findAllByDate(LocalDate date);

    List<VisitToDoctor> findAllByDoctorIdAndDateOfVisit(int id, LocalDate dateOfVisit);

    List<VisitToDoctor> findAllByPatientIdAndDateAfter(int id);

    List<VisitToDoctor> findAllByPatientAndDateBefore(int id);


}
