package com.voll.ClinacaApi.Consultation.dtos;

import com.voll.ClinacaApi.Consultation.model.Consultion;

import java.time.LocalDateTime;

public record DatailsOfConsult(
        Long id,
        Long idMedico,
        Long idPacient,
        LocalDateTime data
) {
    public DatailsOfConsult(Consultion consult) {
            this(consult.getId(), consult.getDoctor().getId(), consult.getPatient().getId(), consult.getData());
    }
}
