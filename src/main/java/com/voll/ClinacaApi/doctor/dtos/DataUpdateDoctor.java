package com.voll.ClinacaApi.doctor.dtos;

import com.voll.ClinacaApi.Address.AddressData;
import jakarta.validation.constraints.NotNull;

public record DataUpdateDoctor(
        @NotNull
        Long id,
        String nome,
        String telefone,
        AddressData endereco
) {
}
