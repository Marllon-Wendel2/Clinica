package com.voll.ClinacaApi.doctor.dtos;

import com.voll.ClinacaApi.Address.model.Address;
import com.voll.ClinacaApi.doctor.model.Doctor;

public record DataDetailsDoctor(Long id, String nome, String email, String crm, String telefone,Especialidade especialidade, Address endereco) {

    public DataDetailsDoctor(Doctor doctor) {
        this(doctor.getId(), doctor.getNome(), doctor.getEmail(), doctor.getCrm(),doctor.getTelefone(), doctor.getEspecialidade(), doctor.getEndereco());
    }
}
