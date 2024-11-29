package com.voll.ClinacaApi.patient.dtos;

import jakarta.validation.constraints.NotNull;

public record DataUpadatePatient(
        @NotNull
        Long id,
        String nome,
        String telefone
) {
}
