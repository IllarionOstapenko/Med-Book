package com.book.medecinebook.services.impl;

import com.book.medecinebook.models.VisitToDoctor;
import com.book.medecinebook.repository.DoctorRepository;
import com.book.medecinebook.repository.PatientRepository;
import com.book.medecinebook.repository.VisitToDoctorRepository;
import com.book.medecinebook.services.VisitToDoctorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class VisitToDoctorServiceImpl implements VisitToDoctorService {

    private final VisitToDoctorRepository visitToDoctorRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Override
    public void create(VisitToDoctor visitToDoctor, int doctorId, int patientId) {
        visitToDoctor.setDoctor(doctorRepository.findById(doctorId));
        visitToDoctor.setPatient(patientRepository.findById(patientId));
        visitToDoctorRepository.save(visitToDoctor);
    }

    @Override
    public void save(VisitToDoctor visitToDoctor) {
        visitToDoctorRepository.save(visitToDoctor);
    }

    @Override
    public List<VisitToDoctor> findAll() {
        return visitToDoctorRepository.findAll();
    }

    @Override
    public Page<VisitToDoctor> findAll(Pageable pageable) {
        return visitToDoctorRepository.findAll(pageable);
    }

    @Override
    public List<VisitToDoctor> findAllByDoctorId(int id) {
        return visitToDoctorRepository.findAllByDoctorId(id);
    }


    @Override
    public List<VisitToDoctor> findAllByDoctorIdAndDateOfVisit(int id, LocalDate dateOfVisit) {
        return visitToDoctorRepository.findAllByDoctorIdAndDateOfVisit(id, dateOfVisit);
    }

    @Override
    public List<VisitToDoctor> findAllByDoctorIdAndDateOfVisit(int id, VisitToDoctor visitToDoctor) {

        return visitToDoctorRepository.findAllByDoctorIdAndDateOfVisit(id, visitToDoctor.getDateOfVisit());
    }

    @Override
    public VisitToDoctor findById(int id) {
        return visitToDoctorRepository.findById(id);
    }

    @Override
    public List<VisitToDoctor> findAllByPatientIdAndDateAfter(int id) {
        return visitToDoctorRepository.findAllByPatientIdAndDateOfVisitAfterAndConclusionIsNull(id, LocalDate.now().minusDays(1));
    }

    @Override
    public List<VisitToDoctor> findAllByPatientAndDateBefore(int id) {
        return visitToDoctorRepository.findAllByPatientIdAndDateOfVisitBefore(id, LocalDate.now());
    }


    @Override
    public List<VisitToDoctor> findAllByDoctorIdAndDateOfVisitAfter(int id) {
        System.out.println(LocalDate.now());
        return visitToDoctorRepository.findAllByDoctorIdAndDateOfVisitAfter(id, LocalDate.now());
    }
}
