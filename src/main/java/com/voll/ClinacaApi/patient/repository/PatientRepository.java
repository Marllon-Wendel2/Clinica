package com.voll.ClinacaApi.patient.repository;

import com.voll.ClinacaApi.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long>{
}
