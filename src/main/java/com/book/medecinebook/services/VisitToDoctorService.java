package com.book.medecinebook.services;

import com.book.medecinebook.models.VisitToDoctor;

import java.time.LocalDate;
import java.util.List;

public interface VisitToDoctorService {
    void create(VisitToDoctor visitToDoctor, int doctorId, int patientId);

    List<VisitToDoctor> findAll();

    List<VisitToDoctor> findAllByPatientId(int id);

    List<VisitToDoctor> findAllByDate(LocalDate date);

    List<VisitToDoctor> findAllByPatientIdAndDateAfter(int id);

    List<VisitToDoctor> findAllByPatientAndDateBefore(int id);

}
