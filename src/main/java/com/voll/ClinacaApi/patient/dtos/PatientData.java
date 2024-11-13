package com.voll.ClinacaApi.patient.dtos;

import com.voll.ClinacaApi.Address.AddressData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PatientData(

        @NotBlank
        String nome,

        @Email
        @NotBlank
        String email,

        @NotBlank
        String telefone,

        @NotNull
        @Valid
        String cpf,

        @NotNull
        @Valid
        AddressData endereco) {
}
