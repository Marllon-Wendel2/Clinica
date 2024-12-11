package com.voll.ClinacaApi.Consultation.repository;

import com.voll.ClinacaApi.Consultation.model.Consultion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultRepository extends JpaRepository<Consultion, Long> {

    boolean existsByDoctorIdAndData(Long idDoctor, LocalDateTime data);

    boolean existsByPatientIdAndDataBetween(Long id, LocalDateTime firstHours, LocalDateTime lastHours);
}
