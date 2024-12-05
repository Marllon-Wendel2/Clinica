package com.voll.ClinacaApi.Consultation.dtos;

import java.time.LocalDateTime;

public record DatailsOfConsult(
        Long id,
        Long idMedico,
        Long idPacient,
        LocalDateTime data
) {
}
