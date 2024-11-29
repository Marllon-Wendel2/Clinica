package com.voll.ClinacaApi.patient.controller;

import com.voll.ClinacaApi.patient.dtos.DataListPatient;
import com.voll.ClinacaApi.patient.dtos.DataUpadatePatient;
import com.voll.ClinacaApi.patient.dtos.PatientData;
import com.voll.ClinacaApi.patient.model.Patient;
import com.voll.ClinacaApi.patient.repository.PatientRepository;
import jakarta.validation.Valid;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    public void register(@RequestBody @Valid PatientData patientData) {
        repository.save(new Patient(patientData));
    }

    @GetMapping
    public ResponseEntity<?> listing(@PageableDefault(size = 10, sort = {"nome"})Pageable pag) {
        var page = repository.findAll().stream()
                .map(DataListPatient::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updatePatient(@RequestBody @Valid DataUpadatePatient data) {
        var patient = repository.getReferenceById(data.id());
        patient.updateInformation(data);

        return ResponseEntity.ok("Atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePatient(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);
        patient.deletePatient();

        return ResponseEntity.noContent().build();
    }
}
