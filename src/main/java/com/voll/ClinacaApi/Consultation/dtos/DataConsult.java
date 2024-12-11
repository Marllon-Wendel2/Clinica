package com.voll.ClinacaApi.Consultation.dtos;

import com.voll.ClinacaApi.Consultation.model.Consultion;
import com.voll.ClinacaApi.doctor.dtos.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DataConsult(
        Long idDoctor,

        @NotNull
        Long idPacient,

        @NotNull
        @Future
        LocalDateTime data,

        Especialidade especialidade) {


}
