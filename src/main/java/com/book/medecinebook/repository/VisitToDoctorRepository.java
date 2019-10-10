package com.book.medecinebook.repository;

import com.book.medecinebook.models.Patient;
import com.book.medecinebook.models.VisitToDoctor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface VisitToDoctorRepository extends JpaRepository<VisitToDoctor, Integer> {
    List<VisitToDoctor> findByPatient(Patient patient);

    List<VisitToDoctor> findAllByPatientId(int id);

}
