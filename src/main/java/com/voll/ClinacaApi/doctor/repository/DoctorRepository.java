package com.voll.ClinacaApi.doctor.repository;

import com.voll.ClinacaApi.doctor.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
