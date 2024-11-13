package com.voll.ClinacaApi.patient.controller;

import com.voll.ClinacaApi.patient.dtos.PatientData;
import com.voll.ClinacaApi.patient.model.Patient;
import com.voll.ClinacaApi.patient.repository.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    public void register(@RequestBody @Valid PatientData patientData) {
        repository.save(new Patient(patientData));
    }
}
