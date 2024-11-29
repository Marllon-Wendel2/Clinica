package com.voll.ClinacaApi.patient.dtos;

import com.voll.ClinacaApi.patient.model.Patient;

public record DataListPatient(Long id, String nome, String email, String telefone, String cpf) {

    public DataListPatient(Patient paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf());
    }
}
