package com.book.medecinebook.services.impl;

import com.book.medecinebook.models.VisitToDoctor;
import com.book.medecinebook.repository.DoctorRepository;
import com.book.medecinebook.repository.PatientRepository;
import com.book.medecinebook.repository.VisitToDoctorRepository;
import com.book.medecinebook.services.VisitToDoctorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class VisitToDoctorServiceImpl implements VisitToDoctorService {

    private VisitToDoctorRepository visitToDoctorRepository;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    @Override
    public void create(VisitToDoctor visitToDoctor, int doctorId, int patientId) {
        visitToDoctor.setDoctor(doctorRepository.findById(doctorId));
        visitToDoctor.setPatient(patientRepository.findById(patientId));
        visitToDoctorRepository.save(visitToDoctor);
    }

    @Override
    public List<VisitToDoctor> findAll() {
        return visitToDoctorRepository.findAll();
    }

    @Override
    public List<VisitToDoctor> findAllByPatientId(int id) {
        return visitToDoctorRepository.findAllByPatientId(id);
    }

    public List<VisitToDoctor> findAllByDate(LocalDate date) {
        return visitToDoctorRepository.findAllByDateOfVisit(date);
    }

    @Override
    public List<VisitToDoctor> findAllByPatientIdAndDateAfter(int id) {
        return visitToDoctorRepository.findAllByPatientIdAndDateOfVisitAfter(id, LocalDate.now());
    }

    @Override
    public List<VisitToDoctor> findAllByPatientAndDateBefore(int id) {
        return visitToDoctorRepository.findAllByPatientIdAndDateOfVisitBefore(id, LocalDate.now());
    }


}
