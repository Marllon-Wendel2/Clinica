package com.voll.ClinacaApi.doctor.dtos;

import com.voll.ClinacaApi.doctor.model.Doctor;

public record DoctorListData(
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {

    public DoctorListData(Doctor doctor) {
        this(doctor.getNome(), doctor.getEmail(), doctor.getCrm(), doctor.getEspecialidade());
    }
}
