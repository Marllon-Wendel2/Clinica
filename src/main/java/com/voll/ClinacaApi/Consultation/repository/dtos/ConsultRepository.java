package com.voll.ClinacaApi.Consultation.repository.dtos;

import com.voll.ClinacaApi.Consultation.model.Consultion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultRepository extends JpaRepository<Consultion, Long> {
}
